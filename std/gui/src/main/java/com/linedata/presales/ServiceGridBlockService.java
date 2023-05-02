package com.linedata.presales;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.GridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.lov.LovEvent;

public class ServiceGridBlockService implements GridService
{
   public static final String  BEANID = "ServiceGridBlockService";
   private static final Logger LOG    = Logger.getLogger(ServiceGridBlockService.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<? extends Data> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data inParameters,
            FunctionalContext functionalContext)
   {
      List<Data> result = new ArrayList<Data>();
      try
      {
         List<Data> checkListServices = screenContext.getEntity().get("checkListServices");
         if (screenContext.getEntity().get("previousScreen").equals("Synthese"))
         {
            for (Data d : checkListServices)
            {
               if (Boolean.TRUE.equals((Boolean) d.get("checkbox")))
               {
                  Data data = new Data();
                  data.set("checkbox", d.get("checkbox"));
                  data.set("description", d.get("description"));
                  result.add(data);
               }
            }
            return result;
         }
         else
            return checkListServices;

      }
      catch (Exception e)
      {
         LOG.error(e);
      }

      return result;
   }

}
