package com.linedata.ekip.testfwkgui.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.GridService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.error.ScreenError;
import com.linedata.ekip.core.shared.error.impl.RemoteScreenWarning;
import com.linedata.ekip.core.shared.exception.GridInfoResultException;
import com.linedata.ekip.core.shared.lov.LovEvent;
import com.linedata.ekip.core.shared.lov.LovServiceParameter;
import com.linedata.ekip.core.shared.message.ScreenMessage;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Component
public class AuthorSearchResultGridService implements GridService
{

   private static final String BEANID = "AuthorSearchResultGridService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<AuthorData> provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      List<AuthorData> outData = new ArrayList<AuthorData>();

      if (parameters != null)
      {
         final Data criteria = parameters.get(LovServiceParameter.DATASERVICEPARAMETER.getValue(), null);

         if (criteria != null)
         {
            String lastNameCriteria = (String) criteria.get("lastName");

            List<Author> authors = Authors.findByLastName(lastNameCriteria);
            int cpt = 0;
            for (Author author : authors)
            {
               AuthorData authorData = new AuthorData();
               authorData.set("id", author.getId());
               authorData.set("firstName", author.getFirstName());
               authorData.set("lastName", author.getLastName());
               authorData.set("age", author.getAge());
               if (cpt == 0)
               {
                  authorData.set("checked", true);
               }
               if (author.getAge() > 20 && author.getAge() < 23)
               {
                  authorData.set(LovServiceParameter.HIGHTLIGHTFLAG.getValue(), true);
               }
               authorData.set("price", new Double(1500000.2) + (0.01 * cpt++));
               authorData.set("taxe", new Double(20));
               authorData.set("file", "fileTest.txt");
               outData.add(authorData);
            }
         }
      }

      List<ScreenError> errors = new ArrayList<ScreenError>();
      errors.add(new RemoteScreenWarning("Test Warning"));
      List<ScreenMessage> messages = new ArrayList<ScreenMessage>();
      messages.add(new ScreenMessage("Test message"));

      GridInfoResultException e = new GridInfoResultException(errors, messages);
      e.setResult(outData);

      throw e;
      // return outData;
   }
}
