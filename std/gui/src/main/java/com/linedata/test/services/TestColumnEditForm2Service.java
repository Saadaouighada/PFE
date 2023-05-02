package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;

@Component
public class TestColumnEditForm2Service implements FormService
{

   private static final String BEANID = "TestColumnEditForm2Service";

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

      // if (LovEvent.GRIDAFTEREDIT.equals(event))
      // {
      // @SuppressWarnings("unchecked")
      // List<Data> allData = (List<Data>)
      // parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue());
      // String blockId = (String)
      // parameters.get(LovServiceParameter.BLOCKID.getValue());
      // String gridColumnId = (String)
      // parameters.get(LovServiceParameter.GRIDCOLUMNID.getValue());
      // int gridRowIndex = (Integer)
      // parameters.get(LovServiceParameter.GRIDROWINDEX.getValue());
      //
      // double sumTestColumn1 = 0d;
      // for (Data rowData : allData)
      // {
      // double testColumn3 = (Double) rowData.get("testColumn3", 0d);
      // boolean testColumnCheck = (Boolean) rowData.get("testColumnCheck",
      // false);
      // if (testColumnCheck)
      // {
      // sumTestColumn1 += testColumn3;
      // }
      // }
      // outData.set("sumTestColumn3Field", sumTestColumn1);
      // outData.set("blockIdField", blockId);
      // outData.set("gridColumnIdField", gridColumnId);
      // outData.set("gridRowIndexField", gridRowIndex);
      // }
      // else
      // {
      // outData.set("sumTestColumn3Field", 3000d);
      // }

      return outData;
   }
}
