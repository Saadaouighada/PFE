package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Component
public class AuthorSummaryFormService implements FormService
{

   private static final String BEANID = "AuthorSummaryFormService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public AuthorData provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      AuthorData summaryData = (AuthorData) screenContext.getEntity();

      return summaryData;
   }
}
