package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.LovEltLabelImpl;
import com.linedata.presales.repositories.impl.LovEltLabelRepositoryImpl;
import com.linedata.presales.service.LovEltLabelService;

public class LovEltLabelServiceImpl implements LovEltLabelService
{
   @Autowired
   LovEltLabelRepositoryImpl lovEltLabelRepository;

   public LovEltLabelRepositoryImpl getlovEltLabelRepository()
   {
      return lovEltLabelRepository;
   }

   public void setlovEltLabelRepository(LovEltLabelRepositoryImpl lovEltLabelRepository)
   {
      this.lovEltLabelRepository = lovEltLabelRepository;
   }

   public List<LovEltLabelImpl> getAll()
   {
      return lovEltLabelRepository.get("", "");
   }

   // alias = l
   public List<LovEltLabelImpl> get(String param, String cond)
   {
      return lovEltLabelRepository.get(param, cond);
   }

   public long save(LovEltLabelImpl l)
   {
      return this.lovEltLabelRepository.save(l);
   }

   public void saveAll(List<LovEltLabelImpl> l)
   {
      this.lovEltLabelRepository.saveAll(l);
   }

   public void update(LovEltLabelImpl l)
   {
      this.lovEltLabelRepository.update(l);
   }

   public LovEltLabelImpl getOne(long id)
   {
      return this.lovEltLabelRepository.getOne(id);
   }

   public void delete(LovEltLabelImpl l)
   {
      this.lovEltLabelRepository.delete(l);
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public LovEltLabelRepositoryImpl getLovEltLabelRepository()
   {
      return lovEltLabelRepository;
   }

   public void setLovEltLabelRepository(LovEltLabelRepositoryImpl lovEltLabelRepository)
   {
      this.lovEltLabelRepository = lovEltLabelRepository;
   }
}
