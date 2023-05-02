package com.linedata.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.RemoteLovService;
import com.linedata.ekip.core.shared.data.Data;

@Component
public class TestFormRemoteLovService implements RemoteLovService
{

   public static final String BEANID = "TestFormRemoteLovService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public List<Data> getMyRemoteCombo1(ActionContext actionContext, String lovName, String valueField, String searchString, Data filters, Boolean autoSearch)
   {
      List<Data> res;
      List<Data> allValues = new ArrayList<Data>();

      Data value = new Data();
      value.set("value", "EUR");
      value.set("label", "Euro");

      allValues.add(value);

      value = new Data();
      value.set("value", "USD");
      value.set("label", "Dollar");

      allValues.add(value);

      if (searchString == null || searchString.toUpperCase().equals(""))
      {
         res = allValues;
      }
      else
      {
         res = new ArrayList<Data>();
         for (Data oneValue : allValues)
         {
            Object oneValueObject = oneValue.get(valueField);
            if (oneValueObject instanceof String)
            {
               String oneValueString = (String) oneValueObject;
               if (oneValueString.startsWith(searchString.toUpperCase()))
               {
                  res.add(oneValue);
               }
            }
         }
      }

      return res;
   }
}
