package com.linedata.ekip.pos.message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.filemanager.FileResourceManager;
import com.linedata.ekip.pos.bean.MessageBean;
import com.linedata.ekip.std.utils.file.FileUtils;

@Component
public class PropertiesManager
{
   /* bean id */
   public static final String               BEANID                   = "PropertiesManager";

   private static Log                       log                      = LogFactory.getLog(PropertiesManager.class);

   private static final String              MESSAGES_CUSTOM_LOCATION = "customMessages/";
   private static final String              MESSAGES_PATTERN         = ".+[\\.]messages(_[a-zA-Z0-9]+)*[\\.]properties";

   private FileResourceManager              fileResourceManager      = new FileResourceManager();

   private Map<String, Map<String, String>> languageMap;

   public MessageBean getMessage(String userLanguage, String key)
   {
      return getMessage(userLanguage, key, null);
   }

   private MessageBean getMessage(String userLanguage, String key, Object[] args)
   {
      MessageBean messageBean = new MessageBean();
      String message = null;

      if (languageMap.containsKey(userLanguage) && languageMap.get(userLanguage).containsKey(key))
      {
         message = languageMap.get(userLanguage).get(key);
      }
      else
      {
         // Message not found -> Display the message key
         message = key;
      }

      if (message == null)
      {
         return null;
      }

      if (args == null || args.length == 0)
      {
         messageBean.setMessage(message);
         return messageBean;
      }
      else
      {
         // Gestion des paramètres
         for (int i = 0; i < args.length; i++)
         {
            Object parameter = args[i];
            if (parameter != null)
            {
               String parameterS = parameter.toString();
               String charReplaced = "\\{" + i + "\\}";
               message = message.replaceAll(charReplaced, parameterS);
            }
         }
         messageBean.setMessage(message);
         return messageBean;
      }
   }

   public MessageBean getMessageBean(String userLanguage, String key, Object... args)
   {
      return getMessage(userLanguage, key, args);
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1 });
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1, Object o2)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1, o2 });
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1, Object o2, Object o3)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1, o2, o3 });
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1, Object o2, Object o3, Object o4)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1, o2, o3, o4 });
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1, Object o2, Object o3, Object o4, Object o5)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1, o2, o3, o4, o5 });
   }

   public MessageBean getMessage(String userLanguage, String key, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6)
   {
      return getMessage(userLanguage, key, new Object[]
      { o1, o2, o3, o4, o5, o6 });
   }

   @PostConstruct
   private void manageMap()
   {
      String propertiesLocation = "messages";
      String customPropertiesLocation = MESSAGES_CUSTOM_LOCATION;
      List<File> customMessagesFiles = null;

      languageMap = new HashMap<String, Map<String, String>>();

      // Step 1: Get files list of customs messages
      URL customPropertiesResourcesUrl = ClassLoader.getSystemClassLoader().getResource(customPropertiesLocation);
      if (customPropertiesResourcesUrl == null)
      {
         log.info("SystemClassLoader is null");
         customPropertiesResourcesUrl = this.getClass().getClassLoader().getResource(customPropertiesLocation);
      }
      if (customPropertiesResourcesUrl != null)
      {
         log.info("Messages ClassLoader File : " + customPropertiesResourcesUrl.getFile());
         try
         {
            File customRootDir = FileUtils.getFileFromURL(customPropertiesResourcesUrl);
            customMessagesFiles = fileResourceManager.getFiles(customRootDir, MESSAGES_PATTERN);
            log.info("Custom messages properties to process : " + customMessagesFiles.size());
         }
         catch (IOException e)
         {
            log.error(e.getMessage(), e);
         }
         catch (URISyntaxException e)
         {
            log.error(e.getMessage(), e);
         }

         // Step 2: Load custom messages Files
         for (File customFiles : customMessagesFiles)
         {
            String customFileName = customFiles.getName();

            // File not found in custom file but present in standard folder
            String languageCode = customFileName.substring(customFileName.indexOf("_") + 1, customFileName.indexOf(".", customFileName.indexOf("_")));
            log.info(languageCode + " : " + customFileName);

            if (!languageMap.containsKey(languageCode))
            {
               languageMap.put(languageCode, new HashMap<String, String>());
            }

            Properties properties = new Properties();
            try
            {
               properties.load(new FileInputStream(customFiles));
               for (Object key : properties.keySet())
               {
                  languageMap.get(languageCode).put((String) key, properties.getProperty((String) key));
               }
            }
            catch (FileNotFoundException e)
            {
               log.error(e, e);
            }
            catch (IOException e)
            {
               log.error(e, e);
            }
         }
      }
      else
      {
         log.warn("Custom messages properties folder not found ");
      }

      // Step 3: Get standard messages Files List
      URL propertiesResourcesUrl = ClassLoader.getSystemClassLoader().getResource(propertiesLocation);
      if (propertiesResourcesUrl == null)
      {
         log.info("SystemClassLoader is null");
         propertiesResourcesUrl = this.getClass().getClassLoader().getResource(propertiesLocation);
      }
      log.info("Messages ClassLoader File : " + propertiesResourcesUrl.getFile());

      List<File> messagesFiles = null;
      try
      {
         File rootDir = FileUtils.getFileFromURL(propertiesResourcesUrl);
         messagesFiles = fileResourceManager.getFiles(rootDir, MESSAGES_PATTERN);
         log.info("Messages properties to process : " + messagesFiles.size());
      }
      catch (IOException e)
      {
         log.error(e.getMessage(), e);
      }
      catch (URISyntaxException e)
      {
         log.error(e.getMessage(), e);
      }

      // Step 4: Load standard messages Files
      for (File f : messagesFiles)
      {
         String fileName = f.getName();
         boolean haveCustom = false;
         if (customMessagesFiles != null && customMessagesFiles.size() > 0)
         {
            for (File customFile : customMessagesFiles)
            {
               if (fileName.equals(customFile.getName()))
               {
                  haveCustom = true;
                  break;
               }
            }
         }
         if (!haveCustom)
         {
            // File not found in custom file but present in standard folder
            String languageCode = fileName.substring(fileName.indexOf("_") + 1, fileName.indexOf(".", fileName.indexOf("_")));
            log.info(languageCode + " : " + fileName);

            if (!languageMap.containsKey(languageCode))
            {
               languageMap.put(languageCode, new HashMap<String, String>());
            }

            Properties properties = new Properties();
            try
            {
               properties.load(new FileInputStream(f));
               for (Object key : properties.keySet())
               {
                  languageMap.get(languageCode).put((String) key, properties.getProperty((String) key));
               }
            }
            catch (FileNotFoundException e)
            {
               log.error(e, e);
            }
            catch (IOException e)
            {
               log.error(e, e);
            }
         }
      }
   }

   private final void getRecursiveFiles(File currentDirectory, List<File> filesList, String pattern)
   {
      if (currentDirectory.isDirectory())
      {
         for (File f : currentDirectory.listFiles())
         {
            if (f.isDirectory())
            {
               getRecursiveFiles(f, filesList, pattern);
            }
            else if (f.isFile() && f.getName().endsWith(pattern))
            {
               filesList.add(f);
            }
         }
      }
   }

   public final List<File> getFiles(File rootDirectory, String pattern)
   {
      ArrayList<File> filesList = new ArrayList<File>();
      if (rootDirectory.isDirectory())
      {
         for (File f : rootDirectory.listFiles())
         {
            if (f.isDirectory())
            {
               getRecursiveFiles(f, filesList, pattern);
            }
            else if (f.isFile() && f.getName().endsWith(pattern))
            {
               filesList.add(f);
            }
         }
      }
      return filesList;
   }
}
