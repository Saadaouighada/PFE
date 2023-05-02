package com.linedata.presales.service.impl;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.ConfigEkipImpl;
import com.linedata.presales.repositories.impl.ConfigEkipRepositoryImpl;
import com.linedata.presales.service.ConfigEkipService;

public class ConfigEkipServiceImpl implements ConfigEkipService
{
   @Autowired
   ConfigEkipRepositoryImpl configEkipRepository;

   public ConfigEkipRepositoryImpl getConfigEkipRepository()
   {
      return configEkipRepository;
   }

   public void setConfigEkipRepository(ConfigEkipRepositoryImpl configEkipRepository)
   {
      this.configEkipRepository = configEkipRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<ConfigEkipImpl> getAll()
   {
      return configEkipRepository.get("", "");
   }

   // alias = l
   public List<ConfigEkipImpl> get(String param, String cond)
   {
      return configEkipRepository.get(param, cond);
   }

   public long save(ConfigEkipImpl l)
   {
      return this.configEkipRepository.save(l);
   }

   public void saveAll(List<ConfigEkipImpl> l)
   {
      this.configEkipRepository.saveAll(l);
   }

   public void update(ConfigEkipImpl l)
   {
      this.configEkipRepository.update(l);
   }

   public ConfigEkipImpl getOne(long id)
   {
      return this.configEkipRepository.getOne(id);
   }

   public void delete(ConfigEkipImpl l)
   {
      this.configEkipRepository.delete(l);
   }

   public ConfigEkipImpl getByIdAllocation(String idAllocation)
   {
      return this.configEkipRepository.getByIdAllocation(idAllocation);
   }

   public InputStream getCountAllocations(long condition)
   {
      try
      {
         return this.configEkipRepository.getCount(condition);
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return null;

      }
   }

}
