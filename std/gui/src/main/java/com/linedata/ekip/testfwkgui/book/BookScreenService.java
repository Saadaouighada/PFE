package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiCloseFatherScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiCloseScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiDisplayErrors;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshFatherScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshSummaryView;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.testfwkgui.author.Author;
import com.linedata.ekip.testfwkgui.author.Authors;
import com.linedata.ekip.testfwkgui.shared.AuthorData;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookScreenService extends ScreenService
{
   private static final String BEANID = "BookScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("doSomething", "doSomething");
      getActionMappings().put("delBook", "delBook");
      getActionMappings().put("toAuthor", "toAuthor");
   }

   public ScreenServiceResponse doSomething(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      addErrorMessage(screenServiceResponse, "po lo lo, c'est pas bien ça !!!", "", "", null);
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      screenServiceResponse.addPostAction(new AsiDisplayErrors());
      screenServiceResponse.addPostAction(new AsiRefreshSummaryView());

      return screenServiceResponse;
   }

   public ScreenServiceResponse delBook(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      BookData bookData = (BookData) screenContext.getEntity();

      Book book = new Book();
      book.setId(bookData.getLongValue("id"));
      book.setTitle((String) bookData.get("title"));
      book.setNbPages((Integer) bookData.get("nbPages"));
      Books.del(book);

      // List<String> functionIds = Arrays.asList("BookSearch");
      // AsiRefreshScreens refreshScreens = new AsiRefreshScreens();
      // refreshScreens.setFunctionIds(functionIds);
      // screenServiceResponse.addPostAction(refreshScreens);

      screenServiceResponse.addPostAction(new AsiCloseFatherScreen());
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      return screenServiceResponse;
   }

   public ScreenServiceResponse toAuthor(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      AuthorData authorData = new AuthorData();
      Author author = Authors.findById(1L);
      authorData.set("id", author.getId());
      authorData.set("firstName", author.getFirstName());
      authorData.set("lastName", author.getLastName());

      // ScreenContext authorScreenContext = new ScreenContext(authorData);

      ScreenContext authorScreenContext = new ScreenContext();

      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      // AsiAddFunctionalContext asiAddFunctionalContext = new
      // AsiAddFunctionalContext();
      // FunctionalContextElement element = new FunctionalContextElement("test",
      // "toto");
      // asiAddFunctionalContext.getFunctionalContext().set(element);
      // screenServiceResponse.addPostAction(asiAddFunctionalContext);
      //
      // AsiOpenFunction asiOpenFunction = new AsiOpenFunction();
      // asiOpenFunction.setContext(LovContextType.COMPUTE);
      // asiOpenFunction.setFunctionId("AuthorSearch");
      // asiOpenFunction.setOpenFunctionMode(LovOpenFunctionMode.SEARCH);
      // asiOpenFunction.setTarget(LovRedirectTargetType.MODAL);
      // screenServiceResponse.addPostAction(asiOpenFunction);

      screenServiceResponse.addPostAction(new AsiCloseScreen());
      AsiRefreshFatherScreen postAction = new AsiRefreshFatherScreen();
      postAction.setRunSearch(true);
      screenServiceResponse.addPostAction(postAction);

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      return screenServiceResponse;
   }
}
