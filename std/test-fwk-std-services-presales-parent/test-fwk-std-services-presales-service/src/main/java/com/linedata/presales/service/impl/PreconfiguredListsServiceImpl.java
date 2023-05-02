package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.PreconfiguredListsImpl;
import com.linedata.presales.repositories.impl.PreconfiguredListsRepositoryImpl;
import com.linedata.presales.service.PreconfiguredListsService;

public class PreconfiguredListsServiceImpl implements PreconfiguredListsService
{
   @Autowired
   PreconfiguredListsRepositoryImpl preconfiguredListsRepository;

   public PreconfiguredListsRepositoryImpl getPreconfiguredListsRepository()
   {
      return preconfiguredListsRepository;
   }

   public void setPreconfiguredListsRepository(PreconfiguredListsRepositoryImpl preconfiguredListsRepository)
   {
      this.preconfiguredListsRepository = preconfiguredListsRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<PreconfiguredListsImpl> getAll()
   {
      return preconfiguredListsRepository.get("", "");
   }

   // alias = l
   public List<PreconfiguredListsImpl> get(String param, String cond)
   {
      return preconfiguredListsRepository.get(param, cond);
   }

   public long save(PreconfiguredListsImpl l)
   {
      return this.preconfiguredListsRepository.save(l);
   }

   public void saveAll(List<PreconfiguredListsImpl> l)
   {
      this.preconfiguredListsRepository.saveAll(l);
   }

   public void update(PreconfiguredListsImpl l)
   {
      this.preconfiguredListsRepository.update(l);
   }

   public PreconfiguredListsImpl getOne(long id)
   {
      return this.preconfiguredListsRepository.getOne(id);
   }

   public void delete(PreconfiguredListsImpl l)
   {
      this.preconfiguredListsRepository.delete(l);
   }
}
