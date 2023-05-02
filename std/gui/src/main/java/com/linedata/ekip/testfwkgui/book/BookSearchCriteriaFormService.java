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
public class BookSearchCriteriaFormService implements FormService
{

   private static final String BEANID = "BookSearchCriteriaFormService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Data provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      Data outData = new Data();

      for (int i = 1; i <= 10; i++)
      {
         Data biglov = new Data();
         biglov.set("id", "option" + i);
         biglov.set("label", "Option" + i);
         outData.set("biglov" + i, biglov);
      }

      return outData;
   }
}
