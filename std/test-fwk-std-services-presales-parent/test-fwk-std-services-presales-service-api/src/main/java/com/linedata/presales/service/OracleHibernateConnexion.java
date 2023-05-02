package com.linedata.presales.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface OracleHibernateConnexion
{
   public void openSimpleSession();

   public void openTensactionalSession();

   public void closeSimpleSession();

   public void closeTensactionalSession();

   public String getClassPathXmlApplicationContext();

   public void setClassPathXmlApplicationContext(String classPathXmlApplicationContext);

   public SessionFactory getSessionFactory();

   public void setSessionFactory(SessionFactory sessionFactory);

   public Session getSession();

   public void setSession(Session session);
}
