package com.linedata.presales;

import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.std.gui.EntityActionUtils;

import antlr.collections.List;

public class ConfigureEnvironmentUpdateFunctionService extends ScreenService
{
   public static final String SCREENCONFIGGENERAL     = "ConfigureEnvironmentGeneral";
   public static final String SCREENCONFIGSERVICES    = "ConfigureEnvironmentServices";
   public static final String SCREENCONFIGLISTS       = "ConfigureEnvironmentLists";
   public static final String BEANID                  = "ConfigureEnvironmentUpdateFunctionService";
   public static final String SCREENCONFIGSYNTHESE    = "ConfigureEnvironmentSynthese";
   public static final String SCREENPRECONFIGUREDlIST = "ConfigurePreconfiguredLists";

   private String             currentScreen           = "general";
   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("general", "general");
      getActionMappings().put("lists1", "lists1");
      getActionMappings().put("lists2", "lists2");
      getActionMappings().put("services", "services");
      getActionMappings().put("generate", "generate");
      getActionMappings().put("selectPL", "selectPL");
   }

   public ScreenServiceResponse general(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      if (inParameters != null)
      {
         contextData = this.setData(contextData, inParameters);
      }
      this.setCurrentScreen("general");
      contextData.set("previousScreen", "general");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENCONFIGGENERAL, SCREENCONFIGGENERAL, LovOpenFunctionMode.UPDATE,
               LovContextType.COMPUTE, 3, true, false, false, false);

      return screenServiceResponse;
   }

   public ScreenServiceResponse lists1(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      if (inParameters != null)
      {
         contextData = this.setData(contextData, inParameters);
      }
      this.setCurrentScreen("lists1");
      contextData.set("gridName", "lists1");
      contextData.set("previousScreen", "lists1");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENCONFIGLISTS, SCREENCONFIGLISTS, LovOpenFunctionMode.UPDATE,
               LovContextType.COMPUTE, 3, true, false, false, false);

      return screenServiceResponse;
   }

   public ScreenServiceResponse lists2(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      if (inParameters != null)
      {
         contextData = this.setData(contextData, inParameters);
      }
      this.setCurrentScreen("lists2");
      contextData.set("previousScreen", "lists2");
      contextData.set("gridName", "lists2");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENCONFIGLISTS, SCREENCONFIGLISTS, LovOpenFunctionMode.UPDATE,
               LovContextType.COMPUTE, 3, true, false, false, false);

      return screenServiceResponse;
   }

   public ScreenServiceResponse services(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      EntityData contextData = (EntityData) screenContext.getEntity();
      if (inParameters != null)
      {
         contextData = this.setData(contextData, inParameters);
      }
      this.setCurrentScreen("services");
      contextData.set("previousScreen", "services");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENCONFIGSERVICES, SCREENCONFIGSERVICES, LovOpenFunctionMode.UPDATE,
               LovContextType.COMPUTE, 3, true, false, false, false);

      return screenServiceResponse;
   }

   public ScreenServiceResponse generate(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      contextData.set("previousScreen", this.getCurrentScreen());
      if (inParameters != null)
      {
         contextData = this.setData(contextData, inParameters);
      }
      contextData.set("previousScreen", "Synthese");
      this.setCurrentScreen("Synthese");
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENCONFIGSYNTHESE, SCREENCONFIGSYNTHESE, LovOpenFunctionMode.READONLY,
               LovContextType.COMPUTE, 3, true, false, false, false);

      return screenServiceResponse;

   }

   public ScreenServiceResponse selectPL(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = (EntityData) screenContext.getEntity();
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      screenServiceResponse = EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENPRECONFIGUREDlIST, SCREENPRECONFIGUREDlIST, LovOpenFunctionMode.UPDATE,
               LovContextType.COMPUTE, 3, true, true, true, false);

      return screenServiceResponse;

   }

   private EntityData setGeneralData(EntityData contextData, Data genralData)
   {
      contextData.set("name", genralData.get("name"));
      contextData.set("language", genralData.get("language"));
      contextData.set("currency", genralData.get("currency"));
      contextData.set("color", genralData.get("color"));
      contextData.set("currencyFormat", genralData.get("currencyFormat"));
      contextData.set("dateFormat", genralData.get("dateFormat"));
//      FileItem fileItem = genralData.get("logo");
      contextData.set("logo", genralData.get("logo"));
      return contextData;
   }

   private EntityData setServicesData(EntityData contextData, ArrayList<Data> genralData)
   {
      contextData.set("checkListServices", genralData);
      return contextData;
   }

   private EntityData setListsData(EntityData contextData, ArrayList<Data> genralData)
   {
      ArrayList<Data> dataList = new ArrayList();
      for (Data d : genralData)
      {
         Data data = new Data();
         data.set("code", d.get("code"));
         data.set("description", d.get("description"));
         dataList.add(data);
      }
      if (this.currentScreen.equals("lists1")) contextData.set("ListAssetGrid", dataList);
      else if (this.currentScreen.equals("lists2")) contextData.set("ListTiersGrid", dataList);
      return contextData;
   }

   private EntityData setData(EntityData contextData, Data inParameters)
   {
      if (currentScreen.contains("general")) contextData = this.setGeneralData(contextData, inParameters.get("GeneralConfig"));
      else if (currentScreen.contains("services")) contextData = this.setServicesData(contextData, inParameters.get("ServiceGridUpdate"));
      else if (currentScreen.contains("lists1")) contextData = this.setListsData(contextData, inParameters.get("ListGridUpdate"));
      else if (currentScreen.contains("lists2")) contextData = this.setListsData(contextData, inParameters.get("ListGridUpdate"));
      return contextData;
   }

   public String getCurrentScreen()
   {
      return currentScreen;
   }

   public void setCurrentScreen(String currentScreen)
   {
      this.currentScreen = currentScreen;
   }

}
