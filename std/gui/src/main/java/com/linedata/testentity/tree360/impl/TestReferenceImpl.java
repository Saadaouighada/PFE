package com.linedata.testentity.tree360.impl;

import java.util.Map;

import com.linedata.ekip.commons.shared.lov.LovFunctionType;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.std.services.core.tree360.EntityReferenceDescriptor;
import com.linedata.testentity.tree360.TestReference;

public class TestReferenceImpl implements TestReference
{

   String internalId;

   public TestReferenceImpl()
   {

   }

   @Override
   public boolean isValid()
   {
      return true;
   }

   @Override
   public String getExternalId()
   {
      return null;
   }

   @Override
   public String getFactoryBeanId()
   {
      return "TestReferenceFactory";
   }

   @Override
   public String getWorkflowEntityCodification()
   {
      return null;
   }

   @Override
   public String getInternalId()
   {
      return internalId;
   }

   public void setInternalId(String internalId)
   {
      this.internalId = internalId;
   }

   @Override
   public LovOpenFunctionMode getOpenFunctionMode()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setOpenFunctionMode(LovOpenFunctionMode openFunctionMode)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getFunctionCode()
   {
      return "fonction " + this.internalId;
   }

   @Override
   public void setFunctionCode(String functionCode)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getPopUpFunctionCode()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setPopUpFunctionCode(String popUpFunctionCode)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public Map<String, Object> getPopupActionParameters()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setPopupActionParameters(Map<String, Object> popupActionParameters)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getLabel()
   {
      return "label " + this.internalId;
   }

   @Override
   public void setLabel(String label)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public boolean isValidateScreenControlFlag()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public void setValidateScreenControlFlag(boolean validateScreenControlFlag)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getInternalObjectId()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setInternalObjectId(String internalObjectId)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public Map<String, Object> getActionParameters()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setActionParameters(Map<String, Object> actionParameters)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public LovFunctionType getFunctionType()
   {
      return LovFunctionType.WORKFLOW;
   }

   @Override
   public void setFunctionType(LovFunctionType functionType)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public EntityReferenceDescriptor getEntityReferenceDescriptor()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setEntityReferenceDescriptor(EntityReferenceDescriptor entityReferenceDescriptor)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public int getEntityDataId()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public void setEntityDataId(int entityDataId)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getIconPath()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setIconPath(String path)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getMenuGroupLabel()
   {
      String menuGroupLabel = null;
      menuGroupLabel = "menu group label";
      return menuGroupLabel;
   }

   @Override
   public void setMenuGroupLabel(String label)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void setMenuGroupIcon(String icon)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getMenuGroupIcon()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Boolean getDataWriteAction()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setDataWriteAction(Boolean dataWriteAction)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public String getActionCode()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setActionCode(String actionCode)
   {
      // TODO Auto-generated method stub

   }

}
