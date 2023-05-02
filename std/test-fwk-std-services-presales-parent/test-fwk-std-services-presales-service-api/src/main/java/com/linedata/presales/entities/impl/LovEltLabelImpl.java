package com.linedata.presales.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOV_ELT_LABEL")
public class LovEltLabelImpl
{
   @Id
   @Column(name = "ID")
   @GeneratedValue(generator = "sequence-generator")
   @org.hibernate.annotations.GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters =
   { @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQLOV_ELTLABEL_ID"), @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
   private long       id;
   @Column(name = "LABEL")
   private String     label;
   @Column(name = "CODE_LANGUAGE")
   private String     codeLanguage;
   @ManyToOne
   @JoinColumn(name = "LOV_ELT_ID")
   private LovEltImpl lovElt;

   public LovEltLabelImpl()
   {
   }

   public LovEltLabelImpl(long id, String label, String codeLanguage, LovEltImpl lovElt)
   {
      this.id = id;
      this.label = label;
      this.codeLanguage = codeLanguage;
      this.lovElt = lovElt;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getLabel()
   {
      return label;
   }

   public void setLabel(String label)
   {
      this.label = label;
   }

   public String getCodeLanguage()
   {
      return codeLanguage;
   }

   public void setCodeLanguage(String codeLanguage)
   {
      this.codeLanguage = codeLanguage;
   }

   public LovEltImpl getLovElt()
   {
      return lovElt;
   }

   public void setLovElt(LovEltImpl lovElt)
   {
      this.lovElt = lovElt;
   }

}
