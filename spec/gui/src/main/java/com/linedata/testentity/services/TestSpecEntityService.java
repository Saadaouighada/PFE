package com.linedata.testentity.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;

@Component
public class TestSpecEntityService extends TestEntityService
{
   private static final String BEANID = "TestSpecEntityService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public ScreenServiceResponse doSomethingSpec(ActionContext actionContext, EntityData entityData)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse();

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);

      return screenServiceResponse;
   }

   public boolean doSomethingSpecValidationMethod(ActionContext actionContext, EntityData entityData)
   {
      return true;
   }
}
