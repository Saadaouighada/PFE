package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLink;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLinkResponse;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;

@Component
public class AuthorCreateFieldLinkService extends CustomFieldLink
{

   private static final String BEANID = "AuthorCreateFieldLinkService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   public CustomFieldLinkResponse get2From1(ActionContext actionContext, ScreenContext screenContext, Data parameters)
   {
      CustomFieldLinkResponse response = new CustomFieldLinkResponse();

      String lastName = (String) parameters.get("lastName", "");

      response.setValue(lastName + "2");

      return response;
   }

}
