package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.entities.impl.CurrencyImpl;

@Transactional
public class CurrencyRepositoryImpl extends GenericRepoImpl<CurrencyImpl>
{
   public CurrencyRepositoryImpl()
   {
      super();
      this.className = "CurrencyImpl";
   }

   public CurrencyImpl getByCode(String code)
   {
      try
      {
         return this.get("", " L.codeCurrency='" + code + "'").get(0);
      }
      catch (Exception e)
      {
         return null;
      }
   }
}
