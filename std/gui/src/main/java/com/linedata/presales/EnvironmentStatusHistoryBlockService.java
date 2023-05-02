package com.linedata.presales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.GridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.form.StdComplexeValue;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.testfwkgui.shared.TestData;
import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.service.AllocationService;
import com.linedata.presales.service.EnvironmentService;
import com.linedata.presales.service.RegionsService;
import com.linedata.presales.service.UsersService;

public class EnvironmentStatusHistoryBlockService implements GridService
{
   public static String        BEANID          = "EnvironmentStatusHistoryBlockService";
   public static String        COLOR_INPRG     = "style=\"color:#F39C12;font-weight:bold\"";
   public static String        COLOR_CFG       = "style=\"color:#3498DB;font-weight:bold\"";
   public static String        CODE_INPROGRESS = "INPRG";
   public static String        CODE_CONFIGURED = "CFG";
   private static final Logger LOG             = Logger.getLogger(EnvironmentStatusHistoryBlockService.class);
   @Autowired
   AllocationService           allocationService;

   @Autowired
   EnvironmentService          environmentService;

   @Autowired
   UsersService                usersService;

   @Autowired
   RegionsService              regionsService;

   @Override
   public String getBeanId()
   {
      return this.BEANID;
   }

   @Override
   public List<? extends Data> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data inParameters,
            FunctionalContext functionalContext)
   {

      List<TestData> outData = new ArrayList<TestData>();
      List<AllocationImpl> allocList = new ArrayList<AllocationImpl>();
      allocList = allocationService.getCurrentAllocations();
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      for (AllocationImpl a : allocList)
      {
         UsersImpl user = usersService.getOne(a.getUser().getIdUser());
         RegionsImpl region = regionsService.getOne(a.getRegion().getIdRegion());
         TestData resultRow = new TestData();
         resultRow.set("idAllocation", setItem(String.valueOf(a.getIdAllocation()), a.getCodeStatus()));
         resultRow.set("name", setItem(a.getName(), a.getCodeStatus()));
         resultRow.set("status", a.getCodeStatus());
         resultRow.set("owner", setItem(user.getFirstname() + " " + user.getLastname(), a.getCodeStatus()));
         java.util.Date date = new java.util.Date(a.getStartDate().getTime());
         resultRow.set("startDate", setItem(dateFormat.format(date), a.getCodeStatus()));
         date = new java.util.Date(a.getEndDate().getTime());
         resultRow.set("endDate", setItem(dateFormat.format(date), a.getCodeStatus()));
         resultRow.set("region", setItem(region.getCodeRegion(), a.getCodeStatus()));
         resultRow.set("description", setItem(a.getDescription(), a.getCodeStatus()));
         outData.add(resultRow);
      }
      return outData;
   }

   public List<TestData> localData()
   {
      List<TestData> outData = new ArrayList<TestData>();
      TestData resultRow = new TestData();
      resultRow.set("idAllocation", "1");
      resultRow.set("name", "wholesales");
      resultRow.set("status", "configured");
      resultRow.set("owner", "Lina.SR");
      resultRow.set("startDate", "29-08-2022");
      resultRow.set("endDate", "07-12-2022");
      resultRow.set("region", "India");
      resultRow.set("description", "Created for  the benifit of Nissan customer");
      outData.add(resultRow);
      resultRow = new TestData();
      resultRow.set("idAllocation", "2");
      resultRow.set("name", "Finance");
      resultRow.set("status", "inProgress");
      resultRow.set("owner", "Natakie.KJ");
      resultRow.set("startDate", "22-09-2022");
      resultRow.set("endDate", "22-12-2022.KJ");
      resultRow.set("region", "United states");
      resultRow.set("description", "Created for  the benefit of  the Toyota customer");
      outData.add(resultRow);
      return outData;
   }

   private StdComplexeValue setItem(Object o, String codeStatus)
   {
      StdComplexeValue item = new StdComplexeValue();
      if (codeStatus.equals(CODE_INPROGRESS)) item.setCssSpan(COLOR_INPRG);
      else if (codeStatus.equals(CODE_CONFIGURED)) item.setCssSpan(COLOR_CFG);
      item.setValue(o);
      return item;
   }
}
