package com.linedata.presales.entities.impl;

import java.io.File;
import java.sql.Blob;

import javax.persistence.Entity;

@Entity
public class ProductsImpl
{
   private long   idProduct;
   private String idExterne;
   private String codeProduct;
   private Blob   descriptionFile;
   private String codeStatus;
   public ProductsImpl()
   {
   }

   public ProductsImpl(long idProduct)
   {
      this.idProduct = idProduct;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public ProductsImpl(long idProduct, String idExterne, String codeProduct, Blob descriptionFile, String codeStatus)
   {
      this.idProduct = idProduct;
      this.idExterne = idExterne;
      this.codeProduct = codeProduct;
      this.descriptionFile = descriptionFile;
      this.codeStatus = codeStatus;
   }

   public long getIdProduct()
   {
      return idProduct;
   }

   public void setIdProduct(long idProduct)
   {
      this.idProduct = idProduct;
   }

   public String getCodeProduct()
   {
      return codeProduct;
   }

   public void setCodeProduct(String codeProduct)
   {
      this.codeProduct = codeProduct;
   }

   public Blob getDescriptionFile()
   {
      return descriptionFile;
   }

   public void setDescriptionFile(Blob descriptionFile)
   {
      this.descriptionFile = descriptionFile;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }
   
   public String toString() {
      return String.valueOf(this.idProduct);
   }

}
