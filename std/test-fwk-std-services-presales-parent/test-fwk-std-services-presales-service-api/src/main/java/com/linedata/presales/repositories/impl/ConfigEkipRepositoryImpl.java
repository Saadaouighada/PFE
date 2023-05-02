package com.linedata.presales.repositories.impl;

import java.io.InputStream;
import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.ConfigEkipImpl;

@Transactional
public class ConfigEkipRepositoryImpl extends GenericRepoImpl<ConfigEkipImpl>
{
   public ConfigEkipRepositoryImpl()
   {
      super();
      this.className = "ConfigEkipImpl";
   }

   public ConfigEkipImpl getByIdAllocation(String idAllocation)
   {
      return this.get("", "L.allocation.idAllocation = " + idAllocation).get(0);
   }

   public InputStream getCount(long condition) throws SQLException
   {
      return this.countByParameter2(" L.idConfig  = " + "'" + condition + "'");
   }
}
