package com.linedata.ekip.std.services.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linedata.ekip.core.server.screenservices.GenericSearchService;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.EntityDataReference;
import com.linedata.ekip.testfwkgui.author.Author;
import com.linedata.ekip.testfwkgui.author.Authors;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Service
public class AuthorGenericSearch implements GenericSearchService
{

   @Override
   public List<EntityDataReference> runGenericSearch(Data params)
   {
      String searchString = params.get("searchString");

      List<EntityDataReference> references = new ArrayList<EntityDataReference>();

      for (Author author : Authors.findByLastName(searchString))
      {
         AuthorData authorData = new AuthorData();
         authorData.set("id", author.getId());
         authorData.set("firstName", author.getFirstName());
         authorData.set("lastName", author.getLastName());
         authorData.setSmallIconPath("images/icons/Tiers16.png");

         EntityDataReference reference = new EntityDataReference(authorData);

         reference.setDescription(authorData.getType() + " " + authorData.getDisplayName());
         references.add(reference);
      }

      return references;
   }

}
