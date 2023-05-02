package com.linedata.testentity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.GridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;
import com.linedata.ekip.testfwkgui.shared.TestData;

@Component
public class TestEntitySearchResultGridService implements GridService
{

   private static final String BEANID = "TestEntitySearchResultGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<TestData> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      List<TestData> outData = new ArrayList<TestData>();

      if (parameters != null)
      {
         final Data criteria = parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue(), null);

         if (criteria != null)
         {
            final TestData fkTestData = new TestData();
            fkTestData.set("id", "1");
            fkTestData.set("label", criteria.get("criteria1"));

            final TestData resultTestData = new TestData();
            resultTestData.set("fk", fkTestData);
            resultTestData.set("id", "1");
            resultTestData.set("label", criteria.get("criteria1"));
            resultTestData.set("description", "description de " + criteria.get("criteria1"));
            outData.add(resultTestData);
         }
      }

      return outData;
   }
}
