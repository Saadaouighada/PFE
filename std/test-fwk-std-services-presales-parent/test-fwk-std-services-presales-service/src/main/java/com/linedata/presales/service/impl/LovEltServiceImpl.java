package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.LovEltImpl;
import com.linedata.presales.repositories.impl.LovEltRepositoryImpl;
import com.linedata.presales.service.LovEltService;

public class LovEltServiceImpl implements LovEltService
{
   @Autowired
   LovEltRepositoryImpl lovEltRepository;

   public LovEltRepositoryImpl getlovEltRepository()
   {
      return lovEltRepository;
   }

   public void setlovEltRepository(LovEltRepositoryImpl lovEltRepository)
   {
      this.lovEltRepository = lovEltRepository;
   }

   public List<LovEltImpl> getAll()
   {
      return lovEltRepository.get("", "");
   }

   // alias = l
   public List<LovEltImpl> get(String param, String cond)
   {
      return lovEltRepository.get(param, cond);
   }

   public long save(LovEltImpl l)
   {
      return this.lovEltRepository.save(l);
   }

   public void saveAll(List<LovEltImpl> l)
   {
      this.lovEltRepository.saveAll(l);
   }

   public void update(LovEltImpl l)
   {
      this.lovEltRepository.update(l);
   }

   public LovEltImpl getOne(long id)
   {
      return this.lovEltRepository.getOne(id);
   }

   public void delete(LovEltImpl l)
   {
      this.lovEltRepository.delete(l);
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public LovEltRepositoryImpl getLovEltRepository()
   {
      return lovEltRepository;
   }

   public void setLovEltRepository(LovEltRepositoryImpl lovEltRepository)
   {
      this.lovEltRepository = lovEltRepository;
   }
}
