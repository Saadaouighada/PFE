package com.linedata.ekip.pos.bean;

import javax.xml.bind.annotation.XmlType;

import com.linedata.ekip.std.services.core.bean.BeanWithKey;

@XmlType(name = "ApplicationMessage")
public class MessageBean implements BeanWithKey
{

   private String message;

   @Override
   public String getBeanKey()
   {
      return "MessageBean";
   }

   public void setMessage(String message)
   {
      this.message = message;
   }

   public String getMessage()
   {
      return message;
   }

}
