package com.linedata.presales;

import java.util.ArrayList;
import java.util.List;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.GridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.lov.LovEvent;

public class ListGridBlockService implements GridService
{
   public static final String BEANID       = "ListGridBlockService";
   public static final String SCREEN_ASSET = "lists1";
   public static final String SCREEN_TIERS = "lists2";
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
      EntityData contextData = (EntityData) screenContext.getEntity();
      try
      {
         List<Data> dataList = new ArrayList();
         if (contextData.get("gridName").equals(SCREEN_ASSET))
         {
            dataList = contextData.get("ListAssetGrid");
            if (dataList.size() != 0) return dataList;
         }
         else if (contextData.get("gridName").equals(SCREEN_TIERS))
         {
            dataList = contextData.get("ListTiersGrid");
            if (dataList.size() != 0) return dataList;
         }
      }
      catch (Exception e)
      {
      }

      return result;
   }
}
