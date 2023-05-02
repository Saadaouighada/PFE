package com.linedata.ekip.std.converter;

import java.math.BigInteger;
import java.util.Date;

import com.linedata.ekip.core.shared.data.Data;

public final class StringConverter
{
   private StringConverter()
   {
   }

   public static String convertIntegerToString(Integer integerValue)
   {
      if (integerValue == null)
      {
         return null;
      }
      return String.valueOf(integerValue);
   }

   public static String convertBigIntegerToString(BigInteger integerValue)
   {
      if (integerValue == null)
      {
         return null;
      }
      return String.valueOf(integerValue);
   }

   public static String convertBooleanToInteger(Boolean booleanValue)
   {
      if (booleanValue == null)
      {
         return null;
      }
      return String.valueOf(booleanValue);
   }

   public static String convertFloatToString(Float floatValue)
   {
      if (floatValue == null)
      {
         return null;
      }
      return String.valueOf(floatValue);
   }

   public static String convertDoubleToString(Double doubleValue)
   {
      if (doubleValue == null)
      {
         return null;
      }
      String stringValue = String.valueOf(doubleValue);
      if (stringValue.endsWith(".0"))
      {
         stringValue = stringValue.replace(".0", "");
      }
      return stringValue;
   }

   public static String convertLongToString(Long longValue)
   {
      if (longValue == null)
      {
         return null;
      }
      return String.valueOf(longValue);
   }

   public static String convertDateToString(Date dateValue)
   {
      if (dateValue == null)
      {
         return null;
      }
      return String.valueOf(dateValue);
   }

   public static String convertObjectToString(Object objectValue)
   {
      if (objectValue == null)
      {
         return null;
      }
      if (objectValue instanceof String)
      {
         return (String) objectValue;
      }
      if (objectValue instanceof Integer)
      {
         return convertIntegerToString((Integer) objectValue);
      }
      if (objectValue instanceof Boolean)
      {
         return convertBooleanToInteger((Boolean) objectValue);
      }
      if (objectValue instanceof Float)
      {
         return convertFloatToString((Float) objectValue);
      }
      if (objectValue instanceof Double)
      {
         return convertDoubleToString((Double) objectValue);
      }
      if (objectValue instanceof Long)
      {
         return convertLongToString((Long) objectValue);
      }
      if (objectValue instanceof Date)
      {
         return convertDateToString((Date) objectValue);
      }
      return String.valueOf(objectValue);
   }

   public static String convertLovToString(Object objectValue)
   {
      if (objectValue != null)
      {
         return String.valueOf(((Data) objectValue).get("value"));
      }
      return null;
   }

}
