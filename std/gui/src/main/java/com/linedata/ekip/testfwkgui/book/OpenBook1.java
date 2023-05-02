package com.linedata.ekip.testfwkgui.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.GlobalMenuServiceWithMessage;
import com.linedata.ekip.core.shared.data.StdEntityDataResponse;
import com.linedata.ekip.core.shared.message.ScreenMessage;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class OpenBook1 implements GlobalMenuServiceWithMessage
{

   @Autowired
   private BookDataConcerter bookDataConcerter;

   @Override
   public String getBeanId()
   {
      return "OpenBook1";
   }

   @Override
   public StdEntityDataResponse computeWithResponse(ActionContext actionContext)
   {
      StdEntityDataResponse stdEntityDataResponse = new StdEntityDataResponse();
      Book book = Books.findById(1L);
      BookData bookData = new BookData();
      bookData.set("id", (int) book.getId());
      bookData.set("title", book.getTitle());
      bookData.set("nbPages", book.getNbPages());
      stdEntityDataResponse.setEntityData(bookData);
      List<ScreenMessage> screenMessages = new ArrayList<ScreenMessage>();
      screenMessages.add(new ScreenMessage("test message after opening book 1"));
      stdEntityDataResponse.setScreenMessages(screenMessages);
      return stdEntityDataResponse;
   }

}
