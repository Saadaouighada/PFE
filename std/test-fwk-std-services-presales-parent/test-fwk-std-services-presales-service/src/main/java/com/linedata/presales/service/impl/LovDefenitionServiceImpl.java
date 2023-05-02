package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.LovDefenitionImpl;
import com.linedata.presales.repositories.impl.LovDefenitionIRepositoryImpl;
import com.linedata.presales.service.LovDefenitionService;

public class LovDefenitionServiceImpl implements LovDefenitionService
{
   @Autowired
   LovDefenitionIRepositoryImpl lovDefenitionIRepository;

   public LovDefenitionIRepositoryImpl getLovDefenitionIRepository()
   {
      return lovDefenitionIRepository;
   }

   public void setLovDefenitionIRepository(LovDefenitionIRepositoryImpl lovDefenitionIRepository)
   {
      this.lovDefenitionIRepository = lovDefenitionIRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<LovDefenitionImpl> getAll()
   {
      return lovDefenitionIRepository.get("", "");
   }

   // alias = l
   public List<LovDefenitionImpl> get(String param, String cond)
   {
      return lovDefenitionIRepository.get(param, cond);
   }

   public long save(LovDefenitionImpl l)
   {
      return this.lovDefenitionIRepository.save(l);
   }

   public void saveAll(List<LovDefenitionImpl> l)
   {
      this.lovDefenitionIRepository.saveAll(l);
   }

   public void update(LovDefenitionImpl l)
   {
      this.lovDefenitionIRepository.update(l);
   }

   public LovDefenitionImpl getOne(long id)
   {
      return this.lovDefenitionIRepository.getOne(id);
   }

   public void delete(LovDefenitionImpl l)
   {
      this.lovDefenitionIRepository.delete(l);
   }
}
