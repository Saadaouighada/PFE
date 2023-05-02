package com.linedata.ekip.testfwkgui.book;

import java.util.ArrayList;
import java.util.List;

public class Books
{
   private static List<Book> books;

   private static int        lastId;

   static
   {
      books = new ArrayList<Book>();
      books.add(new Book(1, "Book 1 K2 avec espace", 245));
      books.add(new Book(2, "Book 2", 568));
      books.add(new Book(3, "Book 3", 471));
      books.add(new Book(4, "Book 4", 471));
      books.add(new Book(5, "Book 5", 471));
      books.add(new Book(6, "Book 6", 471));
      books.add(new Book(7, "Book 7", 471));
      books.add(new Book(8, "Book 8", 471));
      books.add(new Book(9, "Book 9", 471));
      books.add(new Book(10, "Book 10", 471));
      books.add(new Book(11, "Book 11", 471));
      books.add(new Book(12, "Book 12", 471));

      lastId = 12;
   }

   public static List<Book> findAll()
   {
      return books;
   }

   public static Book findById(long id)
   {
      Book foundBook = null;

      for (Book book : books)
      {
         if (book.getId() == id)
         {
            foundBook = book;
            break;
         }
      }

      return foundBook;
   }

   public static List<Book> findByTitle(String title)
   {
      List<Book> foundBooks = new ArrayList<Book>();

      if (title == null)
      {
         foundBooks = books;
      }
      else
      {
         String searchedTitle = title.toLowerCase();

         for (Book book : books)
         {
            if (book.getTitle().toLowerCase().contains(searchedTitle))
            {
               foundBooks.add(book);
            }
         }
      }

      return foundBooks;
   }

   public static void save(Book book)
   {
      books.add(book);
   }

   public static void del(Book book)
   {
      books.remove(book);
   }

   public static int getNextId()
   {
      return ++lastId;
   }

}
