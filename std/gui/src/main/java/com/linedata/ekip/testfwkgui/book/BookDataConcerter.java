package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.entityconverter.EntityDataConverter;
import com.linedata.ekip.std.utils.ioc.BeanFactory;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookDataConcerter extends EntityDataConverter<BookReference, BookData>
{
   private static final String BEANID = "BookDataConcerter";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Class<BookReference> getEntityReferenceClass()
   {
      return BookReference.class;
   }

   @Override
   public Class<BookData> getEntityDataClass()
   {
      return BookData.class;
   }

   @Override
   public BookReference getEntityReference(BookData bookData)
   {
      BookReference bookReference = BeanFactory.buildBean(BookReference.class);
      Long id = bookData.getLongValue("id");
      bookReference.setId(id);
      return bookReference;
   }

   @Override
   public BookData getEntityData(ActionContext actionContext, BookReference bookReference)
   {
      BookData bookData = new BookData();
      Book book = Books.findById(bookReference.getId());
      bookData.set("id", (int) book.getId());
      bookData.set("title", book.getTitle());
      bookData.set("nbPages", book.getNbPages());
      return bookData;
   }

}
