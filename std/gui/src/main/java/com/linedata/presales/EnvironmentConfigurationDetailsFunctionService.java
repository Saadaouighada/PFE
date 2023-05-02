package com.linedata.presales;

import java.io.IOException;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovContextType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.std.gui.EntityActionUtils;
import com.linedata.ekip.testfwkgui.shared.TestData;

public class EnvironmentConfigurationDetailsFunctionService extends ScreenService
{
   public static final String BEANID                                  = "EnvironmentConfigurationDetailsFunctionService";
   public static final String SCREENENVIRONMENT                       = "Environment";
   public static final String EnvironmentConfigurationDetailsSynthese = "EnvironmentConfigurationDetailsSynthese";
   public static final String EnvironmentLink                         = "http://ma1ekdemo01:8110/ekip360-gui/login";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("close", "close");
      getActionMappings().put("run", "run");

   }

   public ScreenServiceResponse close(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      TestData data = new TestData();
      return EntityActionUtils.createRedirection(screenServiceResponse, data, SCREENENVIRONMENT, SCREENENVIRONMENT, LovOpenFunctionMode.CREATE, LovContextType.COMPUTE, 1, true,
               false, true);
   }

   public ScreenServiceResponse run(final ActionContext actionContext, final String functionId, final ScreenContext screenContext, final Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);
      TestData data = new TestData();
      try
      {
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(EnvironmentLink));
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return screenServiceResponse;
   }
}
