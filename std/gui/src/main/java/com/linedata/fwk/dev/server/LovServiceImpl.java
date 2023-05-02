package com.linedata.fwk.dev.server;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;

@Component(value = "LovService")
public class LovServiceImpl implements com.linedata.framework.services.lov.service.LovService
{
   private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LovServiceImpl.class);

   @Override
   public String getBeanId()
   {
      // TODO Auto-generated method stub
      return "LovService";
   }

   @Override
   public String getBeanKey()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void reloadAll()
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void reloadLov(ActionContext actionContext, String lovName)
   {
      // TODO Auto-generated method stub

   }

}
