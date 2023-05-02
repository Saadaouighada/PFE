package com.linedata.ekip.testfwkgui.shared;

import com.linedata.ekip.core.shared.data.EntityData;

public class AuthorData extends EntityData
{

   private static final long serialVersionUID = -8080120306418239169L;

   @Override
   public void manageKey()
   {
      getEntityKey().addKey("id");
   }

   @Override
   public String getType()
   {
      return "author";
   }

   @Override
   public String getDisplayName()
   {
      String firstName = get("firstName", "firstName");
      String lastName = get("lastName", "lastName");
      return firstName + " " + lastName;
   }
}
