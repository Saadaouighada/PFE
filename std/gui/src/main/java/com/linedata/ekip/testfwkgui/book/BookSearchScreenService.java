package com.linedata.ekip.testfwkgui.book;

import org.springframework.stereotype.Component;

import com.linedata.ekip.core.server.screenservices.ScreenService;

@Component
public class BookSearchScreenService extends ScreenService
{
   private static final String BEANID = "BookSearchScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
   }
}
