package com.linedata.testentity.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.testfwkgui.shared.TestData;

@Component
public class TestEntityFormService implements FormService
{

   private static final String BEANID = "TestEntityFormService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public TestData provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
	   TestData testData = new TestData();
	   if (screenContext.getEntity() instanceof TestData)
	   {
		   testData = (TestData) screenContext.getEntity();
	   }

	   return testData;
   }
}
