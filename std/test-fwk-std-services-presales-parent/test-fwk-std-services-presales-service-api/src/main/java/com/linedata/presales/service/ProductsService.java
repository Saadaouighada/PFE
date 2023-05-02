package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.repositories.impl.ProductsRepositoryImpl;

public interface ProductsService
{
   public static final String BEANID = "ProductsService";
   
   public List<ProductsImpl> getAll();

   public List<ProductsImpl> get(String param, String cond);

   public long save(ProductsImpl l);

   public void saveAll(List<ProductsImpl> l);

   public void update(ProductsImpl l);

   public ProductsImpl getOne(long id);

   public void delete(ProductsImpl l);

   public ProductsRepositoryImpl getProductsRepository();

   public void setProductsRepository(ProductsRepositoryImpl productsRepository);

}
