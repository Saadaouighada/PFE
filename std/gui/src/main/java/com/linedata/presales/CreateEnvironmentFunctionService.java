package com.linedata.presales;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.std.gui.EntityActionUtils;
import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.service.AllocationService;
import com.linedata.presales.service.EnvironmentService;
import com.linedata.presales.service.RegionsService;
import com.linedata.presales.service.UsersService;

public class CreateEnvironmentFunctionService extends ScreenService
{
   public static final String  BEANID                            = "CreateEnvironmentFunctionService";
   public static final String  SCREENENVIRONMENT                 = "Environment";
   public static final String  ENVIRONMENT_CODE_STATUS           = "NAV";
   public static final String  ALLOCATION_CODE_STATUS_INPROGRESS = "INPRG";

   private static final Logger LOG                               = Logger.getLogger(CreateEnvironmentFunctionService.class);

   @Autowired
   AllocationService           allocationService;

   @Autowired
   EnvironmentService          environmentService;

   @Autowired
   RegionsService              regionsService;

   @Autowired
   UsersService                usersService;

   @Resource(name = "EntitiesMapper")
   private DozerBeanMapper     mapper;

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("save", "save");
   }

   public ScreenServiceResponse save(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      EntityData contextData = screenContext.getEntity();

      AllocationImpl allocationImpl = new AllocationImpl();

      if (inParameters != null && inParameters.get("createFormEnvironment") != null)
      {
         Data parameters = (Data) inParameters.get("createFormEnvironment");
         if (parameters != null)
         {
            allocationImpl.setName(parameters.get("name"));
            Data dataServers = parameters.get("server");
            EnvironmentImpl environment = environmentService.getByCode(dataServers.get("value"));
            allocationImpl.setEnvironment(environment);

            Data dataRegions = parameters.get("region");
            String id = dataRegions.get("id");
            allocationImpl.setRegion(regionsService.getByCode(id));
            allocationImpl.setLogin(parameters.get("login"));
            allocationImpl.setDescription(parameters.get("description"));
            java.util.Date date;
            date = parameters.get("endDate");
            java.sql.Date d = new java.sql.Date(date.getTime());
            allocationImpl.setEndDate(d);
            allocationImpl.setUser(usersService.getOne(1));
            allocationImpl.setCodeStatus(ALLOCATION_CODE_STATUS_INPROGRESS);
            allocationImpl.setPassword("ekip.360");
            allocationImpl.setIdExterne("EKIP");
            allocationImpl.setStartDate(java.sql.Date.valueOf(LocalDate.now()));
            allocationService.save(allocationImpl);
            environment.setCodeStatus(ENVIRONMENT_CODE_STATUS);
            environmentService.update(environment);
         }
      }

      return EntityActionUtils.createRedirection(screenServiceResponse, contextData, SCREENENVIRONMENT, SCREENENVIRONMENT, LovOpenFunctionMode.READONLY, LovContextType.COMPUTE, 1,
               true, false, true);
   }

}
