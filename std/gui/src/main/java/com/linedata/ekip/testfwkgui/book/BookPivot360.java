package com.linedata.ekip.testfwkgui.book;

import com.linedata.ekip.std.services.core.tree360.Pivot360;

public class BookPivot360 extends Pivot360<BookReference>
{

   private static final String BEANID = "BookPivot360";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Class<BookReference> getTargetClass()
   {
      return BookReference.class;
   }

   @Override
   public Object getPrimaryKey(BookReference bookReference)
   {
      return bookReference.getId();
   }

}
