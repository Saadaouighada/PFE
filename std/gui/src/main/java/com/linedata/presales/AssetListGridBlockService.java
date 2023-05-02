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

public class AssetListGridBlockService implements GridService
{
   public static final String  BEANID          = "AssetListGridBlockService";
   public static final String  LIST_ASSET_NAME = "ListAssetGrid";
   private static final Logger LOG             = Logger.getLogger(AssetListGridBlockService.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<? extends Data> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data inParameters,
            FunctionalContext functionalContext)
   {
      List<Data> result = new ArrayList<>();
      EntityData contextData = screenContext.getEntity();
      try
      {
         List<Data> dataList = new ArrayList();
         dataList = contextData.get(LIST_ASSET_NAME);
         if (!dataList.isEmpty()) return dataList;
      }
      catch (Exception e)
      {
         LOG.error(e);
      }

      return result;
   }

}
