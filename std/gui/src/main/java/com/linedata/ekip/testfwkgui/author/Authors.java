package com.linedata.ekip.testfwkgui.author;

import java.util.ArrayList;
import java.util.List;

public class Authors
{
   private static List<Author> authors;

   private static int          lastId;

   static
   {
      authors = new ArrayList<Author>();

      int age = 20;
      int cpt = 0;
      for (int i = 0; i <= 300; i++)
      {
         cpt++;
         authors.add(new Author(i, "FirstName" + i, "LastName" + i, age++));
      }
      lastId = cpt;
   }

   public static List<Author> findAll()
   {
      return authors;
   }

   public static Author findById(long id)
   {
      Author foundAuthor = null;

      for (Author author : authors)
      {
         if (author.getId() == id)
         {
            foundAuthor = author;
            break;
         }
      }

      return foundAuthor;
   }

   public static List<Author> findByLastName(String lastName)
   {
      List<Author> foundAuthors = new ArrayList<Author>();

      if (lastName == null)
      {
         foundAuthors = authors;
      }
      else
      {
         String searchedLastName = lastName.toLowerCase();

         for (Author author : authors)
         {
            if (author.getLastName().toLowerCase().contains(searchedLastName))
            {
               foundAuthors.add(author);
            }
         }
      }

      return foundAuthors;
   }

   public static void save(Author author)
   {
      authors.add(author);
   }

   public static int getNextId()
   {
      return ++lastId;
   }

}
