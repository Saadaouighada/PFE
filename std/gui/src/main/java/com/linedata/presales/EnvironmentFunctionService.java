package com.linedata.presales;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
import com.linedata.ekip.std.gui.EntityActionUtils;
import com.linedata.ekip.testfwkgui.shared.TestData;
import com.linedata.presales.entities.impl.ConfigEkipImpl;
import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.entities.impl.CurrencyImpl;
import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.entities.impl.SelectedServicesImpl;
import com.linedata.presales.entities.impl.ServicesImpl;
import com.linedata.presales.service.ConfigEkipService;
import com.linedata.presales.service.CurrencyyService;
import com.linedata.presales.service.LanguageService;
import com.linedata.presales.service.SelectedServicesService;
import com.linedata.presales.service.ServicesService;

public class EnvironmentFunctionService extends ScreenService
{

   public static final String                           BEANID                  = "EnvironmentFunctionService";
   private static final Logger                          LOG                     = Logger.getLogger(EnvironmentFunctionService.class);

   public static final String                           SCREENCONFIGSYNTHESE    = "EnvironmentConfigurationDetailsSynthese";
   public static final String                           SCREENCONFIGUPDATE      = "ConfigureEnvironmentGeneral";
   public static final String                           SCREENENVIRONMENT       = "Environment";
   public static final String                           SCREENCREATEENVIRONMENT = "CreateEnvironment";
   public static String                                 CODE_INPROGRESS         = "INPRG";
   public static String                                 CODE_CONFIGURED         = "CFG";
   public static String                                 CODE_AC_SERVICE         = "AC";
   public static String                                 ID_ASSET_LIST           = "1";
   public static String                                 ID_TIERS_LIST           = "2";

   @Autowired
   ConfigEkipService                                    configEkipService;
   @Autowired
   CurrencyyService                                     currencyyService;
   @Autowired
   LanguageService                                      languageService;
   @Autowired
   SelectedServicesService                              selectedServicesService;
   @Autowired
   ServicesService                                      servicesService;
   @Autowired
   com.linedata.presales.service.ConfiguredListsService configuredListsService;
   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("toCreateEnvironment", "toCreateEnvironment");
      getActionMappings().put("environmentStatusDetails", "environmentStatusDetails");
      getActionMappings().put("toEnvironment", "toEnvironment");
   }

   public ScreenServiceResponse toEnvironment(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      return EntityActionUtils.createRedirection(screenServiceResponse, null, SCREENENVIRONMENT, SCREENENVIRONMENT, LovOpenFunctionMode.READONLY, LovContextType.COMPUTE, 1, true,
               false, true);
   }

   public ScreenServiceResponse toCreateEnvironment(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      return EntityActionUtils.createRedirection(screenServiceResponse, null, SCREENCREATEENVIRONMENT, SCREENCREATEENVIRONMENT, LovOpenFunctionMode.CREATE, LovContextType.COMPUTE,
               1, false, true, true);
   }

   public ScreenServiceResponse environmentStatusDetails(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      final ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      Data dataGrid = (Data) inParameters.get("EnvironmentStatusHistoryGrid_selected");
      TestData data = new TestData();
      data.set("idAllocation", dataGrid.get("idAllocation"));
      if (dataGrid.get("status").toString().equals(CODE_CONFIGURED))
      {
         ConfigEkipImpl config = configEkipService.getByIdAllocation(dataGrid.get("idAllocation"));
         data.set("name", config.getCompanyName());
         LanguageImpl language = languageService.getOne(config.getLanguage().getIdLanguage());
         data.set("language", setLovData(language.getIdExterne()));
         CurrencyImpl currency = currencyyService.getOne(config.getLanguage().getIdLanguage());
         data.set("currency", setLovData(currency.getIdExterne()));
         data.set("color", setLovData(config.getCodeColor()));
         data.set("currencyFormat", setLovData(config.getCodeCurrencyFormat()));
         data.set("dateFormat", setLovData(config.getCodeDateFormat()));
         // data.set("logo", config.getCompanyLogo());

         List<SelectedServicesImpl> selectedServicesList = selectedServicesService.getByIdAllocation(dataGrid.get("idAllocation"));
         List<Long> idsList = new ArrayList();
         for (SelectedServicesImpl s : selectedServicesList)
         {
            idsList.add(s.getService().getIdService());
         }
         List<ServicesImpl> servicesList = servicesService.getByListId(idsList);
         List<Data> checkListServices = new ArrayList();
         for (ServicesImpl s : servicesList)
         {
            Data d = new Data();
            d.set("description", s.getDescription());
            d.set("checkbox", Boolean.TRUE);
            checkListServices.add(d);
         }
         data.set("checkListServices", checkListServices);
         data.set("previousScreen", "environmentList");

         // 1 == asset List id ( waiting for architecture confirmation)
         List<ConfiguredListsImpl> assetList = configuredListsService.getByIdListTypeAndByIdAllocation(ID_ASSET_LIST, dataGrid.get("idAllocation"));
         List<Data> listAssetGrid = new ArrayList();
         for (ConfiguredListsImpl c : assetList)
         {
            Data asset = new Data();
            asset.set("code", c.getCode());
            asset.set("description", c.getDescription());
            listAssetGrid.add(asset);
         }
         data.set("ListAssetGrid", listAssetGrid);

         // 2 == asset List id ( waiting for architecture confirmation)
         List<ConfiguredListsImpl> tiersList = configuredListsService.getByIdListTypeAndByIdAllocation(ID_TIERS_LIST, dataGrid.get("idAllocation"));
         List<Data> listTiersGrid = new ArrayList();
         for (ConfiguredListsImpl c : tiersList)
         {
            Data tiers = new Data();
            tiers.set("code", c.getCode());
            tiers.set("description", c.getDescription());
            listTiersGrid.add(tiers);
         }
         data.set("ListTiersGrid", listTiersGrid);

      }

      screenServiceResponse.addMessage(new ScreenMessage("Opening environment details"));
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);
      String ScreenId = SCREENCONFIGSYNTHESE;
      AsiOpenFunction asiOpenFunction = new AsiOpenFunction();
      if (dataGrid.get("status").toString().equals(CODE_INPROGRESS))
      {
         ArrayList<Data> checkListServices = new ArrayList();
         List<ServicesImpl> servicesList = servicesService.getByIdProdcutByCodeStatus(1, CODE_AC_SERVICE);
         for (ServicesImpl s : servicesList)
         {
            Data d = new Data();
            d.set("description", s.getDescription());
            d.set("id", s.getIdExterne());
            checkListServices.add(d);
         }
         data.set("checkListServices", checkListServices);
         ScreenId = SCREENCONFIGUPDATE;
         asiOpenFunction.setOpenFunctionMode(LovOpenFunctionMode.CREATE);
         asiOpenFunction.setContext(LovContextType.COMPUTE);
      }
      else
      {
         asiOpenFunction.setOpenFunctionMode(LovOpenFunctionMode.READONLY);
         asiOpenFunction.setContext(LovContextType.SCREEN);
      }
      screenContext.setEntity(data);
      asiOpenFunction.setId(ScreenId);
      asiOpenFunction.setFunctionId(ScreenId);
      screenServiceResponse.addPostAction(asiOpenFunction);
      AsiCloseScreen asiClose = new AsiCloseScreen();
      screenServiceResponse.addPostAction(asiClose);
      screenServiceResponse.getScreenContext().setEntity(data);
      return screenServiceResponse;
   }

   Data setLovData(String value)
   {
      Data data = new Data();
      data.set("id", "1");
      data.set("value", value);
      return data;
   }

}
