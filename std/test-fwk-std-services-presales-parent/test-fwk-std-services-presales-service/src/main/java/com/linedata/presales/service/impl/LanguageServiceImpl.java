package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.repositories.impl.LanguageRepositoryImpl;
import com.linedata.presales.service.LanguageService;
import com.linedata.presales.service.LovDefenitionService;

public class LanguageServiceImpl implements LanguageService
{
   @Autowired
   LanguageRepositoryImpl languageRepository;

   public LanguageRepositoryImpl getLanguageRepository()
   {
      return languageRepository;
   }

   public void setLanguageRepository(LanguageRepositoryImpl languageRepository)
   {
      this.languageRepository = languageRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<LanguageImpl> getAll()
   {
      return languageRepository.get("", "");
   }

   // alias = l
   public List<LanguageImpl> get(String param, String cond)
   {
      return languageRepository.get(param, cond);
   }

   public long save(LanguageImpl l)
   {
      return this.languageRepository.save(l);
   }

   public void saveAll(List<LanguageImpl> l)
   {
      this.languageRepository.saveAll(l);
   }

   public void update(LanguageImpl l)
   {
      this.languageRepository.update(l);
   }

   public LanguageImpl getOne(long id)
   {
      return this.languageRepository.getOne(id);
   }

   public void delete(LanguageImpl l)
   {
      this.languageRepository.delete(l);
   }
   public LanguageImpl getByCode(String code)
   {
      return this.languageRepository.getByCode(code);
   }
}
