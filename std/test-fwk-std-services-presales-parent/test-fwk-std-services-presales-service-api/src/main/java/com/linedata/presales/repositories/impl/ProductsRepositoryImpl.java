package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.ProductsImpl;
@Transactional

public class ProductsRepositoryImpl extends GenericRepoImpl<ProductsImpl>
{
   public ProductsRepositoryImpl()
   {
      super();
      this.className = "ProductsImpl";
   }
}
