package com.linedata.ekip.std.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.dtk.DtkAuthorizationService;
import com.linedata.ekip.commons.shared.context.ActionContext;

@Component
public class DtkAuthorizationServiceImpl implements DtkAuthorizationService
{

   @Override
   public List<String> getDeclaredXmlFileNameList(ActionContext actionContext)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<String> getDeclaredDroolsFileNameList(ActionContext actionContext)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<String> getDeclaredView360FileNameList(ActionContext actionContext)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<String> getDeclaredSummaryViewFileNameList(ActionContext actionContext)
   {
      // TODO Auto-generated method stub
      return null;
   }

}
