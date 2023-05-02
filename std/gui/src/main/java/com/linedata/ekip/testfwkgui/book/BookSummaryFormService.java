package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;

@Component
public class BookSummaryFormService implements FormService
{

   private static final String BEANID = "BookSummaryFormService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Data provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      Data summaryData = screenContext.getEntity();
      summaryData.set("testProgress1", 0.25d);

      return summaryData;
   }
}
