package com.linedata.ekip.testfwkgui.author.impl;

import com.linedata.ekip.testfwkgui.author.AuthorReference;

public class AuthorReferenceImpl implements AuthorReference
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
      return "AuthorReferenceFactory";
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
