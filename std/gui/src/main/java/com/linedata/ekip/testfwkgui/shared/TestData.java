package com.linedata.ekip.testfwkgui.shared;

import com.linedata.ekip.core.shared.data.EntityData;


public class TestData extends EntityData
{
	private static final long serialVersionUID = -8598801813364683827L;

   @Override
   public void manageKey()
   {
      getEntityKey().addKey("id");
   }

   @Override
   public String getType()
   {
      return "TEST";
   }

   @Override
   public String getDisplayName()
   {
      return get("label", "");
   }

}
