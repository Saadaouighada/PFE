package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.ConfiguredListsImpl;
import com.linedata.presales.repositories.impl.ConfiguredListsRepositoryImpl;
import com.linedata.presales.service.ConfiguredListsService;

public class ConfiguredListsServiceImpl implements ConfiguredListsService
{
   @Autowired
   ConfiguredListsRepositoryImpl configuredListsRepository;

   public ConfiguredListsRepositoryImpl getConfiguredListsRepository()
   {
      return configuredListsRepository;
   }

   public void setConfiguredListsRepository(ConfiguredListsRepositoryImpl configuredListsRepository)
   {
      this.configuredListsRepository = configuredListsRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<ConfiguredListsImpl> getAll()
   {
      return configuredListsRepository.get("", "");
   }

   // alias = l
   public List<ConfiguredListsImpl> get(String param, String cond)
   {
      return configuredListsRepository.get(param, cond);
   }

   public long save(ConfiguredListsImpl l)
   {
      return this.configuredListsRepository.save(l);
   }

   public void saveAll(List<ConfiguredListsImpl> l)
   {
      this.configuredListsRepository.saveAll(l);
   }

   public void update(ConfiguredListsImpl l)
   {
      this.configuredListsRepository.update(l);
   }

   public ConfiguredListsImpl getOne(long id)
   {
      return this.configuredListsRepository.getOne(id);
   }

   public void delete(ConfiguredListsImpl l)
   {
      this.configuredListsRepository.delete(l);
   }

   public List<ConfiguredListsImpl> getByIdListTypeAndByIdAllocation(String idListType, String idAllocation)
   {
      return this.configuredListsRepository.getByIdListTypeAndByIdAllocation(idListType, idAllocation);
   }

}
