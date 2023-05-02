package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.PreconfiguredListsImpl;
import com.linedata.presales.repositories.impl.PreconfiguredListsRepositoryImpl;

public interface PreconfiguredListsService
{
   public static final String BEANID = "PreconfiguredListsService";
   
   public PreconfiguredListsRepositoryImpl getPreconfiguredListsRepository();

   public void setPreconfiguredListsRepository(PreconfiguredListsRepositoryImpl preconfiguredListsRepository);

   public List<PreconfiguredListsImpl> getAll();

   public List<PreconfiguredListsImpl> get(String param, String cond);

   public long save(PreconfiguredListsImpl l);

   public void saveAll(List<PreconfiguredListsImpl> l);

   public void update(PreconfiguredListsImpl l);

   public PreconfiguredListsImpl getOne(long id);

   public void delete(PreconfiguredListsImpl l);

}
