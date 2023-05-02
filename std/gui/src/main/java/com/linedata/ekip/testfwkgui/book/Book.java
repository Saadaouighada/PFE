package com.linedata.ekip.testfwkgui.book;

public class Book
{
   private long   id;
   private String title;
   private int    nbPages;

   public Book()
   {
      super();
   }

   public Book(long id, String title, int nbPages)
   {
      super();
      this.id = id;
      this.title = title;
      this.nbPages = nbPages;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public int getNbPages()
   {
      return nbPages;
   }

   public void setNbPages(int nbPages)
   {
      this.nbPages = nbPages;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + (int) (id ^ (id >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Book other = (Book) obj;
      if (id != other.id) return false;
      return true;
   }

}
