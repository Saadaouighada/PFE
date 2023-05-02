package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.AuthorisedRegionsImpl;
import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.AuthorisedRegionsRepositoryImpl;

public interface AuthorisedRegionsService
{
   public static final String BEANID = "AuthorisedRegionsService";
   public AuthorisedRegionsRepositoryImpl getAuthorisedRegionsRepository();

   public void setAuthorisedRegionsRepository(AuthorisedRegionsRepositoryImpl authorisedRegionsRepository);

   public List<AuthorisedRegionsImpl> getAll();

   public List<AuthorisedRegionsImpl> get(String param, String cond);

   public void save(AuthorisedRegionsImpl l);

   public void saveAll(List<AuthorisedRegionsImpl> l);

   public void update(AuthorisedRegionsImpl l);

   public void delete(AuthorisedRegionsImpl l);

   public List<RegionsImpl> getRegionsByUserId(String userId);

   public List<UsersImpl> getUsersByRegionId(String regId);

}
