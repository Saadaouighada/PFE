package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.EnvironmentImpl;
import com.linedata.presales.repositories.impl.EnvironmentRepositoryImpl;

public interface EnvironmentService
{
   public static final String BEANID = "EnvironmentService";
   public List<EnvironmentImpl> getAll();

   public List<EnvironmentImpl> get(String param, String cond);

   public long save(EnvironmentImpl l);

   public void saveAll(List<EnvironmentImpl> l);

   public void update(EnvironmentImpl l);

   public EnvironmentImpl getOne(long id);

   public void delete(EnvironmentImpl l);

   public EnvironmentRepositoryImpl getEnvironmentRepository();

   public void setEnvironmentRepository(EnvironmentRepositoryImpl environmentRepository);

   public List<EnvironmentImpl> getEnvironmentByCodeStatus(String code);

   public long countEnvironmentByStatus(String code);

   public EnvironmentImpl getByCode(String code);

}
