package com.linedata.ekip.testfwkgui.book.impl;

import com.linedata.ekip.testfwkgui.book.BookReference;

public class BookReferenceImpl implements BookReference
{

   private long id;

   @Override
   public boolean isValid()
   {
      return true;
   }

   @Override
   public String getExternalId()
   {
      return null;
   }

   @Override
   public String getFactoryBeanId()
   {
      return "BookReferenceFactory";
   }

   @Override
   public String getWorkflowEntityCodification()
   {
      return null;
   }

   @Override
   public String getInternalId()
   {
      return null;
   }

   @Override
   public void setId(long id)
   {
      this.id = id;
   }

   @Override
   public long getId()
   {
      return this.id;
   }

}
