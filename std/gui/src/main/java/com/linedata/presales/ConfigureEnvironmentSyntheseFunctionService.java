package com.linedata.presales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.std.gui.EntityActionUtils;
import com.linedata.ekip.testfwkgui.shared.TestData;
import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.ConfigEkipImpl;
import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.entities.impl.CurrencyImpl;
import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.entities.impl.ListTypesImpl;
import com.linedata.presales.entities.impl.SelectedServicesImpl;
import com.linedata.presales.entities.impl.ServicesImpl;
import com.linedata.presales.service.AllocationService;
import com.linedata.presales.service.ConfigEkipService;
import com.linedata.presales.service.CurrencyyService;
import com.linedata.presales.service.EnvironmentService;
import com.linedata.presales.service.LanguageService;
import com.linedata.presales.service.SelectedServicesService;
import com.linedata.presales.service.ServicesService;

public class ConfigureEnvironmentSyntheseFunctionService extends ScreenService
{
   public static final String                           BEANID              = "ConfigureEnvironmentSyntheseFunctionService";
   public static final String                           SCREENCONFIGGENERAL = "ConfigureEnvironmentGeneral";
   public static final String                           SCREENENVIRONMENT   = "Environment";
   public static String                                 CODE_CONFIGURED     = "CFG";
   public static String                                 SCRIPTS_DIRECTORY   = "\\..\\webapps\\ngapp\\WEB-INF\\scripts\\";

   public static String                                 ID_ASSET_LIST       = "1";
   public static String                                 ID_TIERS_LIST       = "2";
   private static final Logger                          LOG                 = Logger.getLogger(ConfigureEnvironmentSyntheseFunctionService.class);

