package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.PreconfiguredListsImpl;
import com.linedata.presales.entities.impl.ServicesImpl;
@Transactional

public class ServicesRepositoryImpl extends GenericRepoImpl<ServicesImpl>
{

   public ServicesRepositoryImpl()
   {
      super();
      this.className = "ServicesImpl";
   }

   public List<ServicesImpl> getByListId(List<Long> list)
   {
      return this.getByList("L.idService", list);
   }

   public List<ServicesImpl> getByIdProdcutByCodeStatus(long idProdcut, String codeStatus)
   {
      return this.get("", " L.codeStatus = " + "'" + codeStatus + "'" + " AND L.product.idProduct=" + idProdcut);
   }

   public List<ServicesImpl> getByListIdExterne(List<String> list)
   {
      return this.getByStringList("L.idExterne", list);
   }
}
