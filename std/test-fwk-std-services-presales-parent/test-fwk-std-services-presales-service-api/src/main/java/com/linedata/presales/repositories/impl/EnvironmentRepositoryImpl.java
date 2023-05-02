package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.EnvironmentImpl;

@Transactional
public class EnvironmentRepositoryImpl extends GenericRepoImpl<EnvironmentImpl>
{
   public EnvironmentRepositoryImpl()
   {
      super();
      this.className = "EnvironmentImpl";
   }

   public List<EnvironmentImpl> getEnvironmentByCodeStatus(String code)
   {
      return this.get("", " L.codeStatus = " + "'" + code + "'");
   }

   public long countEnvironmentByStatus(String code)
   {
      return this.countByParameter("L.codeStatus = " + "'" + code + "'");
   }

   public EnvironmentImpl getByCode(String code)
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
