package com.linedata.presales.entities.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linedata.presales.entities.OracleHibernateConnexion;

public class OracleHibernateConnexionImpl implements OracleHibernateConnexion
{
   private String classPathXmlApplicationContext = "spring/oracle/oracleConfigHibernate.spring.xml";
   SessionFactory sessionFactory;
   Session        session;
   Transaction    tx;

   public Session getSession()
   {
      return session;
   }

   public void setSession(Session session)
   {
      this.session = session;
   }

   public OracleHibernateConnexionImpl()
   {
      ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(classPathXmlApplicationContext);
      this.sessionFactory = appContext.getBean(SessionFactory.class);
   }

   public void openSimpleSession()
   {
      try
      {
         this.session = this.sessionFactory.getCurrentSession();
      }
      catch (HibernateException e)
      {
         session = sessionFactory.openSession();
      }
   }

   public void openTensactionalSession()
   {
      this.openSimpleSession();
      this.tx = this.session.beginTransaction();
   }

   public void closeSimpleSession()
   {
   }

   public void closeTensactionalSession()
   {
      this.tx.commit();
      this.closeSimpleSession();
   }

   public String getClassPathXmlApplicationContext()
   {
      return classPathXmlApplicationContext;
   }

   public void setClassPathXmlApplicationContext(String classPathXmlApplicationContext)
   {
      this.classPathXmlApplicationContext = classPathXmlApplicationContext;
   }

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

}
