package com.linedata.ekip.std.services.lov;
import  com.linedata.reportihm.branchFieldLinkService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import com.linedata.reportihm.reportIhmcompareBranchFunctionService;
import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenLovService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.service.EnvironmentService;

public class ScreenLovServiceImpl implements ScreenLovService
{
   public static final String             BEANID          = "ScreenLovService";

  public Map<String, Map<String, Data>> allLovs;

   private Set<String>                    knownLovs;

   public static final String             ENV_CODE_STATUS = "AV";

   @Autowired
   EnvironmentService                     environmentService;

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   
   public void updateBranchLov() {
	  allLovs.get("branchLov").remove("val2");
	}
   
   @PostConstruct
   public void generateLovs()
   {
      allLovs = new HashMap<String, Map<String, Data>>();
      addTestLov();
      addBookType();
      addBigLov();
      addBusinessLov();
      addServerLov();
      typeList();
      companyList();
      currencyList();
      colorList();
      languageList();
      addRegionList();
      addbranchListLov();
      currencyFormatList();
      dateFormatList();
   }

  public  void addbranchListLov() {
	// TODO Auto-generated method stub
	   HashMap<String, Data> lov = new HashMap<String, Data>();
	      Data value = new Data();
	      value.set("id", "1");
	      value.set("longLabel", "B_5_1_0");
	      lov.put("val1", value);
	      value = new Data();
	      value.set("id", "2");
	      value.set("longLabel", "master");
	      lov.put("val2", value);
	      value = new Data();
	      value.set("id", "3");
	      value.set("longLabel", "B_1_0_0");
	      lov.put("val3", value);
	      value = new Data();
	      value.set("id", "4");
	      value.set("longLabel", "B_1_1_0");
	      lov.put("val4", value);
	      allLovs.put("branchLov", lov);
	      knownLovs = allLovs.keySet();
	
}

private void addBusinessLov()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "Loan");
      value.set("label", "Loan");
      lov.put("option1", value);
      value = new Data();
      value.set("id", "Leasing");
      value.set("label", "Leasing");
      lov.put("option2", value);
      value = new Data();
      value.set("id", "Full Service Leasing");
      value.set("label", "Full Service Leasing");
      lov.put("option3", value);
      allLovs.put("BusinessLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void addServerLov()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      List<EnvironmentImpl> l = new ArrayList();
      l = environmentService.getEnvironmentByCodeStatus(ENV_CODE_STATUS);
      int i = 1;
      for (EnvironmentImpl e : l)
      {
         Data data = new Data();
         data.set("id", Integer.toString(i));
         data.set("value", e.getIdExterne());
         lov.put("val" + i, data);
         i++;
      }
      allLovs.put("ServerLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void addBigLov()
   {
      final int NB_VALUES = 50;

      HashMap<String, Data> lov;
      lov = new HashMap<String, Data>();
      for (int i = 0; i < NB_VALUES; i++)
      {
         Data value;
         value = new Data();
         value.set("id", "option   " + i);
         value.set("label", "label <test> &" + i);
         lov.put("option" + i, value);
      }
      Data value;
      value = new Data();
      value.set("id", "option" + 123);
      value.set("label", null);
      lov.put("option" + 123, value);

      allLovs.put("BigLov", lov);
   }

   private void addBookType()
   {
      HashMap<String, Data> lov;
      Data value;
      lov = new HashMap<String, Data>();
      value = new Data();
      value.set("id", "paperback");
      value.set("label", "paperback");
      value.set("nbPages", 100);
      lov.put("paperback", value);
      value = new Data();
      value.set("id", "hardcover");
      value.set("label", "hardcover");
      value.set("nbPages", 1000);
      lov.put("hardcover", value);
      value = new Data();
      value.set("id", "ebook");
      value.set("label", "ebook");
      value.set("nbPages", 500);
      lov.put("ebook", value);
      allLovs.put("BookType", lov);
   }

   private void addTestLov()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("value", "EUR");
      value.set("longLabel", "EUR - Euro");
      lov.put("test1", value);
      value = new Data();
      value.set("value", "USD");
      value.set("longLabel", "USD - Dollar");
      lov.put("test2", value);
      value = new Data();
      value.set("value", "GBP");
      value.set("longLabel", "GBP - Livre");
      lov.put("test3", value);
      allLovs.put("TestLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void typeList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "1");
      value.set("value", "Assets");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "2");
      value.set("value", "type2");
      lov.put("val2", value);
      allLovs.put("TypeLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void companyList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "1");
      value.set("value", "Toyota");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "2");
      value.set("value", "Nissan");
      lov.put("val2", value);
      allLovs.put("CompanyLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void addRegionList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "USA");
      value.set("longLabel", "United states");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "IND");
      value.set("longLabel", "INDIA");
      lov.put("val2", value);
      value = new Data();
      value.set("id", "TN");
      value.set("longLabel", "TUNISIA");
      lov.put("val3", value);
      value = new Data();
      value.set("id", "FR");
      value.set("longLabel", "FRANCE");
      lov.put("val4", value);
      allLovs.put("RegionLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void languageList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "1");
      value.set("value", "French");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "2");
      value.set("value", "English");
      lov.put("val2", value);
      allLovs.put("LanguageLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void currencyList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "USD");
      value.set("value", "American dollar");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "EUR");
      value.set("value", "EURO");
      lov.put("val2", value);
      allLovs.put("CurrencyLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void colorList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "1");
      value.set("value", "red");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "2");
      value.set("value", "blue");
      lov.put("val2", value);

      value = new Data();
      value.set("id", "3");
      value.set("value", "green");
      lov.put("val3", value);

      allLovs.put("ColorLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void currencyFormatList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "Format 1");
      value.set("value", "$.$");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "Format 2");
      value.set("value", "$,$");
      lov.put("val2", value);
      value = new Data();
      value.set("id", "Format 3");
      value.set("value", "$,$.$");
      lov.put("val3", value);
      value = new Data();
      value.set("id", "Format 4");
      value.set("value", "$.$,$");
      lov.put("val4", value);
      allLovs.put("CurrencyFormatLov", lov);
      knownLovs = allLovs.keySet();
   }

   private void dateFormatList()
   {
      HashMap<String, Data> lov = new HashMap<String, Data>();
      Data value = new Data();
      value.set("id", "MM/DD/YY");
      value.set("value", "12/15/2022");
      lov.put("val1", value);
      value = new Data();
      value.set("id", "DD/MM/YY");
      value.set("value", "15/12/2022");
      lov.put("val2", value);
      value = new Data();
      value.set("id", "YY/MM/DD");
      value.set("value", "2022/12/15");
      lov.put("val3", value);
      allLovs.put("DateFormatLov", lov);
      knownLovs = allLovs.keySet();
   }

   @Override
   public List<Data> getLov(ActionContext actionContext, String lovName, Data filters, ScreenContext screenContext)
   {

      List<Data> result = new ArrayList<Data>();

      if (knownLovs.contains(lovName))
      {
         result.addAll(allLovs.get(lovName).values());
      }
      else if ("BookType".equals(lovName))
      {
         if (filters != null && filters.get("nbPages") != null && filters.get("nbPages") instanceof Integer)
         {
            int filterNbPages = (Integer) filters.get("nbPages");
            for (Data bookType : allLovs.get("BookType").values())
            {
               int nbPages = (Integer) bookType.get("nbPages");
               if (nbPages >= filterNbPages)
               {
                  result.add(bookType);
               }
            }
         }
        /* else if("branchLove".equals(lovName))
         {
        	 final Data inParameters ;
        	 	if (inParameters.get("reportIhmformBranchBlockService") != null)
		   		{
		   			Data fielters = (Data) inParameters.get("formBranch");
	   			if (fielters != null)
	   			{
	   				knownLovs.remove(fielters);
	   				
	   			}
	   				
	   			}}
*/
         
         else
         {
            result.addAll(allLovs.get("BookType").values());
         }
      }

      return result;
   }

   @Override
   public Data getLovValue(ActionContext actionContext, String lovName, String lovValue, String valueField, ScreenContext screenContext)
   {
      if (knownLovs.contains(lovName))
      {
         final Map<String, Data> lovValues = allLovs.get(lovName);
         if (lovValues != null)
         {
            return lovValues.get(valueField);
         }
      }

      return null;
   }
}
