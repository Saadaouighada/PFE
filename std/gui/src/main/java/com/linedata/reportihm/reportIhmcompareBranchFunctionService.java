package com.linedata.reportihm;
import java.time.LocalDate;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiRefreshSummaryView;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.core.shared.properties.FunctionProperties;


import com.linedata.ekip.std.services.core.bean.ServiceMessage;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;

import com.linedata.ekip.core.shared.data.EntityData;

import com.linedata.ekip.std.gui.EntityActionUtils;
import com.linedata.project.management.std.services.service.HistoricServiceImpl;
public class reportIhmcompareBranchFunctionService extends ScreenService {



   public static final String  BEANID = "reportIhmformBranchBlockService";


	//   private static final Logger LOG    = Logger.getLogger(reportIhmformBranchBlockService.class);

	

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
		   final ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
		


		   	if (inParameters != null && inParameters.get("reportIhmformBranchBlockService") != null)
		   		{
		   			Data parameters = (Data) inParameters.get("formBranch");
		   			if (parameters != null)
		   			{
		   				
		   	     HistoricServiceImpl historicService = new HistoricServiceImpl();
		         System.out.println("ghadaghada");
		         String branchNameChild = parameters.get("branchA");
		         String branchNameParent =parameters.get("branchB");
		         String dateBorneMin =parameters.get("startDate");
		         String dateBorneMax = parameters.get("endDate")   ;
		         String workSpace = "C:\\GhadaPFE\\projects";
		         String reportDir = "C:\\GhadaPFE\\projects\\reports";
		         historicService.checkHistoricDiff(workSpace, branchNameChild, branchNameParent, dateBorneMin, dateBorneMax, reportDir);
		   		}}
         
         return screenServiceResponse;
}}
      

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    /*  
      
   {

      Data criterias = null;
      Data data = new Data();;

      // Récupération du contexte selon l'endroit d'où il est passé
      if (event.getValue().equals("SCREENCONTEXT"))
      {
         criterias = screenContext.getEntity();
      }
      if (criterias != null)
      {
         data.set("branchA", criterias.get("branchA"));
         data.set("branchB", criterias.get("branchB"));
         data.set("startDate", criterias.get("startDate"));
         data.set("endDate", criterias.get("endDate"));
         data.set("comment", criterias.get("comment"));
       
      }

      HistoricServiceImpl historicService = new HistoricServiceImpl();
      System.out.println("ghadaghada");
      String branchNameChild = data.branchA;
      String branchNameParent = data.branchB;
      String dateBorneMin = data.startDate; //2021-07-21
      String dateBorneMax = data.endDate;      
      String workSpace = "C:\\GhadaPFE\\projects";
      String reportDir = "C:\\GhadaPFE\\projects\\reports";
      historicService.checkHistoricDiff(workSpace, branchNameChild, branchNameParent, dateBorneMin, dateBorneMax, reportDir);
     // System.getProperty("java.class.path");
   
}}*/
