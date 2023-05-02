package com.linedata.presales.entities.impl;

import java.sql.Date;

public class AllocationImpl
{
   private long            idAllocation;
   private String          idExterne;
   private String          name;
   private Date            startDate;
   private Date            endDate;
   private String          codeStatus;
   private String          description;
   private String          login;
   private String          password;
   private UsersImpl       user;
   private EnvironmentImpl environment;
   private RegionsImpl     region;

   public AllocationImpl()
   {

   }

   public AllocationImpl(long idAllocation, String idExterne, String name, Date startDate, Date endDate, String codeStatus, String description, String login, String password,
            UsersImpl user, EnvironmentImpl environment, RegionsImpl region)
   {
      this.idAllocation = idAllocation;
      this.idExterne = idExterne;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.codeStatus = codeStatus;
      this.description = description;
      this.login = login;
      this.password = password;
      this.user = user;
      this.environment = environment;
      this.region = region;
   }

   public AllocationImpl(long idAllocation)
   {
      this.idAllocation = idAllocation;
   }

   public long getIdAllocation()
   {
      return idAllocation;
   }

   public void setIdAllocation(long idAllocation)
   {
      this.idAllocation = idAllocation;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Date getStartDate()
   {
      return startDate;
   }

   public void setStartDate(Date startDate)
   {
      this.startDate = startDate;
   }

   public Date getEndDate()
   {
      return endDate;
   }

   public void setEndDate(Date endDate)
   {
      this.endDate = endDate;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public UsersImpl getUser()
   {
      return user;
   }

   public void setUser(UsersImpl user)
   {
      this.user = user;
   }

   public EnvironmentImpl getEnvironment()
   {
      return environment;
   }

   public void setEnvironment(EnvironmentImpl environment)
   {
      this.environment = environment;
   }

   public RegionsImpl getRegion()
   {
      return region;
   }

   public void setRegion(RegionsImpl region)
   {
      this.region = region;
   }

   public String toString()
   {
      return String.valueOf(this.idAllocation);

   }
}
