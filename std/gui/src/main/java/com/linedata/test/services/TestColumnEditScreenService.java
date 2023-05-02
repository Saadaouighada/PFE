package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshCurrentComponent;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class TestColumnEditScreenService extends ScreenService
{
   private static final String BEANID = "TestColumnEditScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("testScreenAction", "testScreenAction");
   }

   public ScreenServiceResponse testScreenAction(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      screenServiceResponse.addPostAction(new AsiRefreshCurrentComponent());
      // ScreenError error = new
      // RemoteScreenError("Erreur ! Erreur !! Erreur !!!", null, null, null);
      // screenServiceResponse.addError(error);
      // error = new RemoteScreenError("Erreur 2 ! Erreur 2 !! Erreur 2 !!!",
      // null, null, null);
      // screenServiceResponse.addError(error);
      // screenServiceResponse.addPostAction(new AsiDisplayErrors());
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      return screenServiceResponse;
   }
}
