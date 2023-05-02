package com.linedata.presales.entities.impl;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class AuthorisedRegionsImpl implements Serializable
{
   private UsersImpl   user;
   private RegionsImpl region;

   public AuthorisedRegionsImpl()
   {
   }

   public AuthorisedRegionsImpl(UsersImpl user, RegionsImpl region)
   {
      this.user = user;
      this.region = region;
   }

   public UsersImpl getUser()
   {
      return user;
   }

   public void setUser(UsersImpl user)
   {
      this.user = user;
   }

   public RegionsImpl getRegion()
   {
      return region;
   }

   public void setRegion(RegionsImpl region)
   {
      this.region = region;
   }
   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (!(o instanceof AuthorisedRegionsImpl)) return false;
      AuthorisedRegionsImpl that = (AuthorisedRegionsImpl) o;
      return Objects.equals(this.getUser().getIdUser(), that.getUser().getIdUser()) && Objects.equals(this.getRegion().getIdRegion(), that.getRegion().getIdRegion());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(this.getUser().getIdUser() + this.getRegion().getIdRegion());
   }

}
