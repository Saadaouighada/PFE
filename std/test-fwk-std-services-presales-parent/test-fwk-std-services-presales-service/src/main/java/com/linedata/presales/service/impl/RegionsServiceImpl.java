package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.repositories.impl.RegionsRepositoryImpl;
import com.linedata.presales.service.RegionsService;

public class RegionsServiceImpl implements RegionsService
{
   @Autowired
   RegionsRepositoryImpl regionsRepository;

   public String getBeanId()
   {
      return BEANID;
   }

   public List<RegionsImpl> getAll()
   {
      return regionsRepository.get("", "");
   }

   // alias = l
   public List<RegionsImpl> get(String param, String cond)
   {
      return regionsRepository.get(param, cond);
   }

   public long save(RegionsImpl l)
   {
      return this.regionsRepository.save(l);
   }

   public void saveAll(List<RegionsImpl> l)
   {
      this.regionsRepository.saveAll(l);
   }

   public void update(RegionsImpl l)
   {
      this.regionsRepository.update(l);
   }

   public RegionsImpl getOne(long id)
   {
      return this.regionsRepository.getOne(id);
   }

   public void delete(RegionsImpl l)
   {
      this.regionsRepository.delete(l);
   }

   public RegionsRepositoryImpl getRegionsRepository()
   {
      return regionsRepository;
   }

   public void setRegionsRepository(RegionsRepositoryImpl regionsRepository)
   {
      this.regionsRepository = regionsRepository;
   }

   public RegionsImpl getByCode(String code)
   {
      return this.regionsRepository.getByCode(code);
   }
}
