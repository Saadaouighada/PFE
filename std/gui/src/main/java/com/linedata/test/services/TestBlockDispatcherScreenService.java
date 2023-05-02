package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class TestBlockDispatcherScreenService extends ScreenService
{
   private static final String BEANID = "TestBlockDispatcherScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("testAction", "testAction");
   }

   public ScreenServiceResponse testAction(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);

      return screenServiceResponse;
   }
}
