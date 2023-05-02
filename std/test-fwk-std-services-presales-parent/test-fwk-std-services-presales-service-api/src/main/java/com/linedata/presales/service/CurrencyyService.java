package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.CurrencyImpl;
import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.repositories.impl.CurrencyRepositoryImpl;
import com.linedata.presales.repositories.impl.LanguageRepositoryImpl;

public interface CurrencyyService
{
   public static final String BEANID = "CurrencyyService";

   public CurrencyRepositoryImpl getCurrencyRepository();

   public void setCurrencyRepository(CurrencyRepositoryImpl currencyRepository);

   public List<CurrencyImpl> getAll();

   public List<CurrencyImpl> get(String param, String cond);

   public long save(CurrencyImpl l);

   public void saveAll(List<CurrencyImpl> l);

   public void update(CurrencyImpl l);

   public CurrencyImpl getOne(long id);

   public void delete(CurrencyImpl l);

   public CurrencyImpl getByCode(String code);
}
