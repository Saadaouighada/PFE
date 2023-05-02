package com.linedata.test.services;

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

@Component
public class TestSearchFormResultGridService implements GridService
{

   private static final String BEANID = "TestSearchFormResultGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<? extends Data> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      List<Data> outData = new ArrayList<Data>();

      if (parameters != null)
      {
         final Data criteria = parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue(), null);

         if (criteria != null)
         {
            final Data resultRow = new Data();
            resultRow.set("resultCol1", criteria.get("criteria1"));
            resultRow.set("resultCol2", criteria.get("criteria1") + " en mieux");
            outData.add(resultRow);
         }
      }

      return outData;
   }
}
