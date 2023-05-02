package com.linedata.testentity.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;

@Component
public class TestEntitySearchCriteriaFormService implements FormService
{

   private static final String BEANID = "TestEntitySearchCriteriaFormService";

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

      outData.set("criteria1", "critere1");

      return outData;
   }
}
