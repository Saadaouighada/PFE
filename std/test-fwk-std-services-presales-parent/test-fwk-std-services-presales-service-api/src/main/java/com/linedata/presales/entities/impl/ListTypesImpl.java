package com.linedata.presales.entities.impl;

public class ListTypesImpl
{
   private long         idListType;
   private String       idExterne;
   private String       codeStatus;
   private String       codeType;
   private ProductsImpl product;
   public ListTypesImpl()
   {
   }

   public ListTypesImpl(long idListType, String idExterne, String codeStatus, String codeType, ProductsImpl product)
   {
      this.idListType = idListType;
      this.idExterne = idExterne;
      this.codeStatus = codeStatus;
      this.codeType = codeType;
      this.product = product;
   }
   public ListTypesImpl(long idListType)
   {
      this.idListType = idListType;
   }
   public long getIdListType()
   {
      return idListType;
   }

   public void setIdListType(long idListType)
   {
      this.idListType = idListType;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

   public String getCodeType()
   {
      return codeType;
   }

   public void setCodeType(String codeType)
   {
      this.codeType = codeType;
   }

   public ProductsImpl getProduct()
   {
      return product;
   }

   public void setProduct(ProductsImpl product)
   {
      this.product = product;
   }

}
