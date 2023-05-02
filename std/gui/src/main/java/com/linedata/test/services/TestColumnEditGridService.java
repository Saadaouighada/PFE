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

@Component
public class TestColumnEditGridService implements GridService
{

   private static final String BEANID = "TestColumnEditGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   // @Timed
   @Override
   public List<? extends Data> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      List<Data> outData = new ArrayList<Data>();

      Data resultRow = new Data();
      resultRow.set("testColumnCheck", false);
      resultRow.set("testColumn1", "Ligne 1");
      resultRow.set("testColumn2", 100L);
      resultRow.set("testColumn3", 2000d);
      resultRow.set("testColumn2Check", false);
      Data hardcover = new Data();
      hardcover.set("id", "hardcover");
      hardcover.set("label", "hardcover");
      hardcover.set("nbPages", 1000);
      resultRow.set("type", hardcover);
      outData.add(resultRow);

      resultRow = new Data();
      resultRow.set("testColumnCheck", false);
      resultRow.set("testColumn1", "Ligne 2");
      resultRow.set("testColumn2", 200d);
      resultRow.set("testColumn3", 1000d);
      resultRow.set("testColumn2Check", false);
      Data ebook = new Data();
      ebook.set("id", "ebook");
      ebook.set("label", "ebook");
      ebook.set("nbPages", 500);
      resultRow.set("type", ebook);
      // Data testColumnRemoteLov = new Data();
      // testColumnRemoteLov.set("value", "EUR");
      // testColumnRemoteLov.set("label", "Euro");
      // resultRow.set("testColumnRemoteLov", testColumnRemoteLov);
      // resultRow.set("testColumnRemoteLov", "EUR");
      resultRow.set("test2ColumnProgress", 0.5d);
      outData.add(resultRow);

      return outData;
   }
}
