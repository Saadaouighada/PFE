package com.linedata.presales.entities.impl;

public class ServicesImpl
{
   private long         idService;
   private String       codeService;
   private String       codeStatus;
   private String       idExterne;
   private String       description;
   private ProductsImpl product;

   public ServicesImpl()
   {

   }

   public ServicesImpl(long idService)
   {
      this.idService = idService;
   }

   public ServicesImpl(long idService, String codeService, String codeStatus, String idExterne, String description, ProductsImpl product)
   {
      this.idService = idService;
      this.codeService = codeService;
      this.codeStatus = codeStatus;
      this.idExterne = idExterne;
      this.product = product;
      this.description = description;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public long getIdService()
   {
      return idService;
   }

   public void setIdService(long idService)
   {
      this.idService = idService;
   }

   public String getCodeService()
   {
      return codeService;
   }

   public void setCodeService(String codeService)
   {
      this.codeService = codeService;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
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
