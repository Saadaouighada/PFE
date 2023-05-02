package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.AllocationImpl;
@Transactional
public class AllocationRepositoryImpl extends GenericRepoImpl<AllocationImpl>
{

   public AllocationRepositoryImpl()
   {
      super();
      this.className = "AllocationImpl";
   }

   public List<AllocationImpl> getCurrentAllocations()
   {
      return this.get( "", " L.codeStatus = 'CFG' or L.codeStatus = 'INPRG' or L.codeStatus = 'DEMO' ");
   }

   public List<AllocationImpl> getAllocationByCodeStatus(String code)
   {
      return this.get("", " L.codeStatus = " + "'" + code + "'");
   }


   public Long getCount(String condition)
   {
      return this.countByParameter(" L.codeStatus  = " + "'" + condition + "'");
   }
}
