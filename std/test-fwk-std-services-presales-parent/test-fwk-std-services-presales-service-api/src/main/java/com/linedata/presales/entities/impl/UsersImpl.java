package com.linedata.presales.entities.impl;

import java.sql.Blob;

import javax.persistence.Entity;

@Entity
public class UsersImpl
{
   private long         idUser;
   private String       idExterne;
   private String       firstname;
   private String       lastname;
   private String       codeRole;
   private String       email;
   private Blob         photo;
   private String       codeLanguage;
   private String       codeStatus;
   private ProductsImpl product;
   private RegionsImpl  region;

   public UsersImpl()
   {
   }

   public UsersImpl(long idUser)
   {
      this.idUser = idUser;
   }

   public UsersImpl(long idUser, String idExterne, String firstname, String lastname, String codeRole, String email, Blob photo, String codeLanguage, String codeStatus,
            ProductsImpl product, RegionsImpl region)
   {
      this.idUser = idUser;
      this.idExterne = idExterne;
      this.firstname = firstname;
      this.lastname = lastname;
      this.codeRole = codeRole;
      this.email = email;
      this.photo = photo;
      this.codeLanguage = codeLanguage;
      this.codeStatus = codeStatus;
      this.product = product;
      this.region = region;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public long getIdUser()
   {
      return idUser;
   }

   public void setIdUser(long idUser)
   {
      this.idUser = idUser;
   }

   public String getFirstname()
   {
      return firstname;
   }

   public void setFirstname(String firstname)
   {
      this.firstname = firstname;
   }

   public String getLastname()
   {
      return lastname;
   }

   public void setLastname(String lastname)
   {
      this.lastname = lastname;
   }

   public String getCodeRole()
   {
      return codeRole;
   }

   public void setCodeRole(String codeRole)
   {
      this.codeRole = codeRole;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public Blob getPhoto()
   {
      return photo;
   }

   public void setPhoto(Blob photo)
   {
      this.photo = photo;
   }

   public String getCodeLanguage()
   {
      return codeLanguage;
   }

   public void setCodeLanguage(String codeLanguage)
   {
      this.codeLanguage = codeLanguage;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

   public ProductsImpl getProduct()
   {
      return product;
   }

   public void setProduct(ProductsImpl product)
   {
      this.product = product;
   }

   public RegionsImpl getRegion()
   {
      return region;
   }

   public void setRegion(RegionsImpl region)
   {
      this.region = region;
   }

}
