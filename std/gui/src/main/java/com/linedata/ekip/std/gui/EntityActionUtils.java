package com.linedata.ekip.std.gui;

import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.commons.shared.lov.LovRedirectTargetType;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiOpenFunction;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshObjectZone;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;

public class EntityActionUtils
{
   /**
    * creates an asi open function object which is a post action for opening a
    * new screen. It also updates the context with the entityData parameter. if
    * refreshObjectZone is true then it adds an object zone refresh to post
    * action list.
    * 
    * @param screenServiceResponse
    * @param entityData
    * @param xmlId
    * @param functionId
    * @param openFunctionMode
    * @param contextType
    * @param sortNumber
    * @param closeActiveFunction
    * @param isModal
    * @param refreshObjectZone
    * @param isNewContext
    * @return screenServiceResponse
    */
   public static ScreenServiceResponse createRedirectionCtx(ScreenServiceResponse screenServiceResponse, EntityData entityData, String xmlId, String functionId,
            LovOpenFunctionMode openFunctionMode, LovContextType contextType, int sortNumber, boolean closeActiveFunction, boolean isModal, boolean refreshObjectZone,
            boolean isNewContext)
   {
      // Call method that creates an asiOpenFunction object.
      AsiOpenFunction asiOpenFunction = getAsiOpenFunction(xmlId, functionId, openFunctionMode, contextType, sortNumber, closeActiveFunction, isModal);
      // add object zone refresh post action
      if (refreshObjectZone)
      {
         screenServiceResponse.getScreenPostActions().add(createAsiRefreshObjectZone(0));
      }
      // computing new screen context.
      if (isNewContext && entityData != null)
      {

         setNewScreenContext(screenServiceResponse, entityData);
      }
      // add created post actions to screen service response.
      screenServiceResponse.getScreenPostActions().add(asiOpenFunction);

      return screenServiceResponse;
   }

   /**
    * creates an asi open function object which is a post action for opening a
    * new screen. It also updates the context with the entityData parameter. if
    * refreshObjectZone is true then it adds an object zone refresh to post
    * action list.
    * 
    * @param screenServiceResponse
    * @param entityData
    * @param xmlId
    * @param functionId
    * @param openFunctionMode
    * @param contextType
    * @param sortNumber
    * @param closeActiveFunction
    * @param isModal
    * @param refreshObjectZone
    * @return screenServiceResponse
    */
   public static ScreenServiceResponse createRedirection(ScreenServiceResponse screenServiceResponse, EntityData entityData, String xmlId, String functionId,
            LovOpenFunctionMode openFunctionMode, LovContextType contextType, int sortNumber, boolean closeActiveFunction, boolean isModal, boolean refreshObjectZone)
   {
      return createRedirectionCtx(screenServiceResponse, entityData, xmlId, functionId, openFunctionMode, contextType, sortNumber, closeActiveFunction, isModal, refreshObjectZone,
               true);
   }

   /**
    * creates an asi open function object which is a post action for opening a
    * new screen. It also updates the context with the entityData parameter. if
    * refreshObjectZone is true then it adds an object zone refresh to post
    * action list.
    * 
    * @param screenServiceResponse
    * @param entityData
    * @param xmlId
    * @param functionId
    * @param openFunctionMode
    * @param contextType
    * @param sortNumber
    * @param closeActiveFunction
    * @param isModal
    * @param refreshObjectZone
    * @return screenServiceResponse
    */
   public static ScreenServiceResponse createRedirection(ScreenServiceResponse screenServiceResponse, EntityData entityData, String xmlId, String functionId,
            LovOpenFunctionMode openFunctionMode, LovContextType contextType, int sortNumber, boolean closeActiveFunction, boolean isModal, boolean refreshObjectZone,
            boolean isNewContext)
   {
      return createRedirectionCtx(screenServiceResponse, entityData, xmlId, functionId, openFunctionMode, contextType, sortNumber, closeActiveFunction, isModal, refreshObjectZone,
               isNewContext);
   }

   /**
    * Creates an asi open function object and sets all informations needed for
    * opening the target screen.
    * 
    * @param xmlId
    * @param functionId
    * @param openFunctionMode
    * @param contextType
    * @param sortNumber
    * @param closeActiveFunction
    * @return
    */
   private static AsiOpenFunction getAsiOpenFunction(String xmlId, String functionId, LovOpenFunctionMode openFunctionMode, LovContextType contextType, int sortNumber,
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

   /**
    * Creates an AsiRefreshObjectZone object. This object is interpreted as a
    * post action that makes a refresh of the object zone.
    * 
    * @param sortNumber
    * @return
    */
   public static AsiRefreshObjectZone createAsiRefreshObjectZone(int sortNumber)
   {
      // creation of asiRefreshObjectZone object
      AsiRefreshObjectZone asiRefreshObjectZone = new AsiRefreshObjectZone();
      // set sort number
      asiRefreshObjectZone.setSortNumber(sortNumber);
      return asiRefreshObjectZone;
   }

   /**
    * Assigns an EntityData to the screen context.
    * 
    * @param screenServiceResponse
    * @param entityData
    * @return
    */
   public static ScreenServiceResponse setNewScreenContext(ScreenServiceResponse screenServiceResponse, EntityData entityData)
   {
      // updating the screen context with entity data parameter.
      ScreenContext screenContext = new ScreenContext();
      screenContext.setEntity(entityData);
      screenServiceResponse.setScreenContext(screenContext);
      return screenServiceResponse;
   }
}
