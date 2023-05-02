package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.SelectedPreconfiguredListsImpl;
@Transactional

public class SelectedPreconfiguredListsRepositoryImpl extends GenericRepoImpl<SelectedPreconfiguredListsImpl>
{
   public SelectedPreconfiguredListsRepositoryImpl()
   {
      super();
      this.className = "SelectedPreconfiguredListsImpl";
   }
}
