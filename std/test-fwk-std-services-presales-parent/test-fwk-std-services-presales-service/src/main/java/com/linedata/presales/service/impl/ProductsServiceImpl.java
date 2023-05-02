package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.ProductsImpl;
import com.linedata.presales.repositories.impl.ProductsRepositoryImpl;
import com.linedata.presales.service.ProductsService;

public class ProductsServiceImpl implements ProductsService
{
   @Autowired
   ProductsRepositoryImpl productsRepository;

   public String getBeanId()
   {
      return BEANID;
   }

   public List<ProductsImpl> getAll()
   {
      return productsRepository.get("", "");
   }

   // alias = l
   public List<ProductsImpl> get(String param, String cond)
   {
      return productsRepository.get(param, cond);
   }

   public long save(ProductsImpl l)
   {
      return this.productsRepository.save(l);
   }

   public void saveAll(List<ProductsImpl> l)
   {
      this.productsRepository.saveAll(l);
   }

   public void update(ProductsImpl l)
   {
      this.productsRepository.update(l);
   }

   public ProductsImpl getOne(long id)
   {
      return this.productsRepository.getOne(id);
   }

   public void delete(ProductsImpl l)
   {
      this.productsRepository.delete(l);
   }

   public ProductsRepositoryImpl getProductsRepository()
   {
      return productsRepository;
   }

   public void setProductsRepository(ProductsRepositoryImpl productsRepository)
   {
      this.productsRepository = productsRepository;
   }
}
