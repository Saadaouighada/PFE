package com.linedata.presales.repositories.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericRepoImpl<E>
{
   public String            className = "";
   @Autowired
   protected SessionFactory sessionFactory;

// set className as className alias
// if cond exist then set it as alias.param + cond else set it ""
// if param exist then set it as alias.param else set it ""

   public String getClassName()
   {
      return className;
   }

   public void setClassName(String className)
   {
      this.className = className;
   }

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

   public List<E> get(String param, String cond)
   {
      String hql = " FROM " + className + " L";
      if (param.equals("") == false) hql = "Select " + param + hql;
      if (cond.equals("") == false) hql = hql + " WHERE " + cond;
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      List<E> l = query.list();
      ts.commit();
      return l;
   }

   public List<E> getAll()
   {
      return this.get("", "");
   }

   public List<E> getByList(String param, List<Long> list)
   {
      String hql = " FROM " + className + " L " + " where " + param + " IN (:list)";
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      Query<E> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameterList("list", list);
      List<E> l = query.list();
      ts.commit();
      return l;
   }

   public List<E> getByStringList(String param, List<String> list)
   {
      String hql = " FROM " + className + " L " + " where " + param + " IN (:list)";
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameterList("list", list);
      List<E> l = query.list();
      ts.commit();
      return l;
   }

   @Transactional
   public void update(E e)
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      sessionFactory.getCurrentSession().getSession().update(e);
      ts.commit();
   }

   @Transactional
   public void delete(E e)
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      sessionFactory.getCurrentSession().getSession().delete(e);
      ts.commit();
   }

   public E getOne(long id)
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      E e = (E) sessionFactory.getCurrentSession().get("com.linedata.presales.entities.impl." + this.className, id);
      ts.commit();
      return e;
   }

   @Transactional
   public long save(E e)
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      long id = (long) sessionFactory.getCurrentSession().save(e);
      ts.commit();
      return id;
   }

   @Transactional
   public void saveComposed(E e)
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      sessionFactory.getCurrentSession().save(e);
      ts.commit();
   }

   @Transactional
   public void saveAll(List<E> l)
   {
      for (E e : l)
      {
         this.save(e);
      }
   }

   @Transactional
   public void saveAllComposed(List<E> l)
   {
      for (E e : l)
      {
         this.saveComposed(e);
      }
   }

   public Long countByParameter(String p)
   {
      String hql = " select count(*) FROM " + className + " L " + " WHERE " + p;
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      Long l = (Long) query.getSingleResult();
      ts.commit();
      return l;

   }

   public void open()
   {
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();

   }

   public InputStream countByParameter2(String p) throws SQLException
   {
      String hql = " select companyLogo FROM " + className + " L " + " WHERE " + p;
      Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      Blob l = (Blob) query.getSingleResult();
      InputStream in = l.getBinaryStream();
      ts.commit();
      return in;

   }

}
