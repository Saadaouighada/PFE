package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.commons.shared.lov.LovRedirectTargetType;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiOpenFunction;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.testfwkgui.book.Book;
import com.linedata.ekip.testfwkgui.book.Books;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class TestFormScreenService extends ScreenService
{
   private static final String BEANID = "TestFormScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("testScreenAction", "testScreenAction");
      getActionMappings().put("testScreenActionJavaPostAction", "testScreenActionJavaPostAction");
   }

   public ScreenServiceResponse testScreenAction(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      // addErrorMessage(screenServiceResponse, "Error to display", "valeurMax",
      // "testForm", 1);
      // String baseUrl = "https://www.google.fr/search";
      // Map<String, String> queryString = new HashMap<String, String>();
      // queryString.put("q", "linedatu");
      //
      // AsiOpenExternal openExternal = new AsiOpenExternal();
      // openExternal.setBaseUrl(baseUrl);
      // openExternal.setQueryString(queryString);
      //
      // screenServiceResponse.addPostAction(openExternal);

      // AsiCloseScreen close = new AsiCloseScreen();
      // close.setSortNumber(0);
      // screenServiceResponse.addPostAction(close);
      // AsiRefreshFatherScreen refreshFatherScreen = new
      // AsiRefreshFatherScreen();
      // refreshFatherScreen.setSortNumber(1);
      // screenServiceResponse.addPostAction(refreshFatherScreen);

      if (inParameters.get("testColumnEditGrid2_selected") != null)
      {
         final Data result = inParameters.get("testColumnEditGrid2_selected");

         if (result != null)
         {
            String fieldToFocus = "fieldToFocus";
            String formToFocus = "formToFocus";
         }
      }

      Book book = Books.findById(1L);
      BookData bookData = new BookData();
      bookData.set("id", (int) book.getId());
      bookData.set("title", book.getTitle());
      bookData.set("nbPages", book.getNbPages());
      screenServiceResponse.getScreenContext().setEntity(bookData);

      // Call method that creates an asiOpenFunction object.

      // add object zone refresh post action
      // if (refreshObjectZone)
      // {
      // screenServiceResponse.getScreenPostActions().add(createAsiRefreshObjectZone(0));
      // }
      // // computing new screen context.
      // if (isNewContext && entityData != null)
      // {
      //
      // setNewScreenContext(screenServiceResponse, entityData);
      // }
      // add created post actions to screen service response.

      // AsiOpenFunction asiOpenFunction = getAsiOpenFunction("testAsiAction",
      // "TestColumnEdit", LovOpenFunctionMode.CREATE, null, 0, false, false);
      // asiOpenFunction.setBlockToFocusOn("testColumnEditForm");
      // asiOpenFunction.setFieldToFocusOn("gridColumnIdField");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);
      // screenServiceResponse.getScreenPostActions().add(asiOpenFunction);

      return screenServiceResponse;
   }

   public ScreenServiceResponse testScreenActionJavaPostAction(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      if (inParameters.get("testColumnEditGrid2_selected") != null)
      {
         final Data result = inParameters.get("testColumnEditGrid2_selected");

         if (result != null)
         {
            String fieldToFocus = "fieldToFocus";
            String formToFocus = "formToFocus";
         }
      }

      AsiOpenFunction asiOpenFunction = getAsiOpenFunction("testAsiAction", "TestColumnEdit", LovOpenFunctionMode.CREATE, null, 0, false, false);
      asiOpenFunction.setFormToFocusOn("testColumnEditForm");
      asiOpenFunction.setFieldToFocusOn("gridColumnIdField");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse.getScreenPostActions().add(asiOpenFunction);
      return screenServiceResponse;
   }

   private AsiOpenFunction getAsiOpenFunction(String xmlId, String functionId, LovOpenFunctionMode openFunctionMode, LovContextType contextType, int sortNumber,
            boolean closeActiveFunction, boolean isModal)
   {
      // creation of asi open function object.
      AsiOpenFunction asiOpenFunction = new AsiOpenFunction();

      // set screen XML identifier
      asiOpenFunction.setFunctionId(functionId);

      // set open function mode
      if (openFunctionMode != null)
      {
         asiOpenFunction.setOpenFunctionMode(openFunctionMode);
      }
      // set context type
      if (contextType != null)
      {
         asiOpenFunction.setContext(contextType);
      }
      // Sort post action sort number
      if (sortNumber > 0)
      {
         asiOpenFunction.setSortNumber(sortNumber);
      }
      else
      {
         asiOpenFunction.setSortNumber(1);
      }
      // set close active function indicator.if true then the current screen
      // will be closed else it remains opened.
      asiOpenFunction.setCloseActiveFunction(closeActiveFunction);

      // asiOpenFunction.setFieldToFocus("fieldId");
      // asiOpenFunction.setFieldBlockToFocus("blockId");

      // set post action id
      if (xmlId != null)
      {
         asiOpenFunction.setId(xmlId);
      }
      // set target as redirection type if we are about to open a pop up screen.
      if (isModal)
      {
         asiOpenFunction.setTarget(LovRedirectTargetType.MODAL);
      }
      return asiOpenFunction;
   }
}
