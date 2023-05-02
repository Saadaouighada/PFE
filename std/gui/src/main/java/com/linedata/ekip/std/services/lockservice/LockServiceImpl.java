/**
 * 
 */
package com.linedata.ekip.std.services.lockservice;

import java.util.ArrayList;
import java.util.List;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.std.services.core.exception.EkipServiceException;
import com.linedata.ekip.std.services.core.lock.LockElement;
import com.linedata.ekip.std.services.core.lock.LockElementReference;
import com.linedata.ekip.std.services.core.lock.service.LockService;

/**
 * @author igorodenco
 */
public class LockServiceImpl implements LockService
{

   public static final String BEANID = "LockService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public String getBeanKey()
   {
      return BEANID;
   }

   @Override
   public LockElement isLock(ActionContext actionContext, LockElement lockRef) throws EkipServiceException
   {
      return null;
   }

   @Override
   public boolean lock(ActionContext actionContext, LockElement lock) throws EkipServiceException
   {
      return true;
   }

   @Override
   public boolean lockList(ActionContext actionContext, List<LockElement> listToLock) throws EkipServiceException
   {
      return true;
   }

   @Override
   public boolean unlock(ActionContext actionContext, LockElementReference lockRef) throws EkipServiceException
   {
      return true;
   }

   @Override
   public List<LockElement> getLocks(ActionContext actionContext)
   {
      return new ArrayList<LockElement>();
   }

   @Override
   public boolean lockIfUnlocked(ActionContext arg0, LockElement arg1) throws EkipServiceException
   {

      return true;
   }

   @Override
   public int removeUserLocks(ActionContext actionContext) throws EkipServiceException
   {
      return 0;
   }

   @Override
   public int clearAllLocks() throws EkipServiceException
   {
      // TODO Auto-generated method stub
      return 0;
   }

}
