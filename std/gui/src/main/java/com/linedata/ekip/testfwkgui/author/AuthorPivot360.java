package com.linedata.ekip.testfwkgui.author;

import com.linedata.ekip.std.services.core.tree360.Pivot360;

public class AuthorPivot360 extends Pivot360<AuthorReference>
{

   private static final String BEANID = "AuthorPivot360";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Class<AuthorReference> getTargetClass()
   {
      return AuthorReference.class;
   }

   @Override
   public Object getPrimaryKey(AuthorReference authorReference)
   {
      return authorReference.getId();
   }

}
