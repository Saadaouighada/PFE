package com.linedata.ekip.std.services;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.entitydata.EntityRecoveryService;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.testfwkgui.book.Book;
import com.linedata.ekip.testfwkgui.book.Books;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookDataRecoveryServiceImpl implements EntityRecoveryService
{

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public String getEntityType()
   {
      return BookData.TYPE;
   }

   @Override
   public EntityData provideEntityData(ActionContext actionContext, Map<String, String> primaryKeys)
   {
      EntityData data = null;

      String id = primaryKeys.get("id");
      if (id != null)
      {
         Book book = Books.findById(Long.valueOf(id));

         if (book != null)
         {
            BookData bookData = new BookData();
            bookData.set("id", (int) book.getId());
            bookData.set("title", book.getTitle());
            bookData.set("nbPages", book.getNbPages());

            data = bookData;
         }
      }

      return data;
   }

}
