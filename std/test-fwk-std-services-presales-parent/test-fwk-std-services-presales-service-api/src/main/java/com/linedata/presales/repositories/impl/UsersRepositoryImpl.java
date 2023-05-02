package com.linedata.presales.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.UsersImpl;
@Transactional

public class UsersRepositoryImpl extends GenericRepoImpl<UsersImpl>
{
   public UsersRepositoryImpl()
   {
      super();
      this.className = "UsersImpl";
   }
}
