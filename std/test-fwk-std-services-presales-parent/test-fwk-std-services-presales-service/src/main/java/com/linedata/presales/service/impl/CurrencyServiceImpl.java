package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.CurrencyImpl;
import com.linedata.presales.repositories.impl.CurrencyRepositoryImpl;
import com.linedata.presales.service.CurrencyyService;

public class CurrencyServiceImpl implements CurrencyyService
{
   @Autowired
   CurrencyRepositoryImpl currencyRepository;

   public CurrencyRepositoryImpl getCurrencyRepository()
   {
      return currencyRepository;
   }

   public void setCurrencyRepository(CurrencyRepositoryImpl currencyRepository)
   {
      this.currencyRepository = currencyRepository;
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<CurrencyImpl> getAll()
   {
      return currencyRepository.get("", "");
   }

   // alias = l
   public List<CurrencyImpl> get(String param, String cond)
   {
      return currencyRepository.get(param, cond);
   }

   public long save(CurrencyImpl l)
   {
      return this.currencyRepository.save(l);
   }

   public void saveAll(List<CurrencyImpl> l)
   {
      this.currencyRepository.saveAll(l);
   }

   public void update(CurrencyImpl l)
   {
      this.currencyRepository.update(l);
   }

   public CurrencyImpl getOne(long id)
   {
      return this.currencyRepository.getOne(id);
   }

   public void delete(CurrencyImpl l)
   {
      this.currencyRepository.delete(l);
   }

   public CurrencyImpl getByCode(String code)
   {
      return this.currencyRepository.getByCode(code);
   }
}
