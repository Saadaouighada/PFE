package com.linedata.ekip.testfwkgui.author;

public class Author
{
   private long   id;
   private String firstName;
   private String lastName;
   private int    age;

   public Author()
   {
      super();
   }

   public Author(long id, String firstName, String lastName, int age)
   {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * @return the age
    */
   public int getAge()
   {
      return age;
   }

   /**
    * @param age the age to set
    */
   public void setAge(int age)
   {
      this.age = age;
   }

}
