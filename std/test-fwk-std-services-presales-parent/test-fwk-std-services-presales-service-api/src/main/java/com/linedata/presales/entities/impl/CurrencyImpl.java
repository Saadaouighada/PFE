package com.linedata.presales.entities.impl;

public class CurrencyImpl
{
   private long         idCurrency;
   private String       codeCurrency;
   private String       idExterne;
   private ProductsImpl product;

   public CurrencyImpl()
   {
   }

   public CurrencyImpl(long idCurrency, String codeCurrency, String idExterne, ProductsImpl product)
   {
      super();
      this.idCurrency = idCurrency;
      this.codeCurrency = codeCurrency;
      this.idExterne = idExterne;
      this.product = product;
   }

   public CurrencyImpl(long idCurrency)
   {

      this.idCurrency = idCurrency;
   }

   public long getIdCurrency()
   {
      return idCurrency;
   }

   public void setIdCurrency(long idCurrency)
   {
      this.idCurrency = idCurrency;
   }

   public String getCodeCurrency()
   {
      return codeCurrency;
   }

   public void setCodeCurrency(String codeCurrency)
   {
      this.codeCurrency = codeCurrency;
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
