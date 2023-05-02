package com.linedata.presales.entities.impl;

import javax.persistence.Entity;

@Entity
public class LovDefenitionImpl
{
   private long   id;
   private String code;
   private String description;
   private String codeStatut;
   private int    dateCreation;
   private String userCreation;
   public LovDefenitionImpl()
   {
   }

   public LovDefenitionImpl(long id)
   {
      this.id = id;
   }

   public LovDefenitionImpl(long id, String code, String description, String codeStatut, int dateCreation, String userCreation)
   {
      this.id = id;
      this.code = code;
      this.description = description;
      this.codeStatut = codeStatut;
      this.dateCreation = dateCreation;
      this.userCreation = userCreation;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
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

   public String getCodeStatut()
   {
      return codeStatut;
   }

   public void setCodeStatut(String codeStatut)
   {
      this.codeStatut = codeStatut;
   }

   public int getDateCreation()
   {
      return dateCreation;
   }

   public void setDateCreation(int dateCreation)
   {
      this.dateCreation = dateCreation;
   }

   public String getUserCreation()
   {
      return userCreation;
   }

   public void setUserCreation(String userCreation)
   {
      this.userCreation = userCreation;
   }

   public String toString()
   {
      return this.id + " " + this.code + " " + this.description + " " + this.getCodeStatut() + " " + this.getDateCreation() + " " + this.getUserCreation();
   }
}
