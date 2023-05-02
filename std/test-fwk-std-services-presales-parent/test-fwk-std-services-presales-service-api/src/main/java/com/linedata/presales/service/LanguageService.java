package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.repositories.impl.LanguageRepositoryImpl;

public interface LanguageService
{
   public static final String BEANID = "LanguageService";

   public LanguageRepositoryImpl getLanguageRepository();

   public void setLanguageRepository(LanguageRepositoryImpl languageRepository);

   public List<LanguageImpl> getAll();

   public List<LanguageImpl> get(String param, String cond);

   public long save(LanguageImpl l);

   public void saveAll(List<LanguageImpl> l);

   public void update(LanguageImpl l);

   public LanguageImpl getOne(long id);

   public void delete(LanguageImpl l);

   public LanguageImpl getByCode(String code);
}
