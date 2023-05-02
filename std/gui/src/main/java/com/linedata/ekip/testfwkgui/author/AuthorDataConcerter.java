package com.linedata.ekip.testfwkgui.author;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.entityconverter.EntityDataConverter;
import com.linedata.ekip.std.utils.ioc.BeanFactory;
import com.linedata.ekip.testfwkgui.shared.AuthorData;

@Component
public class AuthorDataConcerter extends EntityDataConverter<AuthorReference, AuthorData>
{
   private static final String BEANID = "AuthorDataConcerter";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Class<AuthorReference> getEntityReferenceClass()
   {
      return AuthorReference.class;
   }

   @Override
   public Class<AuthorData> getEntityDataClass()
   {
      return AuthorData.class;
   }

   @Override
   public AuthorReference getEntityReference(AuthorData authorData)
   {
      AuthorReference authorReference = BeanFactory.buildBean(AuthorReference.class);
      Long id = authorData.getLongValue("id");
      authorReference.setId(id);
      return authorReference;
   }

   @Override
   public AuthorData getEntityData(ActionContext actionContext, AuthorReference authorReference)
   {
      AuthorData authorData = new AuthorData();
      Author author = Authors.findById(authorReference.getId());
      authorData.set("id", author.getId());
      authorData.set("firstName", author.getFirstName());
      authorData.set("lastName", author.getLastName());
      return authorData;
   }

}
