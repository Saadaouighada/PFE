package com.linedata.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.TreeGridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;

@Component
public class TestTreeGridService implements TreeGridService
{

   private static final String BEANID = "TestTreeGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<? extends Data> provideChildrenTreeGridData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext,
            Data inParameters, FunctionalContext functionalContext)
   {
      List<Data> outData = new ArrayList<Data>();
      Data parent = inParameters.get(LovServiceParameter.TREEGRIDPARENTNODE.getValue());
      if (parent == null)
      {
         Data resultRow = new Data();
         resultRow.set("treeCol1", "root 1 colonne 1");
         resultRow.set("treeCol2", "root 1 colonne 2");
         resultRow.set("treeCol3", "root 1 colonne 3");
         resultRow.set("treeCol4", "root 1 colonne 4");
         resultRow.set("treeCol5", "root 1 colonne 5");
         resultRow.set("id", "KR1");
         resultRow.set(LovServiceParameter.HASCHILDREN.getValue(), true);
         resultRow.set(LovServiceParameter.HIGHTLIGHTFLAG.getValue(), true);
         outData.add(resultRow);

         Data resultRow2 = new Data();
         resultRow2.set("treeCol1", "root 2 colonne 1");
         resultRow2.set("treeCol2", "root 2 colonne 2");
         resultRow2.set("treeCol3", "root 2 colonne 3");
         resultRow2.set("treeCol4", "root 2 colonne 4");
         resultRow2.set("treeCol5", "root 2 colonne 5");
         resultRow2.set("id", "KR2");
         resultRow2.set(LovServiceParameter.HASCHILDREN.getValue(), true);
         outData.add(resultRow2);
      }
      else
      {
         String treeCol1 = (String) parent.get("treeCol1");
         if ("root 1 colonne 1".equals(treeCol1))
         {
            Data resultRow = new Data();
            resultRow.set("treeCol1", "child 11 colonne 1");
            resultRow.set("treeCol2", "child 11 colonne 2");
            resultRow.set("treeCol3", "child 11 colonne 3");
            resultRow.set("treeCol4", "child 11 colonne 4");
            resultRow.set("treeCol5", "child 11 colonne 5");
            resultRow.set("id", "KRC11");
            outData.add(resultRow);
            resultRow = new Data();
            resultRow.set("treeCol1", "child 12 colonne 1");
            resultRow.set("treeCol2", "child 12 colonne 2");
            resultRow.set("treeCol3", "child 12 colonne 3");
            resultRow.set("treeCol4", "child 12 colonne 4");
            resultRow.set("treeCol5", "child 12 colonne 5");
            resultRow.set("id", "KRC12");
            outData.add(resultRow);
         }
         else if ("root 2 colonne 1".equals(treeCol1))
         {
            Data resultRow = new Data();
            resultRow.set("treeCol1", "child 21 colonne 1");
            resultRow.set("treeCol2", "child 21 colonne 2");
            resultRow.set("treeCol3", "child 21 colonne 3");
            resultRow.set("treeCol4", "child 21 colonne 4");
            resultRow.set("treeCol5", "child 21 colonne 5");
            resultRow.set("id", "KRC21");
            outData.add(resultRow);
            resultRow = new Data();
            resultRow.set("treeCol1", "child 22 colonne 1");
            resultRow.set("treeCol2", "child 22 colonne 2");
            resultRow.set("treeCol3", "child 22 colonne 3");
            resultRow.set("treeCol4", "child 22 colonne 4");
            resultRow.set("treeCol5", "child 22 colonne 5");
            resultRow.set("id", "KRC22");
            outData.add(resultRow);
         }
         {

         }
      }
      return outData;
   }
}
