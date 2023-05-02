package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.screenservices.ScreenService;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiCloseScreen;
import com.linedata.ekip.core.shared.asi.screenaction.postaction.AsiProvideEntity;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.ScreenServiceResponse;
import com.linedata.ekip.core.shared.lov.LovScreenServiceReturnCode;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Component
public class AuthorCreateScreenService extends ScreenService
{
   private static final String BEANID = "AuthorCreateScreenService";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public void manageActionMappings()
   {
      getActionMappings().put("save", "save");
   }

   public ScreenServiceResponse save(ActionContext actionContext, String functionId, ScreenContext screenContext, Data inParameters)
   {
      ScreenServiceResponse screenServiceResponse = initScreenServiceResponse(screenContext);

      Data bookCreateForm = (Data) inParameters.get("authorCreateForm");

      String firstName = (String) bookCreateForm.get("firstName");
      String lastName = (String) bookCreateForm.get("lastName");

      int id = Authors.getNextId();
      Author author = new Author(id, firstName, lastName, 25);
      Authors.save(author);

      author = Authors.findById(id);
      AuthorData authorData = new AuthorData();
      authorData.set("id", author.getId());
      authorData.set("firstName", author.getFirstName());
      authorData.set("lastName", author.getLastName());

      screenContext.setEntity(authorData);

      AsiCloseScreen close = new AsiCloseScreen();
      close.setSortNumber(0);
      screenServiceResponse.addPostAction(close);
      if ((screenContext.getOthersParameters()).get("FKSOURCE") != null)
      {
         AsiProvideEntity pe = new AsiProvideEntity();
         pe.setSortNumber(1);
         screenServiceResponse.addPostAction(pe);

      }
      screenServiceResponse.setReturnCode(LovScreenServiceReturnCode.CUSTOM);

      return screenServiceResponse;
   }
}
