package com.linedata.ekip.std.services.user;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionMessageStyle;
import com.linedata.ekip.commons.shared.context.UserContext;
import com.linedata.ekip.core.server.users.UserHooks;

@Component
public class UserHooksImpl implements UserHooks
{

   @Override
   public String getBeanId()
   {
      return "UserHooks";
   }

   @Override
   public void onUserLogin(UserContext userContext)
   {
      userContext.setActionMessageStyle(ActionMessageStyle.INFOBOX);
   }
}
