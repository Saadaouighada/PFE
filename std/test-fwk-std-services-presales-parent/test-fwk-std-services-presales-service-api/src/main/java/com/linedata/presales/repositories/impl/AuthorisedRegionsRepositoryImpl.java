package com.linedata.presales.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.AuthorisedProductsImpl;
import com.linedata.presales.entities.impl.AuthorisedRegionsImpl;
import com.linedata.presales.entities.impl.RegionsImpl;
import com.linedata.presales.entities.impl.UsersImpl;

@Transactional
public class AuthorisedRegionsRepositoryImpl extends GenericRepoImpl<AuthorisedRegionsImpl>
{
   public AuthorisedRegionsRepositoryImpl()
   {
      super();
      this.className = "AuthorisedRegionsImpl";
   }

   public List<RegionsImpl> getRegionsByUserId(String userId)
   {
      List<AuthorisedRegionsImpl> l = new ArrayList(this.get("", "L.user = " + userId));
      List<RegionsImpl> regions = new ArrayList();
      if (l.isEmpty()) return regions;
      for (AuthorisedRegionsImpl i : l)
      {
         regions.add(i.getRegion());
      }
      return regions;
   }

   public List<UsersImpl> getUsersByRegionId(String regId)
   {
      List<AuthorisedRegionsImpl> l = new ArrayList();
      l = this.get("", "L.region = " + regId);
      List<UsersImpl> users = new ArrayList();
      if (l.isEmpty()) return users;
      for (AuthorisedRegionsImpl i : l)
      {
         users.add(i.getUser());
      }
      return users;
   }
}
