package com.linedata.reportihm;
import org.springframework.stereotype.Component;
import com.linedata.ekip.std.services.lov.ScreenLovServiceImpl;
import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLink;
import com.linedata.ekip.core.server.custom.fieldlinkmanager.impl.CustomFieldLinkResponse;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import java.util.HashMap;
import java.util.Map;
public class branchFieldLinkService extends CustomFieldLink
{
	
	   private static final String BEANID = "BranchFieldLinkService";
	   @Override
	   public String getBeanId()
	   {
	      return BEANID;
	   }


	   
	   ScreenLovServiceImpl myScreenlov = new ScreenLovServiceImpl();
	   
	   
	
	 public void  isBranch(ActionContext actionContext, ScreenContext screenContext, Data parameters)
	   {
		   
    	  myScreenlov.generateLovs();
    	  Data branchA = parameters.get("branchA");
	      if (branchA != null)
	      {
	    	
	    	  
	    	  myScreenlov.updateBranchLov( );
	         
	      }
	  
	   }
	
}
