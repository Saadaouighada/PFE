package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.AllocationImpl;
import com.linedata.presales.repositories.impl.AllocationRepositoryImpl;
import com.linedata.presales.service.AllocationService;

public class AllocationServiceImpl implements AllocationService
{
   @Autowired
   AllocationRepositoryImpl allocationRepository;

   public String getBeanId()
   {
      return BEANID;
   }

   public List<AllocationImpl> getAll()
   {
      return allocationRepository.get("", "");
   }

   // alias = l
   public List<AllocationImpl> get(String param, String cond)
   {
      return allocationRepository.get(param, cond);
   }

   public long save(AllocationImpl l)
   {
      return this.allocationRepository.save(l);
   }

   public void saveAll(List<AllocationImpl> l)
   {
      this.allocationRepository.saveAll(l);
   }

   public void update(AllocationImpl l)
   {
      this.allocationRepository.update(l);
   }

   public AllocationImpl getOne(long id)
   {
      return this.allocationRepository.getOne(id);
   }

   public void delete(AllocationImpl l)
   {
      this.allocationRepository.delete(l);
   }

   public AllocationRepositoryImpl getAllocationRepository()
   {
      return allocationRepository;
   }

   public void setAllocationRepository(AllocationRepositoryImpl allocationRepository)
   {
      this.allocationRepository = allocationRepository;
   }

   public List<AllocationImpl> getCurrentAllocations()
   {
      return this.allocationRepository.getCurrentAllocations();
   }

   public List<AllocationImpl> getAllocationByCodeStatus(String code)
   {
      return this.allocationRepository.getAllocationByCodeStatus(code);
   }

   public Long getCountAllocations(String condition)
   {
      return this.allocationRepository.getCount(condition);
   }

}
