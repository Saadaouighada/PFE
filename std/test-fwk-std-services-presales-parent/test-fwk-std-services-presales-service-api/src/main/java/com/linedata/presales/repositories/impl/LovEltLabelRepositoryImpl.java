package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.LovEltLabelImpl;
@Transactional

public class LovEltLabelRepositoryImpl extends GenericRepoImpl<LovEltLabelImpl>
{
   public LovEltLabelRepositoryImpl()
   {
      super();
      this.className = "LovEltLabelImpl";
   }
}
