package com.linedata.ekip.std.services.field;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLink;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLinkResponse;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;

@Component
public class TestFieldLinkService extends CustomFieldLink
{
   final private static String AMOUNT_TYPE = "TTC";
   /**
    * the bean identifier
    */
   public static final String  BEANID      = "TestFieldLinkService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public CustomFieldLinkResponse getTestAmountFromPercentage(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      Double testPercentage = parameters.get("testPercentage");

      if (testPercentage != null)
      {
         response.setValue(testPercentage);
      }
      else
      {
         response.setValue(0);
      }

      return response;
   }

   public CustomFieldLinkResponse getTestPercentageFromAmount(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      Double testGrossAmount = null;
      if ("TTC".equals(AMOUNT_TYPE))
      {
         testGrossAmount = parameters.get("testGrossAmount");
      }
      else if ("HT".equals(AMOUNT_TYPE))
      {
         testGrossAmount = parameters.get("testAmount");
      }

      if (testGrossAmount != null)
      {
         response.setValue(testGrossAmount);
      }
      else
      {
         response.setValue(0);
      }

      return response;
   }

   public boolean isFileMandatory(ActionContext actionContext, ScreenContext screenContext, Data inParameters)
   {
      boolean mandatory = false;
      String switchMandatory = (String) inParameters.get("testSwitchMandatory");
      if ("o".equals(switchMandatory))
      {
         mandatory = true;
      }
      else
      {
         mandatory = false;
      }
      return mandatory;
   }

   public boolean getTrucFromCombo(ActionContext actionContext, ScreenContext screenContext, Data inParameters)
   {
      boolean mandatory = false;
      String switchMandatory = (String) inParameters.get("testSwitchMandatory");
      if ("o".equals(switchMandatory))
      {
         mandatory = true;
      }
      else
      {
         mandatory = false;
      }
      return mandatory;
   }

}
