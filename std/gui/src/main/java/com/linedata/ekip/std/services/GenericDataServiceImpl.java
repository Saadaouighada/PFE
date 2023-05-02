package com.linedata.ekip.std.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.log.LogFactory;
import com.linedata.ekip.commons.server.log.Logger;
import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.std.services.core.genericdata.entity.GenericData;
import com.linedata.ekip.std.services.core.genericdata.entity.GenericDataReference;
import com.linedata.ekip.std.services.core.genericdata.entity.impl.GenericDataImpl;
import com.linedata.ekip.std.services.core.genericdata.service.GenericDataService;
import com.linedata.ekip.std.services.core.service.impl.ServiceImpl;

@Component
public class GenericDataServiceImpl extends ServiceImpl<GenericDataReference, GenericData> implements GenericDataService
{

   private final Logger log = LogFactory.getLog(GenericDataServiceImpl.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public GenericData findGenericDataByReference(ActionContext actionContext, GenericDataReference genericDataReference)
   {
      GenericData genericData = new GenericDataImpl();
      genericData.setCode(genericDataReference.getCode());
      genericData.setType("lov");
      genericData.setLov("BigLov");
      genericData.setLabel("label générique");
      genericData.setStatus("status");
      genericData.setHidden(false);
      genericData.setControl(false);
      genericData.setDefaultValue("option2");
      genericData.setMandatory(false);
      genericData.setCustomControlMessage("test generic code");
      genericData.setFieldId(genericDataReference.getFieldId());

      return genericData;
   }

   @Override
   public GenericData findGenericDataValue(ActionContext actionContext, GenericDataReference genericDataReference)
   {

      return null;
   }

   @Override
   public List<GenericData> findGenericDataValueList(ActionContext actionContext, List<GenericDataReference> genericDataReferences)
   {
      List<GenericData> genericDatas = new ArrayList<GenericData>();

      for (GenericDataReference genericDataReference : genericDataReferences)
      {
         genericDatas.add(findGenericDataByReference(actionContext, genericDataReference));
      }
      return genericDatas;
   }

   @Override
   public List<GenericData> updateGenericData(ActionContext actionContext, List<GenericData> genericData)
   {
      // TODO Auto-generated method stub
      return new ArrayList<GenericData>();
   }

   @Override
   public Boolean doCustomControl(ActionContext actionContext, Object value, GenericDataReference genericDataReference)
   {
      String result = "result";
      boolean valid = true;

      log.debug(actionContext, "do custom control generic");

      // if (result != null)
      // {
      // if (result instanceof String)
      // {
      // valid = false;
      /*
       * throw new
       * CustomControlMessageException("test generic code message custom" );
       */
      // }
      //
      // valid = false;
      // }

      return valid;
   }
}
