package com.linedata.ekip.testfwkgui.shared;

import com.linedata.ekip.core.shared.data.EntityData;

public class BookData extends EntityData
{
   static public final String TYPE             = "book";

   private static final long  serialVersionUID = -1495369206091515931L;

   @Override
   public void manageKey()
   {
      getEntityKey().addKey("id");
   }

   @Override
   public String getType()
   {
      return TYPE;
   }

   @Override
   public String getDisplayName()
   {
      return get("title", "undefined title");
   }

}
