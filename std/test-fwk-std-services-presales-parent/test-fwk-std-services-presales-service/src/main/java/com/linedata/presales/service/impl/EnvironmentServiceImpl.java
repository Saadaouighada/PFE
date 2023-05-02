package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.repositories.impl.EnvironmentRepositoryImpl;
import com.linedata.presales.service.EnvironmentService;

public class EnvironmentServiceImpl implements EnvironmentService
{
   @Autowired
   EnvironmentRepositoryImpl environmentRepository;

   public String getBeanId()
   {
      return BEANID;
   }

   public List<EnvironmentImpl> getAll()
   {
      return environmentRepository.get("", "");
   }

   // alias = l
   public List<EnvironmentImpl> get(String param, String cond)
   {
      return environmentRepository.get(param, cond);
   }

   public long save(EnvironmentImpl l)
   {
      return this.environmentRepository.save(l);
   }

   public void saveAll(List<EnvironmentImpl> l)
   {
      this.environmentRepository.saveAll(l);
   }

   public void update(EnvironmentImpl l)
   {
      this.environmentRepository.update(l);
   }

   public EnvironmentImpl getOne(long id)
   {
      return this.environmentRepository.getOne(id);
   }

   public void delete(EnvironmentImpl l)
   {
      this.environmentRepository.delete(l);
   }

   public EnvironmentRepositoryImpl getEnvironmentRepository()
   {
      return environmentRepository;
   }

   public void setEnvironmentRepository(EnvironmentRepositoryImpl environmentRepository)
   {
      this.environmentRepository = environmentRepository;
   }

   public List<EnvironmentImpl> getEnvironmentByCodeStatus(String code)
   {
      return environmentRepository.getEnvironmentByCodeStatus(code);
   }

   public long countEnvironmentByStatus(String code)
   {
      return environmentRepository.countEnvironmentByStatus(code);
   }

   public EnvironmentImpl getByCode(String code)
   {
      return this.environmentRepository.getByCode(code);
   }

}
