package com.linedata.presales.entities.impl;

public class ConfiguredListsImpl
{
   private long           idConfiguredList;
   private String         code;
   private String         description;
   private String         idExterne;
   private AllocationImpl allocation;
   private ListTypesImpl  listType;

   public ConfiguredListsImpl()
   {

   }

   public ConfiguredListsImpl(long idConfiguredList, String code, String description, String idExterne, AllocationImpl allocation, ListTypesImpl listType)
   {
      this.idConfiguredList = idConfiguredList;
      this.code = code;
      this.description = description;
      this.idExterne = idExterne;
      this.allocation = allocation;
      this.listType = listType;
   }

   public long getIdConfiguredList()
   {
      return idConfiguredList;
   }

   public void setIdConfiguredList(long idConfiguredList)
   {
      this.idConfiguredList = idConfiguredList;
   }

   public String getCode()
   {
      return code;
   }

   public void setCode(String code)
   {
      this.code = code;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
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

   public ListTypesImpl getListType()
   {
      return listType;
   }

   public void setListType(ListTypesImpl listType)
   {
      this.listType = listType;
   }

}
