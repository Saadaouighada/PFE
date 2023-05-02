package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class TestSearchFormScreenService extends ScreenService
{
   private static final String BEANID = "TestSearchFormScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("doSomething", "doSomething");
   }

   public ScreenServiceResponse doSomething(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      if (inParameters.get("result_selected") != null)
      {
         final Data result = inParameters.get("result_selected");

         if (result != null)
         {
            final String resultCol1 = (String) result.get("resultCol1");

            if ("ok".equals(resultCol1))
            {
               screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);
            }
            else
            {
               screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.ERROR);
               addErrorMessage(screenServiceResponse, "pas ok", "", "", null);
            }
         }
         else
         {
            screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.ERROR);
            addErrorMessage(screenServiceResponse, "result_selected vide", "", "", null);
         }
      }
      else
      {
         screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.ERROR);
         addErrorMessage(screenServiceResponse, "pas de ligne sélectionnée", "", "", null);
      }

      return screenServiceResponse;
   }
}
