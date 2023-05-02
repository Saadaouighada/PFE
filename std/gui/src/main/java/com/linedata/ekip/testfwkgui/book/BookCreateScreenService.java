package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiCloseScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiOpenFunction;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.core.shared.message.ScreenMessage;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookCreateScreenService extends ScreenService
{
   private static final String BEANID = "BookCreateScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("save", "save");
   }

   public ScreenServiceResponse save(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      Data bookCreateForm = (Data) inParameters.get("bookCreateFormAdvanced");
      if (bookCreateForm == null)
      {
         bookCreateForm = (Data) inParameters.get("bookCreateForm");
      }

      String title = (String) bookCreateForm.get("title");
      Integer nbPages = (Integer) bookCreateForm.get("nbPages");
      if (nbPages == null)
      {
         nbPages = 0;
      }

      int id = Books.getNextId();
      Book book = new Book(id, title, nbPages);
      Books.save(book);

      book = Books.findById(id);
      BookData bookData = new BookData();
      // GenericEntityData genericBookData = bookData.initGenericEntityData();

      bookData.set("id", (int) book.getId());
      bookData.set("title", book.getTitle());
      bookData.set("nbPages", book.getNbPages());

      screenContext.setEntity(bookData);

      screenServiceResponse.addMessage(new ScreenMessage("Message save action"));

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      // List<String> functionIds = Arrays.asList("BookSearch", "AuthorCreate",
      // "TestMapping");
      // AsiRefreshScreens refreshScreens = new AsiRefreshScreens();
      // refreshScreens.setFunctionIds(functionIds);
      // screenServiceResponse.addPostAction(refreshScreens);

      // screenServiceResponse.addPostAction(new AsiCloseScreen());

      AsiOpenFunction asiOpenFunction = new AsiOpenFunction();
      asiOpenFunction.setId("toto");
      asiOpenFunction.setFunctionId("Book");
      asiOpenFunction.setOpenFunctionMode(LovOpenFunctionMode.READONLY);
      asiOpenFunction.setContext(LovContextType.ACTIONRESULT);
      screenServiceResponse.addPostAction(asiOpenFunction);
      AsiCloseScreen asiClose = new AsiCloseScreen();
      // asiClose.setNoDataModifiedChecking(true);
      screenServiceResponse.addPostAction(asiClose);
      return screenServiceResponse;

      // String fun360 = "Book";
      // return EntityActionUtils.createRedirection(screenServiceResponse,
      // screenContext.getEntity(), fun360, fun360,
      // LovOpenFunctionMode.READONLY, LovContextType.ACTIONRESULT, 1,
      // true, false, false, false);

   }
}
