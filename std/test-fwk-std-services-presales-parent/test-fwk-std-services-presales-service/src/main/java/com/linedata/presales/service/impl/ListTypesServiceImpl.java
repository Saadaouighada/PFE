package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.ListTypesImpl;
import com.linedata.presales.repositories.impl.ListTypesRepositoryImpl;
import com.linedata.presales.service.ListTypesService;

public class ListTypesServiceImpl implements ListTypesService
{
   @Autowired
   ListTypesRepositoryImpl listTypesRepository;

   public ListTypesRepositoryImpl getListTypesRepository()
   {
      return listTypesRepository;
   }

   public void setListTypesRepository(ListTypesRepositoryImpl listTypesRepository)
   {
      this.listTypesRepository = listTypesRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<ListTypesImpl> getAll()
   {
      return listTypesRepository.get("", "");
   }

   // alias = l
   public List<ListTypesImpl> get(String param, String cond)
   {
      return listTypesRepository.get(param, cond);
   }

   public long save(ListTypesImpl l)
   {
      return this.listTypesRepository.save(l);
   }

   public void saveAll(List<ListTypesImpl> l)
   {
      this.listTypesRepository.saveAll(l);
   }

   public void update(ListTypesImpl l)
   {
      this.listTypesRepository.update(l);
   }

   public ListTypesImpl getOne(long id)
   {
      return this.listTypesRepository.getOne(id);
   }

   public void delete(ListTypesImpl l)
   {
      this.listTypesRepository.delete(l);
   }
}
