package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.SelectedServicesImpl;
import com.linedata.presales.repositories.impl.SelectedServicesRepositoryImpl;
import com.linedata.presales.service.SelectedServicesService;

public class SelectedServicesServiceImpl implements SelectedServicesService
{
   @Autowired
   SelectedServicesRepositoryImpl selectedServicesRepository;

   public SelectedServicesRepositoryImpl getSelectedServicesRepository()
   {
      return selectedServicesRepository;
   }

   public void setSelectedServicesRepository(SelectedServicesRepositoryImpl selectedServicesRepository)
   {
      this.selectedServicesRepository = selectedServicesRepository;
   }

   public List<SelectedServicesImpl> getAll()
   {
      return selectedServicesRepository.get("", "");
   }

   // alias = l
   public List<SelectedServicesImpl> get(String param, String cond)
   {
      return selectedServicesRepository.get(param, cond);
   }

   public void save(SelectedServicesImpl l)
   {
      this.selectedServicesRepository.save(l);
   }

   public void saveAll(List<SelectedServicesImpl> l)
   {
      this.selectedServicesRepository.saveAllComposed(l);
   }

   public void update(SelectedServicesImpl l)
   {
      this.selectedServicesRepository.update(l);
   }

   public void delete(SelectedServicesImpl l)
   {
      this.selectedServicesRepository.delete(l);
   }

   public String getBeanId()
   {
      return BEANID;
   }

   public List<SelectedServicesImpl> getByIdAllocation(String idAllocation)
   {
      return this.selectedServicesRepository.getByIdAllocation(idAllocation);
   }

}
