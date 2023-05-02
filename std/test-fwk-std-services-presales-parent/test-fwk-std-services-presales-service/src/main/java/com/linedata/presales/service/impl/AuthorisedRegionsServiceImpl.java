package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.AuthorisedRegionsImpl;
import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.AuthorisedRegionsRepositoryImpl;
import com.linedata.presales.service.AuthorisedRegionsService;

public class AuthorisedRegionsServiceImpl implements AuthorisedRegionsService
{
   @Autowired
   AuthorisedRegionsRepositoryImpl authorisedRegionsRepository;

   public AuthorisedRegionsRepositoryImpl getAuthorisedRegionsRepository()
   {
      return authorisedRegionsRepository;
   }

   public void setAuthorisedRegionsRepository(AuthorisedRegionsRepositoryImpl authorisedRegionsRepository)
   {
      this.authorisedRegionsRepository = authorisedRegionsRepository;
   }

   public List<AuthorisedRegionsImpl> getAll()
   {
      return authorisedRegionsRepository.get("", "");
   }

   // alias = l
   public List<AuthorisedRegionsImpl> get(String param, String cond)
   {
      return authorisedRegionsRepository.get(param, cond);
   }

   public void save(AuthorisedRegionsImpl l)
   {
      this.authorisedRegionsRepository.saveComposed(l);
   }

   public void saveAll(List<AuthorisedRegionsImpl> l)
   {
      this.authorisedRegionsRepository.saveAll(l);
   }

   public void update(AuthorisedRegionsImpl l)
   {
      this.authorisedRegionsRepository.update(l);
   }

   public void delete(AuthorisedRegionsImpl l)
   {
      this.authorisedRegionsRepository.delete(l);
   }

   public List<RegionsImpl> getRegionsByUserId(String userId)
   {
      return this.authorisedRegionsRepository.getRegionsByUserId(userId);
   }

   public List<UsersImpl> getUsersByRegionId(String regId)
   {
      return this.authorisedRegionsRepository.getUsersByRegionId(regId);
   }

   public String getBeanId()
   {
      return BEANID;
   }
}
