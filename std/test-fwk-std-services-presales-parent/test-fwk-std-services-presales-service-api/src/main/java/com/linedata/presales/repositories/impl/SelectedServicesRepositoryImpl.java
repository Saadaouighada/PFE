package com.linedata.presales.repositories.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.PreconfiguredListsImpl;
import com.linedata.presales.entities.impl.SelectedServicesImpl;
@Transactional

public class SelectedServicesRepositoryImpl extends GenericRepoImpl<SelectedServicesImpl>
{

   public SelectedServicesRepositoryImpl()
   {
      super();
      this.className = "SelectedServicesImpl";
   }

   public List<SelectedServicesImpl> getByIdAllocation(String idAllocation)
   {
      return this.get("", " L.allocation.idAllocation = " + idAllocation);
   }
   
}
