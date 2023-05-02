package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.LanguageImpl;
@Transactional
public class LanguageRepositoryImpl extends GenericRepoImpl<LanguageImpl>
{
   public LanguageRepositoryImpl()
   {
      super();
      this.className = "LanguageImpl";
   }

   public LanguageImpl getByCode(String code)
   {
      try
      {
         return this.get("", " L.codeLanguage='" + code + "'").get(0);
      }
      catch (Exception e)
      {
         return null;
      }
   }
}
