package com.linedata.presales.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linedata.presales.entities.impl.LanguageImpl;
import com.linedata.presales.entities.impl.LovDefenitionImpl;
@Transactional
public class LovDefenitionIRepositoryImpl extends GenericRepoImpl<LovDefenitionImpl>
{
   public LovDefenitionIRepositoryImpl()
   {
      super();
      this.className = "LovDefenitionImpl";
   }

}
