package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.repositories.impl.ConfiguredListsRepositoryImpl;

public interface ConfiguredListsService
{
   public static final String BEANID = "ConfiguredListsService";
   public ConfiguredListsRepositoryImpl getConfiguredListsRepository();

   public void setConfiguredListsRepository(ConfiguredListsRepositoryImpl configuredListsRepository);

   public List<ConfiguredListsImpl> getAll();

   public List<ConfiguredListsImpl> get(String param, String cond);

   public long save(ConfiguredListsImpl l);

   public void saveAll(List<ConfiguredListsImpl> l);

   public void update(ConfiguredListsImpl l);

   public ConfiguredListsImpl getOne(long id);

   public void delete(ConfiguredListsImpl l);

   public List<ConfiguredListsImpl> getByIdListTypeAndByIdAllocation(String idListType, String idAllocation);
}
