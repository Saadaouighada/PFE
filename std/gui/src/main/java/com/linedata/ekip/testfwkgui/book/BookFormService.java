package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.testfwkgui.shared.AuthorData;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookFormService implements FormService
{

   private static final String BEANID = "BookFormService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   // @Timed
   @Override
   public BookData provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      BookData bookData = (BookData) screenContext.getEntity();

      AuthorData authorData = new AuthorData();
      authorData.set("id", new Long(1));
      authorData.set("firstName", "test");
      authorData.set("lastName", "author");
      authorData.set("age", 37);
      bookData.set("author", authorData);

      // StdComplexeValue cv = new StdComplexeValue();
      // cv.setCssClassName("book-title");
      // cv.setValue(bookData.get("title"));
      bookData.set("title", "book-title");

      return bookData;
   }
}
