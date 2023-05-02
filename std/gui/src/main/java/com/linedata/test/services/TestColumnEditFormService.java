package com.linedata.test.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;

@Component
public class TestColumnEditFormService implements FormService
{

   private static final String BEANID = "TestColumnEditFormService";

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

      if (LovEvent.GRIDAFTEREDIT.equals(event))
      {
         @SuppressWarnings("unchecked")
         List<Data> allData = (List<Data>) parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue());
         // String blockId = (String)
         // parameters.get(LovServiceParameter.BLOCKID.getValue());
         // String gridColumnId = (String)
         // parameters.get(LovServiceParameter.GRIDCOLUMNID.getValue());
         // int gridRowIndex = (Integer)
         // parameters.get(LovServiceParameter.GRIDROWINDEX.getValue());

         double sumTestColumn2 = 0d;
         for (Data rowData : allData)
         {
            Object testColumn2 = rowData.get("testColumn2", 0d);
            sumTestColumn2 += (Double) testColumn2;
         }
         outData.set("sumTestColumn2Field", sumTestColumn2);
         // outData.set("blockIdField", blockId);
         // outData.set("gridColumnIdField", gridColumnId);
         // outData.set("gridRowIndexField", gridRowIndex);
      }
      else if (LovEvent.AFTERLOAD.equals(event))
      {
         outData.set("sumTestColumn2Field", 200);
      }
      else if (LovEvent.SELECTIONCHANGED.equals(event))
      {
         outData.set("sumTestColumn2Field", 100);
      }
      else if (LovEvent.VALUECHANGED.equals(event))
      {
         for (int i = 0; i < 100000; i++)
         {
            System.out.println("test : " + i);
         }
      }
      else
      {
         outData.set("sumTestColumn2Field", 300d);
         outData.set("blockIdField", "blockId");
         outData.set("gridColumnIdField", "columnId");
         outData.set("gridRowIndexField", 0);
         outData.set("currency", "JPY");
      }

      return outData;
   }
}
