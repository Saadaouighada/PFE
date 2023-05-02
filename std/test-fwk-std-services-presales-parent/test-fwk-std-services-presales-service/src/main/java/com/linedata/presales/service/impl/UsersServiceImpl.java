package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.entities.impl.UsersImpl;
import com.linedata.presales.repositories.impl.UsersRepositoryImpl;
import com.linedata.presales.service.UsersService;

public class UsersServiceImpl implements UsersService
{
   @Autowired
   UsersRepositoryImpl usersRepository;

   public String getBeanId()
   {
      return BEANID;
   }

   public List<UsersImpl> getAll()
   {
      return usersRepository.get("", "");
   }

   // alias = l
   public List<UsersImpl> get(String param, String cond)
   {
      return usersRepository.get(param, cond);
   }

   public long save(UsersImpl l)
   {
      return this.usersRepository.save(l);
   }

   public void saveAll(List<UsersImpl> l)
   {
      this.usersRepository.saveAll(l);
   }

   public void update(UsersImpl l)
   {
      this.usersRepository.update(l);
   }

   public UsersImpl getOne(long id)
   {
      return this.usersRepository.getOne(id);
   }

   public void delete(UsersImpl l)
   {
      this.usersRepository.delete(l);
   }

   public UsersRepositoryImpl getUsersRepository()
   {
      return usersRepository;
   }

   public void setUsersRepository(UsersRepositoryImpl usersRepository)
   {
      this.usersRepository = usersRepository;
   }

}
