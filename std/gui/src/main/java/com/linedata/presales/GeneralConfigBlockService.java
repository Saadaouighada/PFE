package com.linedata.presales;

import org.apache.log4j.Logger;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;

public class GeneralConfigBlockService implements FormService
{
   private static final String BEANID = "GeneralConfigBlockService";
   private static final Logger LOG    = Logger.getLogger(GeneralConfigBlockService.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Data provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      Data data = new Data();
      Data contextData = screenContext.getEntity();
      if (contextData != null)
      {
         try
         {
            data.set("name", contextData.get("name"));
            data.set("language", contextData.get("language"));
            data.set("currency", contextData.get("currency"));
            data.set("color", contextData.get("color"));
            data.set("currencyFormat", contextData.get("currencyFormat"));
            data.set("dateFormat", contextData.get("dateFormat"));
            // data.set("logo", contextData.get("logo"));
         }
         catch (Exception e)
         {
            LOG.error(e);
         }
      }
      return data;

   }

}
