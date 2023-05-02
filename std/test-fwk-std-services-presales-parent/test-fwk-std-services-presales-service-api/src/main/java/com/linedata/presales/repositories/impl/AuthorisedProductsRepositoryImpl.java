package com.linedata.presales.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.AuthorisedProductsImpl;
import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
@Repository
@Transactional
public class AuthorisedProductsRepositoryImpl extends GenericRepoImpl<AuthorisedProductsImpl>
{

   public AuthorisedProductsRepositoryImpl()
   {
      super();
      this.className = "AuthorisedProductsImpl";
   }

   public List<ProductsImpl> getProductsByUserId(String userId)
   {
      List<AuthorisedProductsImpl> l = new ArrayList(this.get("", "L.user = " + userId));
      List<ProductsImpl> prod = new ArrayList();
      if (l.isEmpty()) return prod;
      for (AuthorisedProductsImpl i : l)
      {
         prod.add(i.getProduct());
      }
      return prod;
   }

   public List<UsersImpl> getUsersByProductId(String prodId)
   {
      List<AuthorisedProductsImpl> l = new ArrayList();
      l = this.get("", "L.product = " + prodId);
      List<UsersImpl> users = new ArrayList();
      if (l.isEmpty()) return users;
      for (AuthorisedProductsImpl i : l)
      {
         users.add(i.getUser());
      }
      return users;
   }
}
