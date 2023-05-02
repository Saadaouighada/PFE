package com.linedata.ekip.std.services.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linedata.ekip.core.server.screenservices.GenericSearchService;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityDataReference;
import com.linedata.ekip.testfwkgui.book.Book;
import com.linedata.ekip.testfwkgui.book.Books;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Service
public class BookGenericSearch implements GenericSearchService
{

   @Override
   public List<EntityDataReference> runGenericSearch(Data params)
   {
      String searchString = params.get("searchString");

      List<EntityDataReference> references = new ArrayList<EntityDataReference>();

      for (Book book : Books.findByTitle(searchString))
      {
         BookData bookData = new BookData();
         // GenericEntityData genericBookData =
         // bookData.initGenericEntityData();

         bookData.set("id", (int) book.getId());
         bookData.set("title", book.getTitle());
         bookData.set("nbPages", book.getNbPages());
         bookData.setSmallIconPath("images/icons/car.png");

         EntityDataReference reference = new EntityDataReference(bookData);

         reference.setDescription(bookData.getType() + " " + bookData.getDisplayName());
         references.add(reference);
      }

      return references;
   }

}
