package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.ServicesImpl;
import com.linedata.presales.repositories.impl.AllocationRepositoryImpl;
import com.linedata.presales.repositories.impl.ServicesRepositoryImpl;

public interface ServicesService
{
   public static final String BEANID = "ServicesService";

   public ServicesRepositoryImpl getServicesRepository();

   public void setServicesRepository(ServicesRepositoryImpl servicesRepository);

   public List<ServicesImpl> getAll();

   public List<ServicesImpl> get(String param, String cond);

   public long save(ServicesImpl l);

   public void saveAll(List<ServicesImpl> l);

   public void update(ServicesImpl l);

   public ServicesImpl getOne(long id);

   public void delete(ServicesImpl l);

   public List<ServicesImpl> getByListId(List<Long> list);

   public List<ServicesImpl> getByIdProdcutByCodeStatus(long idProdcut, String codeStatus);

   public List<ServicesImpl> getByListIdExterne(List<String> list);
}
