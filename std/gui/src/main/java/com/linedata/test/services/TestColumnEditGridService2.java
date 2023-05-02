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
import com.linedata.ekip.testfwkgui.book.Book;
import com.linedata.ekip.testfwkgui.book.Books;
import com.linedata.ekip.testfwkgui.shared.BookData;
import com.linedata.ekip.testfwkgui.shared.TestGridLine;

@Component
public class TestColumnEditGridService2 implements GridService
{

   private static final String BEANID = "TestColumnEditGridService2";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   // @Timed
   @Override
   public List<TestGridLine> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      List<TestGridLine> outData = new ArrayList<TestGridLine>();

      int nbLines = 4;

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

         for (int i = 0; i < nbLines; i++)
         {
            TestGridLine resultRow = new TestGridLine();
            resultRow.set("id", i);
            resultRow.set("test2Column2", sumTestColumn2);
            outData.add(resultRow);
         }
      }
      else
      {
         for (int i = 0; i < nbLines; i++)
         {
            BookData bookData = new BookData();
            Book book = Books.findByTitle("Book 1").get(0);
            bookData.set("id", book.getId());
            bookData.set("title", book.getTitle());
            bookData.set("nbPages", book.getNbPages());
            TestGridLine resultRow = new TestGridLine();
            resultRow.set("id", i);
            resultRow.set("test2Column1", "colonne " + (i % 2 == 0 ? 1 : 2));
            resultRow.set("test2Column2", nbLines - i);
            resultRow.set("test2Column3", 10d);
            resultRow.set("test2ColumnProgress", 0.24f
            /* new Double(i + 1) / nbLines */
            );
            resultRow.set("test2ColumnBook", bookData);
            resultRow.set("test2Currency", "JPY");
            resultRow.set(LovServiceParameter.NODELETEFLAG.getValue(), i % 2 == 0);
            outData.add(resultRow);
         }
      }

      return outData;
   }
}
