package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.ServicesImpl;
import com.linedata.presales.repositories.impl.ServicesRepositoryImpl;
import com.linedata.presales.service.ServicesService;

public class ServicesServiceImpl implements ServicesService
{
   @Autowired
   ServicesRepositoryImpl servicesRepository;

   public ServicesRepositoryImpl getServicesRepository()
   {
      return servicesRepository;
   }

   public void setServicesRepository(ServicesRepositoryImpl servicesRepository)
   {
      this.servicesRepository = servicesRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<ServicesImpl> getAll()
   {
      return servicesRepository.get("", "");
   }

   // alias = l
   public List<ServicesImpl> get(String param, String cond)
   {
      return servicesRepository.get(param, cond);
   }

   public long save(ServicesImpl l)
   {
      return this.servicesRepository.save(l);
   }

   public void saveAll(List<ServicesImpl> l)
   {
      this.servicesRepository.saveAll(l);
   }

   public void update(ServicesImpl l)
   {
      this.servicesRepository.update(l);
   }

   public ServicesImpl getOne(long id)
   {
      return this.servicesRepository.getOne(id);
   }

   public void delete(ServicesImpl l)
   {
      this.servicesRepository.delete(l);
   }

   public List<ServicesImpl> getByListId(List<Long> list)
   {
      return servicesRepository.getByListId(list);
   }

   public List<ServicesImpl> getByIdProdcutByCodeStatus(long idProdcut, String codeStatus)
   {
      return servicesRepository.getByIdProdcutByCodeStatus(idProdcut, codeStatus);
   }

   public List<ServicesImpl> getByListIdExterne(List<String> list)
   {
      return servicesRepository.getByListIdExterne(list);
   }
}
