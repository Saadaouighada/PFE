package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.log.Log4jLogger;
import com.linedata.ekip.commons.server.log.LogFactory;
import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLink;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLinkResponse;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Component
public class BookCreateFieldLinkService extends CustomFieldLink
{

   private static final String BEANID = "BookCreateFieldLinkService";

   private static Log4jLogger  logger = (Log4jLogger) LogFactory.getLog(BookCreateFieldLinkService.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public CustomFieldLinkResponse getType2FromType(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      logger.error(actionContext, "getType2FromType");
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      Data type = (Data) parameters.get("type");

      if (type == null)
      {
         response.setValue("");
      }
      else
      {
         response.setValue(type.get("label") + " 2");
      }

      return response;
   }

   public CustomFieldLinkResponse getAthor(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      logger.info(actionContext, "getAthor .....................");
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      AuthorData authorData = new AuthorData();
      authorData.set("id", 9);
      authorData.set("firstName", "FirstName9");
      authorData.set("lastName", "LastName9");

      response.setValue(authorData);

      return response;
   }

   public CustomFieldLinkResponse get2From1(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      String title = (String) parameters.get("title", "");

      response.setValue(title + " 2");

      return response;
   }

   public CustomFieldLinkResponse get3From1And2(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      // try
      // {
      // Thread.sleep(1000);
      // }
      // catch (InterruptedException e)
      // {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }

      String title = (String) parameters.get("title", "");
      String title2 = (String) parameters.get("title2", "");

      response.setValue(title + " " + title2 + " 3");

      return response;
   }

   public CustomFieldLinkResponse get4From1And2And3(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      String title = (String) parameters.get("title", "");
      String title2 = (String) parameters.get("title2", "");
      String title3 = (String) parameters.get("title3", "");

      response.setValue(title + " " + title2 + " " + title3 + " 4");

      return response;
   }

   public CustomFieldLinkResponse get5From1And2And3And4(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      String title = (String) parameters.get("title", "");
      String title2 = (String) parameters.get("title2", "");
      String title3 = (String) parameters.get("title3", "");
      String title4 = (String) parameters.get("title4", "");

      response.setValue(title + " " + title2 + " " + title3 + " " + title4 + " 5");

      return response;
   }
}
