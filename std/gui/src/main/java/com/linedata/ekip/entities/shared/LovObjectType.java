package com.linedata.ekip.entities.shared;

public enum LovObjectType
{
   ALLOCATION("ALLOCATION", "");

   private String value;
   private String iconPath;

   public static LovObjectType findByValue(String value)
   {
      if (value == null)
      {
         return null;
      }

      for (LovObjectType lovObjectType : values())
      {
         if (value.equals(lovObjectType.getValue()))
         {
            return lovObjectType;
         }
      }
      return null;
   }

   public String getValue()
   {
      return value;
   }

   private LovObjectType(String value, String iconPath)
   {
      this.value = value;
      this.iconPath = iconPath;
   }

   public String getIconPath()
   {
      return iconPath;
   }
}
