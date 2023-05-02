package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLink;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLinkResponse;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;

@Component
public class TestColumnEditGridFieldLinkService extends CustomFieldLink
{

   private static final String BEANID = "TestColumnEditGridFieldLinkService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public CustomFieldLinkResponse get1FromCheck(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      boolean testColumnCheck = (Boolean) parameters.get("testColumnCheck", false);

      response.setValue(testColumnCheck ? "checked" : "pas checked");

      return response;
   }

   public CustomFieldLinkResponse unlock2FromCheck(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      boolean testColumnCheck = (Boolean) parameters.get("testColumnCheck", false);

      response.setValue(!testColumnCheck);

      return response;
   }

   public CustomFieldLinkResponse get3From1(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      String testColumn1 = (String) parameters.get("testColumn1", "oups");

      response.setValue(testColumn1.equals("checked") ? 1d : 0d);

      return response;
   }
}
