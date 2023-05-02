package com.linedata.presales.entities.impl;

import java.io.Serializable;
import java.util.Objects;

public class SelectedPreconfiguredListsImpl implements Serializable
{
   private String                 idExterne;
   private PreconfiguredListsImpl preconfiguredList;
   private AllocationImpl         allocation;

   public SelectedPreconfiguredListsImpl()
   {

   }

   public SelectedPreconfiguredListsImpl(String idExterne, PreconfiguredListsImpl preconfiguredList, AllocationImpl allocation)
   {
      super();
      this.idExterne = idExterne;
      this.preconfiguredList = preconfiguredList;
      this.allocation = allocation;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public PreconfiguredListsImpl getPreconfiguredList()
   {
      return preconfiguredList;
   }

   public void setPreconfiguredList(PreconfiguredListsImpl preconfiguredList)
   {
      this.preconfiguredList = preconfiguredList;
   }

   public AllocationImpl getAllocation()
   {
      return allocation;
   }

   public void setAllocation(AllocationImpl allocation)
   {
      this.allocation = allocation;
   }
   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (!(o instanceof SelectedPreconfiguredListsImpl)) return false;
      SelectedPreconfiguredListsImpl that = (SelectedPreconfiguredListsImpl) o;
      return Objects.equals(this.getAllocation().getIdAllocation(), that.getAllocation().getIdAllocation()) && Objects.equals(this.getPreconfiguredList().getIdPreconfiguredList(), that.getPreconfiguredList().getIdPreconfiguredList());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(this.getAllocation().getIdAllocation() + this.getPreconfiguredList().getIdPreconfiguredList());
   }
}
