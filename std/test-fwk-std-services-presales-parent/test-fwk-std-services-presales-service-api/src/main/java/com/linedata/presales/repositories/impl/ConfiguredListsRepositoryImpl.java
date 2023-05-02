package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.ConfiguredListsImpl;

@Transactional
public class ConfiguredListsRepositoryImpl extends GenericRepoImpl<ConfiguredListsImpl>
{
   public ConfiguredListsRepositoryImpl()
   {
      super();
      this.className = "ConfiguredListsImpl";
   }
   public List<ConfiguredListsImpl> getByIdListTypeAndByIdAllocation(String idListType, String idAllocation)
   {
      return this.get("", " L.listType.idListType = '" + idListType + "' and L.allocation.idAllocation='" + idAllocation + "'");
   }
}
