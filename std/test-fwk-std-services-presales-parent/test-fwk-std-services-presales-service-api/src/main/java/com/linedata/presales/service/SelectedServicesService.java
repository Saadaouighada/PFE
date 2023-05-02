package com.linedata.presales.service;

import java.util.List;

import com.linedata.presales.entities.impl.SelectedServicesImpl;
import com.linedata.presales.repositories.impl.SelectedServicesRepositoryImpl;

public interface SelectedServicesService
{
   public static final String BEANID = "SelectedServicesService";

   public SelectedServicesRepositoryImpl getSelectedServicesRepository();

   public void setSelectedServicesRepository(SelectedServicesRepositoryImpl selectedServicesRepository);

   public List<SelectedServicesImpl> getAll();

   public List<SelectedServicesImpl> get(String param, String cond);

   public void save(SelectedServicesImpl l);

   public void saveAll(List<SelectedServicesImpl> l);

   public void update(SelectedServicesImpl l);

   public void delete(SelectedServicesImpl l);

   public List<SelectedServicesImpl> getByIdAllocation(String idAllocation);
}
