package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.LovEltImpl;
@Transactional

public class LovEltRepositoryImpl extends GenericRepoImpl<LovEltImpl>
{

   public LovEltRepositoryImpl()
   {
      super();
      this.className = "LovEltImpl";
   }

}
