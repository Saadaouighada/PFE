package com.linedata.ekip.testfwkgui.book;

import com.linedata.ekip.std.services.core.entity.EntityReference;

public interface BookReference extends EntityReference
{
   public void setId(long id);

   public long getId();
}
