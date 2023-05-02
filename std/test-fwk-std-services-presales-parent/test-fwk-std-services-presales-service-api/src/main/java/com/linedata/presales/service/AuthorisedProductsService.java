package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.entities.impl.AuthorisedProductsImpl;
import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.AllocationRepositoryImpl;
import com.linedata.presales.repositories.impl.AuthorisedProductsRepositoryImpl;

public interface AuthorisedProductsService
{
   public static final String BEANID = "AuthorisedProductsService";

   public AuthorisedProductsRepositoryImpl getAuthorisedProductsRepository();

   public void setAuthorisedProductsRepository(AuthorisedProductsRepositoryImpl authorisedProductsRepository);

   public List<AuthorisedProductsImpl> getAll();

   public List<AuthorisedProductsImpl> get(String param, String cond);

   public void save(AuthorisedProductsImpl l);

   public void saveAll(List<AuthorisedProductsImpl> l);

   public void update(AuthorisedProductsImpl l);

   public void delete(AuthorisedProductsImpl l);

   public List<ProductsImpl> getProductsByUserId(String userId);

   public List<UsersImpl> getUsersByProductId(String prodId);

}
