package com.linedata.ekip.testfwkgui.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.extjs.gxt.ui.client.data.BaseFilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.RemoteGridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;
import com.linedata.ekip.testfwkgui.shared.AuthorData;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookSearchResultGridService implements RemoteGridService
{

   private static final String BEANID = "BookSearchResultGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public PagingLoadResult<BookData> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {

      List<BookData> outData = new ArrayList<BookData>();
      PagingLoadResult<BookData> result = new BasePagingLoadResult<BookData>(outData);
      BaseFilterPagingLoadConfig loadConfig = parameters.get(LovServiceParameter.LOADCONFIG.getValue());

      Data inParameters = parameters.get("DATASERVICEPARAMETER");

      Object bigLov = inParameters.get("testColumnRemoteLov");
      if (bigLov != null)
      {
         String lovVaue = ((Data) bigLov).get("value");
         System.err.println("lov value : " + lovVaue);
      }
      if (parameters != null)
      {
         final Data criteria = parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue(), null);

         if (criteria != null)
         {
            String titleCriteria = (String) criteria.get("title");

            List<Book> books = Books.findByTitle(titleCriteria);

            result.setTotalLength(books.size());
            result.setOffset(loadConfig.getOffset());

            for (Book book : books)
            {
               BookData bookData = new BookData();
               // GenericEntityData genericBookData =
               // bookData.initGenericEntityData();

               bookData.set("id", (int) book.getId());
               bookData.set("title", book.getTitle());
               bookData.set("nbPages", book.getNbPages());
               bookData.set("creationDate", new Date());
               bookData.set("price", new Double(1000000.66));
               bookData.set("percentage", new Double(9.6));

               final AuthorData resultTestData = new AuthorData();
               resultTestData.set("id", new Long(1));
               resultTestData.set("label", "Author 1");
               resultTestData.set("description", "description");

               bookData.set("author", resultTestData);

               outData.add(bookData);
            }
         }
      }

      return result;
   }
}
