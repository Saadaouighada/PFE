package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.AuthorisedProductsImpl;
import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.AuthorisedProductsRepositoryImpl;
import com.linedata.presales.service.AuthorisedProductsService;

public class AuthorisedProductsServiceImpl implements AuthorisedProductsService
{
   @Autowired
   AuthorisedProductsRepositoryImpl authorisedProductsRepository;

   public AuthorisedProductsRepositoryImpl getAuthorisedProductsRepository()
   {
      return authorisedProductsRepository;
   }

   public void setAuthorisedProductsRepository(AuthorisedProductsRepositoryImpl authorisedProductsRepository)
   {
      this.authorisedProductsRepository = authorisedProductsRepository;
   }

   public List<AuthorisedProductsImpl> getAll()
   {
      return authorisedProductsRepository.get("", "");
   }

   // alias = l
   public List<AuthorisedProductsImpl> get(String param, String cond)
   {
      return authorisedProductsRepository.get(param, cond);
   }

   public void save(AuthorisedProductsImpl l)
   {
      this.authorisedProductsRepository.saveComposed(l);
   }

   public void saveAll(List<AuthorisedProductsImpl> l)
   {
      this.authorisedProductsRepository.saveAll(l);
   }

   public void update(AuthorisedProductsImpl l)
   {
      this.authorisedProductsRepository.update(l);
   }

   public void delete(AuthorisedProductsImpl l)
   {
      this.authorisedProductsRepository.delete(l);
   }

   public List<ProductsImpl> getProductsByUserId(String userId)
   {
      return this.authorisedProductsRepository.getProductsByUserId(userId);
   }

   public List<UsersImpl> getUsersByProductId(String prodId)
   {
      return this.authorisedProductsRepository.getUsersByProductId(prodId);
   }

   public String getBeanId()
   {
      return BEANID;
   }
}