   @Autowired
   EnvironmentService                                   environmentService;
   @Autowired
   ConfigEkipService                                    configEkipService;
   @Autowired
   CurrencyyService                                     currencyyService;
   @Autowired
   LanguageService                                      languageService;
   @Autowired
   SelectedServicesService                              selectedServicesService;
   @Autowired
   ServicesService                                      servicesService;
   @Autowired
   com.linedata.presales.service.ConfiguredListsService configuredListsService;
   @Autowired
   AllocationService                                    allocationService;
   @Autowired
   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("generate", "generate");
      getActionMappings().put("close", "close");
   }

   public static String executeCommand(String command)
   {
      StringBuffer output = new StringBuffer();
      Process process;
      try
      {
         process = Runtime.getRuntime().exec(command, null, null);
         process.waitFor();
         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
         String line = "";
         while ((line = reader.readLine()) != null)
         {
            output.append(line + "\n");
         }
      }
      catch (Exception e)
      {
         LOG.error(e);
      }
      return output.toString();
   }

   public ScreenServiceResponse generate(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
            throws SerialException, SQLException, IOException
   {

      final ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      Data contextData = screenContext.getEntity();
      LOG.info("save general config");
      ConfigEkipImpl config = new ConfigEkipImpl();
      config.setCompanyName(contextData.get("name"));
      Data data = contextData.get("language");
      LanguageImpl language = languageService.getByCode(data.get("id"));
      config.setLanguage(language);
      data = contextData.get("currency");
      CurrencyImpl currency = currencyyService.getByCode(data.get("id"));
      config.setCurrency(currency);
      data = contextData.get("currencyFormat");
      config.setCodeCurrencyFormat(data.get("value"));
      data = contextData.get("dateFormat");
      config.setCodeDateFormat(data.get("id"));
      data = contextData.get("color");
      config.setCodeColor(data.get("value"));

      InputStream in = getClass().getClassLoader().getResourceAsStream("logo.png");

      byte[] fileId = in.readAllBytes();
      Blob blob = new SerialBlob(fileId);
      config.setCompanyLogo(blob);

      AllocationImpl allocation = allocationService.getOne(Long.parseLong(contextData.get("idAllocation")));
      config.setAllocation(allocation);
      config.setIdExterne("TEST");
      configEkipService.save(config);
      LOG.info("update allocation status");
      allocation.setCodeStatus(CODE_CONFIGURED);
      long id = allocation.getEnvironment().getIdEnvironment();
      LOG.info("update environment status");
      allocationService.update(allocation);

      EnvironmentImpl environment = environmentService.getOne(id);
      String directory = environment.getApplicationServerDirectory();
      String server = environment.getApplicationServer();
      String dataBaseName = environment.getDatabaseName();
      String os = System.getProperty("os.name");

      String userDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
      String path = userDirectory + SCRIPTS_DIRECTORY;

      String cmdExterne = path + "script.sh ekip " + server + " " + path + "data\\logo.9810923d65c99bd1.webp " + directory;

      String cmdInterne = path + "script.sh ekip " + server + " " + path + "data\\login_logo.7ce66484c477abec.webp " + directory;

      String cmdLanguage = path + "Language.sh " + language.getCodeLanguage() + " " + path + " " + server + " " + dataBaseName;

      String cmdCurrency = path + "Cuurency.sh " + config.getCompanyName() + " " + currency.getCodeCurrency() + " " + path + " " + server + " " + dataBaseName;

      if (os.toLowerCase().contains("windows"))
      {
         executeShellScripts("cmd.exe /c ", "bash " + cmdExterne, "bash " + cmdInterne, "bash " + cmdCurrency, "bash " + cmdLanguage);
      }
      else if (os.toLowerCase().contains("linux"))
      {
         executeShellScripts("/bin/sh -c ", "./ " + cmdExterne, "./ " + cmdInterne, "./ " + cmdCurrency, "./ " + cmdLanguage);
      }

      LOG.info("save selected services");
      ArrayList<Data> checkListServices = contextData.get("checkListServices");
      ArrayList<Data> checkListAddedServices = new ArrayList<Data>();
      if (checkListServices != null)
      {
         for (Data checkedList : checkListServices)
         {
            if (Boolean.TRUE.equals((Boolean) checkedList.get("checkbox")))
            {
               checkListAddedServices.add(checkedList);
            }
         }
      }
      if (!checkListAddedServices.isEmpty())
      {
         ArrayList<String> idExternesList = new ArrayList();
         for (Data checkAddedList : checkListAddedServices)
         {
            idExternesList.add(checkAddedList.get("id"));
         }
         if (!idExternesList.isEmpty())
         {
            List<ServicesImpl> servicesList = servicesService.getByListIdExterne(idExternesList);
            int i = 0;
            List<SelectedServicesImpl> selectedServicesList = new ArrayList();
            for (ServicesImpl service : servicesList)
            {
               SelectedServicesImpl s = new SelectedServicesImpl(allocation, service, service.getIdExterne() + i);
               i++;
               selectedServicesList.add(s);
            }

            selectedServicesService.saveAll(selectedServicesList);
         }

      }
      LOG.info("save asset lists");
      ArrayList<Data> dataAssetList = new ArrayList();
      dataAssetList = contextData.get("ListAssetGrid");
      ArrayList<ConfiguredListsImpl> assetList = new ArrayList();
      if (dataAssetList != null)
      {
         for (Data d : dataAssetList)
         {
            ConfiguredListsImpl asset = new ConfiguredListsImpl();
            asset.setAllocation(new AllocationImpl(Long.parseLong(contextData.get("idAllocation"))));
            asset.setListType(new ListTypesImpl(Long.parseLong(ID_ASSET_LIST)));
            asset.setIdExterne("test");
            asset.setCode(d.get("code"));
            asset.setDescription(d.get("description"));
            assetList.add(asset);
         }

         if (!assetList.isEmpty())
         {
            configuredListsService.saveAll(assetList);
         }
      }
      LOG.info("save tiers lists");
      ArrayList<Data> dataTiersList = new ArrayList();
      dataTiersList = contextData.get("ListTiersGrid");
      ArrayList<ConfiguredListsImpl> tiersList = new ArrayList();
      if (dataTiersList != null)
      {
         for (Data d : dataTiersList)
         {
            ConfiguredListsImpl tiers = new ConfiguredListsImpl();
            tiers.setAllocation(new AllocationImpl(Long.parseLong(contextData.get("idAllocation"))));
            tiers.setListType(new ListTypesImpl(Long.parseLong(ID_TIERS_LIST)));
            tiers.setIdExterne("test");
            tiers.setCode(d.get("code"));
            tiers.setDescription(d.get("description"));
            tiersList.add(tiers);
         }

         if (!assetList.isEmpty())
         {
            configuredListsService.saveAll(tiersList);
         }
      }

      EntityData entityData = new TestData();
      screenServiceResponse.getScreenContext().setEntity(entityData);
      return EntityActionUtils.createRedirection(screenServiceResponse, entityData, SCREENENVIRONMENT, SCREENENVIRONMENT, LovOpenFunctionMode.READONLY, LovContextType.COMPUTE, 3,
               true, false, true, false);

   }

   public ScreenServiceResponse close(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      final ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      String previousScreen = contextData.get("contextData");
      return EntityActionUtils.createRedirection(screenServiceResponse, contextData, previousScreen, previousScreen, LovOpenFunctionMode.UPDATE, LovContextType.COMPUTE, 3, true,
               false, true, false);

   }

   private void executeShellScripts(String cmdOs, String cmdExterne, String cmdInterne, String cmdCurrency, String cmdLanguage)
   {
      String out = "";
      out = executeCommand(cmdOs + cmdExterne);
      if (!out.contains("100%"))
      {
         LOG.error("Failed Command cmdExterne");
      }
      out = executeCommand(cmdOs + cmdInterne);
      if (!out.contains("100%"))
      {
         LOG.error("Failed Command cmdInterne");
      }
      out = executeCommand(cmdOs + cmdCurrency);
      if (!out.contains("PL/SQL procedure successfully completed."))
      {
         LOG.error("Failed Command cmdCurrency");
      }
      out = executeCommand(cmdOs + cmdLanguage);
      if (!out.contains("PL/SQL procedure successfully completed."))
      {
         LOG.error("Failed Command cmdLanguage");
      }
   }
}
