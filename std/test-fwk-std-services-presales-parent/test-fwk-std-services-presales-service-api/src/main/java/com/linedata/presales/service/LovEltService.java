package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.LovEltImpl;

import com.linedata.presales.repositories.impl.LovEltRepositoryImpl;

public interface LovEltService
{
   public static final String BEANID = "LovEltService";

   public LovEltRepositoryImpl getlovEltRepository();

   public void setlovEltRepository(LovEltRepositoryImpl lovEltRepository);

   public List<LovEltImpl> getAll();

   public List<LovEltImpl> get(String param, String cond);

   public long save(LovEltImpl l);

   public void saveAll(List<LovEltImpl> l);

   public void update(LovEltImpl l);

   public LovEltImpl getOne(long id);

   public void delete(LovEltImpl l);

   public String getBeanId();

   public LovEltRepositoryImpl getLovEltRepository();

   public void setLovEltRepository(LovEltRepositoryImpl lovEltRepository);

}
