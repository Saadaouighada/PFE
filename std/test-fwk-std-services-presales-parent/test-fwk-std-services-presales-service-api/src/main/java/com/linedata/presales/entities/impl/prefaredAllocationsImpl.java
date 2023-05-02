package com.linedata.presales.entities.impl;

import javax.persistence.Entity;

@Entity
public class prefaredAllocationsImpl
{
   private long idUser;
   private long idAllocation;

   public prefaredAllocationsImpl()
   {
   }

   public prefaredAllocationsImpl(long idUser, long idAllocation)
   {
      this.idUser = idUser;
      this.idAllocation = idAllocation;
   }

   public long getIdUser()
   {
      return idUser;
   }

   public void setIdUser(long idUser)
   {
      this.idUser = idUser;
   }

   public long getIdAllocation()
   {
      return idAllocation;
   }

   public void setIdAllocation(long idAllocation)
   {
      this.idAllocation = idAllocation;
   }

}
