package com.linedata.ekip.testfwkgui.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;
import com.linedata.ekip.testfwkgui.shared.BookData;

@Component
public class BookCreateFormService implements FormService
{

   private static final String       BEANID                = "BookCreateFormService";

   private static final List<String> TRANSFERED_PROPERTIES = Arrays.asList("title", "author");

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   // @Timed
   @Override
   public BookData provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      BookData bookData = new BookData();

      String sourceBlockId = getSourceBlockId(event);

      if (sourceBlockId != null)
      {
         Data sourceData = getSourceData(parameters, sourceBlockId);
         if (sourceData != null)
         {
            transferProperties(bookData, sourceData);
         }
      }
      else
      {
         if (screenContext.getMainEntity() != null)
         {
            transferProperties(bookData, screenContext.getMainEntity());
         }
         else
         {
            bookData.set("title", "test");
         }
      }

      bookData.set("nbPages", 100);

      return bookData;
   }

   private Data getSourceData(Data parameters, String sourceBlockId)
   {
      Data sourceData = null;
      Data serviceParameter = (Data) parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue());
      if (serviceParameter != null)
      {
         sourceData = (Data) serviceParameter.get(sourceBlockId);
      }
      return sourceData;
   }

   private String getSourceBlockId(LovEvent event)
   {
      String fromBlockId = null;
      if (LovEvent.ADVANCEDMODE.equals(event))
      {
         fromBlockId = "bookCreateForm";
      }
      else if (LovEvent.NORMALMODE.equals(event))
      {
         fromBlockId = "bookCreateFormAdvanced";
      }
      return fromBlockId;
   }

   private void transferProperties(BookData toData, Data fromData)
   {
      for (String property : TRANSFERED_PROPERTIES)
      {
         transferProperty(toData, fromData, property);
      }
   }

   private void transferProperty(BookData toData, Data fromData, String property)
   {
      toData.set(property, fromData.get(property));
   }
}
