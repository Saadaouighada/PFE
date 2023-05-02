package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.RegionsImpl;

@Transactional

public class RegionsRepositoryImpl extends GenericRepoImpl<RegionsImpl>
{
   public RegionsRepositoryImpl()
   {
      super();
      this.className = "RegionsImpl";
   }

   public RegionsImpl getByCode(String code)
   {
      try
      {
         return this.get("", " L.idExterne='" + code + "'").get(0);
      }
      catch (Exception e)
      {
         return null;
      }
   }
}
