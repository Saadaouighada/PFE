package com.linedata.testentity.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenEntityServiceImpl;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class TestEntityService extends ScreenEntityServiceImpl
{
   private static final String BEANID = "TestEntityService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public ScreenServiceResponse doSomething(ActionContext actionContext, EntityData entityData)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse();

      // String baseUrl = "https://www.google.fr/search";
      // Map<String, String> queryString = new HashMap<String, String>();
      // queryString.put("q", "linedata");
      //
      // AsiOpenExternal openExternal = new AsiOpenExternal();
      // openExternal.setBaseUrl(baseUrl);
      // openExternal.setQueryString(queryString);
      //
      // screenServiceResponse.addPostAction(openExternal);

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);

      return screenServiceResponse;
   }

   public boolean doSomethingValidationMethod(ActionContext actionContext, EntityData entityData)
   {
      return true;
   }

   public ScreenServiceResponse doSomethingElse(ActionContext actionContext, EntityData entityData)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse();

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);

      return screenServiceResponse;
   }

   public boolean doSomethingElseValidationMethod(ActionContext actionContext, EntityData entityData)
   {
      return true;
   }
}
