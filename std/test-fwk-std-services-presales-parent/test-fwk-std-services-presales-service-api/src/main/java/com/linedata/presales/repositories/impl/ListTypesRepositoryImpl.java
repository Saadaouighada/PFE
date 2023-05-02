package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.ListTypesImpl;
@Transactional

public class ListTypesRepositoryImpl extends GenericRepoImpl<ListTypesImpl>
{
   public ListTypesRepositoryImpl()
   {
      super();
      this.className = "ListTypesImpl";
   }
}
