package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.LovDefenitionImpl;
import com.linedata.presales.repositories.impl.LovDefenitionIRepositoryImpl;

public interface LovDefenitionService
{
   public static final String BEANID = "LovDefenitionService";

   public LovDefenitionIRepositoryImpl getLovDefenitionIRepository();

   public void setLovDefenitionIRepository(LovDefenitionIRepositoryImpl lovDefenitionIRepository);

   public List<LovDefenitionImpl> getAll();

   public List<LovDefenitionImpl> get(String param, String cond);

   public long save(LovDefenitionImpl l);

   public void saveAll(List<LovDefenitionImpl> l);

   public void update(LovDefenitionImpl l);

   public LovDefenitionImpl getOne(long id);

   public void delete(LovDefenitionImpl l);

}
