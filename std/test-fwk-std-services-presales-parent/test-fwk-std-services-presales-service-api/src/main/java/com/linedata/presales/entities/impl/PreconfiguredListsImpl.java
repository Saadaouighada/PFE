package com.linedata.presales.entities.impl;

import java.sql.Blob;

public class PreconfiguredListsImpl
{
   private long          idPreconfiguredList;
   private Blob          values;
   private String        description;
   private String        idExterne;
   private ListTypesImpl listType;
   public PreconfiguredListsImpl()
   {

   }

   public PreconfiguredListsImpl(long idPreconfiguredList, Blob values, String description, String idExterne, ListTypesImpl listType)
   {
      super();
      this.idPreconfiguredList = idPreconfiguredList;
      this.values = values;
      this.description = description;
      this.idExterne = idExterne;
      this.listType = listType;
   }

   public long getIdPreconfiguredList()
   {
      return idPreconfiguredList;
   }

   public void setIdPreconfiguredList(long idPreconfiguredList)
   {
      this.idPreconfiguredList = idPreconfiguredList;
   }

   public Blob getValues()
   {
      return values;
   }

   public void setValues(Blob values)
   {
      this.values = values;
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

   public ListTypesImpl getListType()
   {
      return listType;
   }

   public void setListType(ListTypesImpl listType)
   {
      this.listType = listType;
   }

}
