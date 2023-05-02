package com.linedata.presales.entities.impl;

import java.io.Serializable;
import java.util.Objects;

public class SelectedServicesImpl implements Serializable
{
   private AllocationImpl allocation;
   private ServicesImpl   service;
   private String         idExterne;

   public SelectedServicesImpl()
   {

   }

   public SelectedServicesImpl(AllocationImpl allocation, ServicesImpl service, String idExterne)
   {
      this.allocation = allocation;
      this.service = service;
      this.idExterne = idExterne;
   }

   public AllocationImpl getAllocation()
   {
      return allocation;
   }

   public void setAllocation(AllocationImpl allocation)
   {
      this.allocation = allocation;
   }

   public ServicesImpl getService()
   {
      return service;
   }

   public void setService(ServicesImpl service)
   {
      this.service = service;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }
   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (!(o instanceof SelectedServicesImpl)) return false;
      SelectedServicesImpl that = (SelectedServicesImpl) o;
      return Objects.equals(this.getAllocation().getIdAllocation(), that.getAllocation().getIdAllocation()) && Objects.equals(this.getService().getIdService(), that.getService().getIdService());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(this.getAllocation().getIdAllocation() + this.getService().getIdService());
   }
}
