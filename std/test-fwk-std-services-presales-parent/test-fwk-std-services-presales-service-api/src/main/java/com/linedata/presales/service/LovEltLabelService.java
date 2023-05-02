package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.LovEltLabelImpl;
import com.linedata.presales.repositories.impl.LovEltLabelRepositoryImpl;

public interface LovEltLabelService
{
   public static final String BEANID = "LovEltLabelService";

   public LovEltLabelRepositoryImpl getlovEltLabelRepository();

   public void setlovEltLabelRepository(LovEltLabelRepositoryImpl lovEltLabelRepository);

   public List<LovEltLabelImpl> getAll();

   public List<LovEltLabelImpl> get(String param, String cond);

   public long save(LovEltLabelImpl l);

   public void saveAll(List<LovEltLabelImpl> l);

   public void update(LovEltLabelImpl l);

   public LovEltLabelImpl getOne(long id);

   public void delete(LovEltLabelImpl l);

}
