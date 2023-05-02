package com.linedata.presales.service;

import java.io.InputStream;
import java.util.List;

import com.linedata.presales.entities.impl.ConfigEkipImpl;
import com.linedata.presales.repositories.impl.ConfigEkipRepositoryImpl;

public interface ConfigEkipService
{
   public static final String BEANID = "ConfigEkipService";

   public ConfigEkipRepositoryImpl getConfigEkipRepository();

   public void setConfigEkipRepository(ConfigEkipRepositoryImpl configEkipRepository);

   public List<ConfigEkipImpl> getAll();

   public List<ConfigEkipImpl> get(String param, String cond);

   public long save(ConfigEkipImpl l);

   public void saveAll(List<ConfigEkipImpl> l);

   public void update(ConfigEkipImpl l);

   public ConfigEkipImpl getOne(long id);

   public void delete(ConfigEkipImpl l);

   public ConfigEkipImpl getByIdAllocation(String idAllocation);

   public InputStream getCountAllocations(long condition);

}
