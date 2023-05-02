package com.linedata.presales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.presales.entities.impl.SelectedPreconfiguredListsImpl;
import com.linedata.presales.repositories.impl.SelectedPreconfiguredListsRepositoryImpl;
import com.linedata.presales.service.SelectedPreconfiguredListsService;

public class SelectedPreconfiguredListsServiceImpl implements SelectedPreconfiguredListsService
{
   @Autowired
   SelectedPreconfiguredListsRepositoryImpl selectedPreconfiguredListsRepository;

   public SelectedPreconfiguredListsRepositoryImpl getSelectedPreconfiguredListsRepository()
   {
      return selectedPreconfiguredListsRepository;
   }

   public void setSelectedPreconfiguredListsRepository(SelectedPreconfiguredListsRepositoryImpl selectedPreconfiguredListsRepository)
   {
      this.selectedPreconfiguredListsRepository = selectedPreconfiguredListsRepository;
   }

   public List<SelectedPreconfiguredListsImpl> getAll()
   {
      return selectedPreconfiguredListsRepository.get("", "");
   }

   // alias = l
   public List<SelectedPreconfiguredListsImpl> get(String param, String cond)
   {
      return selectedPreconfiguredListsRepository.get(param, cond);
   }

   public void save(SelectedPreconfiguredListsImpl l)
   {
      this.selectedPreconfiguredListsRepository.save(l);
   }

   public void saveAll(List<SelectedPreconfiguredListsImpl> l)
   {
      this.selectedPreconfiguredListsRepository.saveAll(l);
   }

   public void update(SelectedPreconfiguredListsImpl l)
   {
      this.selectedPreconfiguredListsRepository.update(l);
   }

   public void delete(SelectedPreconfiguredListsImpl l)
   {
      this.selectedPreconfiguredListsRepository.delete(l);
   }

   public String getBeanId()
   {
      return BEANID;
   }
}
