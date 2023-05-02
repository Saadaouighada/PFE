package com.linedata.presales.entities.impl;

import java.sql.Blob;

public class ConfigEkipImpl
{
   private long           idConfig;
   private String         idExterne;
   private String         companyName;
   private String         codeColor;
   private CurrencyImpl   currency;
   private LanguageImpl   language;
   private String         codeCurrencyFormat;
   private String         codeDateFormat;
   private Blob           companyLogo;
   private AllocationImpl allocation;

   public ConfigEkipImpl()
   {
   }

   public ConfigEkipImpl(long idConfig, String idExterne, String companyName, String codeColor, CurrencyImpl currency, LanguageImpl language, String codeCurrencyFormat,
            String codeDateFormat, Blob companyLogo, AllocationImpl allocation)
   {
      super();
      this.idConfig = idConfig;
      this.idExterne = idExterne;
      this.companyName = companyName;
      this.codeColor = codeColor;
      this.currency = currency;
      this.language = language;
      this.codeCurrencyFormat = codeCurrencyFormat;
      this.codeDateFormat = codeDateFormat;
      this.companyLogo = companyLogo;
      this.allocation = allocation;
   }

   public long getIdConfig()
   {
      return idConfig;
   }

   public void setIdConfig(long idConfig)
   {
      this.idConfig = idConfig;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public String getCompanyName()
   {
      return companyName;
   }

   public void setCompanyName(String companyName)
   {
      this.companyName = companyName;
   }

   public String getCodeColor()
   {
      return codeColor;
   }

   public void setCodeColor(String codeColor)
   {
      this.codeColor = codeColor;
   }

   public CurrencyImpl getCurrency()
   {
      return currency;
   }

   public void setCurrency(CurrencyImpl currency)
   {
      this.currency = currency;
   }

   public LanguageImpl getLanguage()
   {
      return language;
   }

   public void setLanguage(LanguageImpl language)
   {
      this.language = language;
   }

   public String getCodeCurrencyFormat()
   {
      return codeCurrencyFormat;
   }

   public void setCodeCurrencyFormat(String codeCurrencyFormat)
   {
      this.codeCurrencyFormat = codeCurrencyFormat;
   }

   public String getCodeDateFormat()
   {
      return codeDateFormat;
   }

   public void setCodeDateFormat(String codeDateFormat)
   {
      this.codeDateFormat = codeDateFormat;
   }

   public Blob getCompanyLogo()
   {
      return companyLogo;
   }

   public void setCompanyLogo(Blob companyLogo)
   {
      this.companyLogo = companyLogo;
   }

   public AllocationImpl getAllocation()
   {
      return allocation;
   }

   public void setAllocation(AllocationImpl allocation)
   {
      this.allocation = allocation;
   }

}
