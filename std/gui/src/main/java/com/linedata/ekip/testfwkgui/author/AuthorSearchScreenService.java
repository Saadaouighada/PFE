package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiCloseScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiOpenFunction;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class AuthorSearchScreenService extends ScreenService
{
   private static final String BEANID = "AuthorSearchScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("createAuthor", "createAuthor");
   }

   public ScreenServiceResponse createAuthor(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      AsiCloseScreen closeScreen = new AsiCloseScreen();
      closeScreen.setSortNumber(1);
      screenServiceResponse.addPostAction(closeScreen);

      AsiOpenFunction openFunction = new AsiOpenFunction();
      openFunction.setFunctionId("AuthorCreate");
      openFunction.setOpenFunctionMode(LovOpenFunctionMode.CREATE);
      openFunction.setSortNumber(2);
      screenServiceResponse.addPostAction(openFunction);

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      return screenServiceResponse;
   }
}
