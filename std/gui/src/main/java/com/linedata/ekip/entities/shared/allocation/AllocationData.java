package com.linedata.ekip.entities.shared.allocation;

import com.linedata.ekip.core.shared.data.EntityData;
import com.linedata.ekip.entities.shared.LovObjectType;

public class AllocationData extends EntityData
{

   private static final long serialVersionUID = 893975966564717665L;

   @Override
   public void manageKey()
   {
   }

   @Override
   public String getType()
   {
      return LovObjectType.ALLOCATION.getValue();
   }

   @Override
   public String getDisplayName()
   {
      return get("", "Allocation");
   }

}
