package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.repositories.impl.AllocationRepositoryImpl;

public interface AllocationService
{
   public static final String BEANID = "AllocationService";
   public List<AllocationImpl> getAll();

   public List<AllocationImpl> get(String param, String cond);

   public long save(AllocationImpl l);

   public void saveAll(List<AllocationImpl> l);

   public void update(AllocationImpl l);

   public AllocationImpl getOne(long id);

   public void delete(AllocationImpl l);

   public AllocationRepositoryImpl getAllocationRepository();

   public void setAllocationRepository(AllocationRepositoryImpl allocationRepository);

   public List<AllocationImpl> getCurrentAllocations();

   public List<AllocationImpl> getAllocationByCodeStatus(String code);

   public Long getCountAllocations(String condition);

}
