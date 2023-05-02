package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.repositories.impl.RegionsRepositoryImpl;

public interface RegionsService
{
   public static final String BEANID = "RegionsService";
   public List<RegionsImpl> getAll();

   public List<RegionsImpl> get(String param, String cond);

   public long save(RegionsImpl l);

   public void saveAll(List<RegionsImpl> l);

   public void update(RegionsImpl l);

   public RegionsImpl getOne(long id);

   public void delete(RegionsImpl l);

   public RegionsRepositoryImpl getRegionsRepository();

   public void setRegionsRepository(RegionsRepositoryImpl regionsRepository);

   public RegionsImpl getByCode(String code);

}
