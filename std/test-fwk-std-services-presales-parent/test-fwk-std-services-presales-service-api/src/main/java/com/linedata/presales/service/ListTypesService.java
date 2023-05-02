package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.entities.impl.ListTypesImpl;
import com.linedata.presales.repositories.impl.LanguageRepositoryImpl;
import com.linedata.presales.repositories.impl.ListTypesRepositoryImpl;

public interface ListTypesService
{
   public static final String BEANID = "ListTypesService";

   public ListTypesRepositoryImpl getListTypesRepository();

   public void setListTypesRepository(ListTypesRepositoryImpl listTypesRepository);

   public String getBeanId();

   public List<ListTypesImpl> getAll();

   public List<ListTypesImpl> get(String param, String cond);

   public long save(ListTypesImpl l);

   public void saveAll(List<ListTypesImpl> l);

   public void update(ListTypesImpl l);

   public ListTypesImpl getOne(long id);

   public void delete(ListTypesImpl l);

}
