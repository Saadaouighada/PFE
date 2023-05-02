package com.linedata.presales.entities.impl;

public class EnvironmentImpl
{
   private long         idEnvironment;
   private String       idExterne;
   private ProductsImpl product;
   private String       name;
   private String       codeStatus;
   private String       databaseName;
   private String       databaseServer;
   private String       applicationServer;
   private String       applicationServerDirectory;
   private String       applicationServerPort;
   private String       databaseServerPort;

   public EnvironmentImpl()
   {
   }

   public EnvironmentImpl(long idEnvironment, String idExterne, ProductsImpl product, String name, String codeStatus, String databaseName, String databaseServer,
            String applicationServer, String applicationServerDirectory, String applicationServerPort, String databaseServerPort)
   {
      this.idEnvironment = idEnvironment;
      this.idExterne = idExterne;
      this.product = product;
      this.name = name;
      this.codeStatus = codeStatus;
      this.databaseName = databaseName;
      this.databaseServer = databaseServer;
      this.applicationServer = applicationServer;
      this.applicationServerDirectory = applicationServerDirectory;
      this.applicationServerPort = applicationServerPort;
      this.databaseServerPort = databaseServerPort;
   }

   public EnvironmentImpl(long idEnvironment)
   {
      this.idEnvironment = idEnvironment;
   }

   public String getIdExterne()
   {
      return idExterne;
   }

   public void setIdExterne(String idExterne)
   {
      this.idExterne = idExterne;
   }

   public long getIdEnvironment()
   {
      return idEnvironment;
   }

   public void setIdEnvironment(long idEnvironment)
   {
      this.idEnvironment = idEnvironment;
   }

   public ProductsImpl getProduct()
   {
      return product;
   }

   public void setProduct(ProductsImpl product)
   {
      this.product = product;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getCodeStatus()
   {
      return codeStatus;
   }

   public void setCodeStatus(String codeStatus)
   {
      this.codeStatus = codeStatus;
   }

   public String getDatabaseName()
   {
      return databaseName;
   }

   public void setDatabaseName(String databaseName)
   {
      this.databaseName = databaseName;
   }

   public String getDatabaseServer()
   {
      return databaseServer;
   }

   public void setDatabaseServer(String databaseServer)
   {
      this.databaseServer = databaseServer;
   }

   public String getApplicationServer()
   {
      return applicationServer;
   }

   public void setApplicationServer(String applicationServer)
   {
      this.applicationServer = applicationServer;
   }

   public String getApplicationServerDirectory()
   {
      return applicationServerDirectory;
   }

   public void setApplicationServerDirectory(String applicationServerDirectory)
   {
      this.applicationServerDirectory = applicationServerDirectory;
   }

   public String getApplicationServerPort()
   {
      return applicationServerPort;
   }

   public void setApplicationServerPort(String applicationServerPort)
   {
      this.applicationServerPort = applicationServerPort;
   }

   public String getDatabaseServerPort()
   {
      return databaseServerPort;
   }

   public void setDatabaseServerPort(String databaseServerPort)
   {
      this.databaseServerPort = databaseServerPort;
   }

}
