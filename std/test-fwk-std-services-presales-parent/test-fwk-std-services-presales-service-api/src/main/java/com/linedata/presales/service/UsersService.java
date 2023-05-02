package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.UsersRepositoryImpl;

public interface UsersService
{
   public static final String BEANID = "UsersService";
   public List<UsersImpl> getAll();

   public List<UsersImpl> get(String param, String cond);

   public long save(UsersImpl l);

   public void saveAll(List<UsersImpl> l);

   public void update(UsersImpl l);

   public UsersImpl getOne(long id);

   public void delete(UsersImpl l);

   public UsersRepositoryImpl getUsersRepository();

   public void setUsersRepository(UsersRepositoryImpl usersRepository);

}
