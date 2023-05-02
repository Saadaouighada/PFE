package com.linedata.reportihm;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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


 //private static final Logger LOG    = Logger.getLogger(reportIhmformBranchBlockService.class);

	

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
		


		   
		   			Data parameters = (Data) inParameters.get("formBranch");
		   		if (parameters != null)
		   			{
		   		System.out.println("hello");
		   	     HistoricServiceImpl historicService = new HistoricServiceImpl();
		         System.out.println("ghadaghada");
		         Data branchA = parameters.get("branchA");
		         String branchNameChild =  (String) branchA.get("longLabel");
		         
		         Data branchB = parameters.get("branchB");
		         
		         String branchNameParent = (String)branchB.get("longLabel");
		        // String dateBorneMin = parameters.get("startDate").toString();
		       //  String dateBorneMax = parameters.get("endDate").toString();
		     /*
		          String dateBorneMin = "01-01-2022";
		         String dateBorneMax = "22-03-2023";
		      */
		         try {
		         
		         String inputDate = parameters.get("startDate").toString();
		         SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		         Date date = inputFormat.parse(inputDate);
		         SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		         String dateBorneMin = outputFormat.format(date);
		         
		         
		         
		         
		         String inputDate1 = parameters.get("endDate").toString();
		         SimpleDateFormat inputFormat1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		         Date date1 = inputFormat1.parse(inputDate1);
		         SimpleDateFormat outputFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		         String dateBorneMax = outputFormat1.format(date1);
		       
		         
		         
		         String workSpace = "C:\\GhadaPFE\\guiWorkSpace";
		         String reportDir = "C:\\GhadaPFE\\guiWorkSpace\\reports";
		         historicService.checkHistoricDiff(workSpace, branchNameChild, branchNameParent, dateBorneMin, dateBorneMax, reportDir);
		   		
		         } catch (ParseException e) {
		             System.out.println("Erreur lors de la conversion de la date : " + e.getMessage());
		         }
		         }
         return screenServiceResponse;
}}
      

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

