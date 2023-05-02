package com.linedata.presales.entities.impl;

import javax.persistence.Entity;

@Entity
public class RegionsImpl
{
   private long   idRegion;
   private String idExterne;
   private String codeRegion;
   private String codeStatus;

   public RegionsImpl()
   {
   }

   public RegionsImpl(long idRegion)
   {
      this.idRegion = idRegion;
   }

   public RegionsImpl(long idRegion, String idExterne, String codeRegion, String codeStatus)
   {
      this.idRegion = idRegion;
      this.idExterne = idExterne;
      this.codeRegion = codeRegion;
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

   public long getIdRegion()
   {
      return idRegion;
   }

   public void setIdRegion(long idRegion)
   {
      this.idRegion = idRegion;
   }

   public String getCodeRegion()
   {
      return codeRegion;
   }

   public void setCodeRegion(String codeRegion)
   {
      this.codeRegion = codeRegion;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

}
