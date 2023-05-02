package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiDisplayErrors;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshSummaryView;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class AuthorScreenService extends ScreenService
{
   private static final String BEANID = "AuthorScreenService";

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

      addErrorMessage(screenServiceResponse, "po lo lo, c'est pas bien ça !!!", "", "", null);
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      screenServiceResponse.addPostAction(new AsiDisplayErrors());
      screenServiceResponse.addPostAction(new AsiRefreshSummaryView());

      return screenServiceResponse;
   }
}
