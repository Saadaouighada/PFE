package com.linedata.presales.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOV_ELT")
public class LovEltImpl
{
   @Id
   @Column(name = "ID")
   @GeneratedValue(generator = "sequence-generator")
   @org.hibernate.annotations.GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters =
   { @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQLOV_ELT_ID"), @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
   private long              id;
   @Column(name = "INTERNAL_CODE")
   private String            codeInterne;
   @Column(name = "EXTERNAL_CODE")
   private String            codeExterne;
   @Column(name = "CODE_STATUS")
   private String            codeStatut;
   @Column(name = "DATE_CREATION")
   private int               dateCreation;
   @Column(name = "USER_CREATION")
   private String            userCreation;
   @ManyToOne
   @JoinColumn(name = "LOV_DEF_ID")
   private LovDefenitionImpl LovDef;

   public LovEltImpl()
   {
   }

   public LovEltImpl(long id, String codeInterne, String codeExterne, String codeStatut, int dateCreation, String userCreation, LovDefenitionImpl lovDef)
   {
      this.id = id;
      this.codeInterne = codeInterne;
      this.codeExterne = codeExterne;
      this.codeStatut = codeStatut;
      this.dateCreation = dateCreation;
      this.userCreation = userCreation;
      LovDef = lovDef;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getCodeInterne()
   {
      return codeInterne;
   }

   public void setCodeInterne(String codeInterne)
   {
      this.codeInterne = codeInterne;
   }

   public String getCodeExterne()
   {
      return codeExterne;
   }

   public void setCodeExterne(String codeExterne)
   {
      this.codeExterne = codeExterne;
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

   public LovDefenitionImpl getLovDef()
   {
      return LovDef;
   }

   public void setLovDef(LovDefenitionImpl lovDef)
   {
      LovDef = lovDef;
   }

}
