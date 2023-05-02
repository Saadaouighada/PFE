package com.linedata.presales.entities.impl;

public class LanguageImpl
{
   private long         idLanguage;
   private String       codeLanguage;
   private String       idExterne;
   private ProductsImpl product;

   public LanguageImpl()
   {
   }

   public LanguageImpl(long idLanguage)
   {
      this.idLanguage = idLanguage;
   }

   public LanguageImpl(long idLanguage, String codeLanguage, String idExterne, ProductsImpl product)
   {
      super();
      this.idLanguage = idLanguage;
      this.codeLanguage = codeLanguage;
      this.idExterne = idExterne;
      this.product = product;
   }

   public long getIdLanguage()
   {
      return idLanguage;
   }

   public void setIdLanguage(long idLanguage)
   {
      this.idLanguage = idLanguage;
   }

   public String getCodeLanguage()
   {
      return codeLanguage;
   }

   public void setCodeLanguage(String codeLanguage)
   {
      this.codeLanguage = codeLanguage;
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
