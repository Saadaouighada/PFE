package com.linedata.ekip.std.services.controls;

import org.springframework.stereotype.Component;

import com.linedata.ekip.core.server.custom.controlmanager.impl.CustomControl;

@Component
public class TestCustomControl extends CustomControl
{

   public static final String BEANID = "TestCustomControl";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public boolean controlSomething(String parameter)
   {
      return true;
      // throw new
      // CustomControlMessageException("test custom control message custom");
   }

}
