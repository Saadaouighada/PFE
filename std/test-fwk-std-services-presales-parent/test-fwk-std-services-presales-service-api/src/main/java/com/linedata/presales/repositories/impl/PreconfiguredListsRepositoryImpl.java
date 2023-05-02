package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.PreconfiguredListsImpl;
@Transactional

public class PreconfiguredListsRepositoryImpl extends GenericRepoImpl<PreconfiguredListsImpl>
{
   public PreconfiguredListsRepositoryImpl()
   {
      super();
      this.className = "PreconfiguredListsImpl";
   }
}
