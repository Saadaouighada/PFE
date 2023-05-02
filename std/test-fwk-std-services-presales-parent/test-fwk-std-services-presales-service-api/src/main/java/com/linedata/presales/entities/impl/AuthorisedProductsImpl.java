package com.linedata.presales.entities.impl;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class AuthorisedProductsImpl implements Serializable
{
   private UsersImpl    user;
   private ProductsImpl product;

   public AuthorisedProductsImpl()
   {
   }

   public AuthorisedProductsImpl(UsersImpl user, ProductsImpl product)
   {
      this.user = user;
      this.product = product;
   }

   public UsersImpl getUser()
   {
      return user;
   }

   public void setUser(UsersImpl user)
   {
      this.user = user;
   }

   public ProductsImpl getProduct()
   {
      return product;
   }

   public void setProduct(ProductsImpl product)
   {
      this.product = product;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (!(o instanceof AuthorisedProductsImpl)) return false;
      AuthorisedProductsImpl that = (AuthorisedProductsImpl) o;
      return Objects.equals(this.getUser().getIdUser(), that.getUser().getIdUser()) && Objects.equals(this.getProduct().getIdProduct(), that.getProduct().getIdProduct());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(this.getUser().getIdUser() + this.getProduct().getIdProduct());
   }

}
