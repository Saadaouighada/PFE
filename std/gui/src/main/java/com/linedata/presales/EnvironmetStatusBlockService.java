package com.linedata.presales;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.form.StdComplexeValue;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.presales.service.AllocationService;
import com.linedata.presales.service.EnvironmentService;

public class EnvironmetStatusBlockService implements FormService
{
   public static String BEANID      = "EnvironmetStatusBlockService";
   public static String COLOR_AV    = "style=\"color:#82CD47;font-weight:bold\"";
   public static String COLOR_INPRG = "style=\"color:#F39C12;font-weight:bold\"";
   public static String COLOR_CFG   = "style=\"color:#3498DB;font-weight:bold\"";
   @Autowired
   AllocationService    allocationService;
   @Autowired
   EnvironmentService   environmentService;
   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Data provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data inParameters,
            FunctionalContext functionalContext)
   {
      Long countAvail = environmentService.countEnvironmentByStatus("AV");
      Long countInprg = allocationService.getCountAllocations("INPRG");
      Long countConfg = allocationService.getCountAllocations("CFG");
      Data data = new Data();
      data.set("availableEnvironments", setItem(countAvail, COLOR_AV));
      data.set("inProgressEnvironments", setItem(countInprg, COLOR_INPRG));
      data.set("configuredEnvironements", setItem(countConfg, COLOR_CFG));

      return data;
   }

   private StdComplexeValue setItem(Object o, String color)
   {
      StdComplexeValue item = new StdComplexeValue();
      item.setCssSpan(color);
      item.setValue(o);
      return item;
   }
}
