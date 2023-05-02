package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.SelectedPreconfiguredListsImpl;
import com.linedata.presales.repositories.impl.SelectedPreconfiguredListsRepositoryImpl;

public interface SelectedPreconfiguredListsService
{
   public static final String BEANID = "SelectedPreconfiguredListsService";
   public SelectedPreconfiguredListsRepositoryImpl getSelectedPreconfiguredListsRepository();

   public void setSelectedPreconfiguredListsRepository(SelectedPreconfiguredListsRepositoryImpl selectedPreconfiguredListsRepository);

   public List<SelectedPreconfiguredListsImpl> getAll();

   public List<SelectedPreconfiguredListsImpl> get(String param, String cond);

   public void save(SelectedPreconfiguredListsImpl l);

   public void saveAll(List<SelectedPreconfiguredListsImpl> l);

   public void update(SelectedPreconfiguredListsImpl l);

   public void delete(SelectedPreconfiguredListsImpl l);

}
