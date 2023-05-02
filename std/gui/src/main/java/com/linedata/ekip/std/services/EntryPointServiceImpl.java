package com.linedata.ekip.std.services;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.entryPoint.EntryPointService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiDisplayMessages;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.core.shared.message.ScreenMessage;

@Component
public class EntryPointServiceImpl implements EntryPointService
{

   public static final String BEANID = "EntryPointService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public ScreenServiceResponse callEntryPoint(ActionContext actionContext, String entryPoint, Map<String, Object> parameters, ScreenContext screenContext)
   {
      ScreenServiceResponse screenServiceResponse = new ScreenServiceResponse();

      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.OK);
      screenServiceResponse.addMessage(new ScreenMessage("test entrypoint"));

      AsiDisplayMessages displayMessages = new AsiDisplayMessages();

      screenServiceResponse.addPostAction(displayMessages);

      return screenServiceResponse;
   }

}
