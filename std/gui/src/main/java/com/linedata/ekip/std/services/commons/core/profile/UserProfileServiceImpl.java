/**
 * 
 */
package com.linedata.ekip.std.services.commons.core.profile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovProfileElementType;
import com.linedata.ekip.std.dao.core.Model;
import com.linedata.ekip.std.dao.core.ModelReference;
import com.linedata.ekip.std.services.core.profile.ProfileElement;
import com.linedata.ekip.std.services.core.profile.ProfileElementImpl;
import com.linedata.ekip.std.services.core.profile.UserProfileService;
import com.linedata.ekip.std.services.core.service.impl.ServiceImpl;

/**
 * @author igorodenco
 */

@Transactional(readOnly = true)
public class UserProfileServiceImpl extends ServiceImpl<ModelReference, Model> implements UserProfileService
{

   @Override
   public List<ProfileElement> getAllProfileElements(ActionContext arg0)
   {
      List<ProfileElement> profileElements = new ArrayList<ProfileElement>();

      String profile = "test";

      ProfileElement profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.FUNCTION);
      profileElement.setFunctionId("TestForm");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.SCREENACTION);
      profileElement.setFunctionId("TestForm");
      profileElement.setActionCode("testScreenAction");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.BLOCK);
      profileElement.setFunctionId("TestForm");
      profileElement.setBlockId("testForm");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.FUNCTION);
      profileElement.setFunctionId("TestEntitySearch");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.BLOCK);
      profileElement.setFunctionId("TestEntitySearch");
      profileElement.setBlockId("criteria");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.BLOCK);
      profileElement.setFunctionId("TestEntitySearch");
      profileElement.setBlockId("result");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.WIDGET);
      profileElement.setWidgetId("AdminWidget");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.FUNCTION);
      profileElement.setFunctionId("AdminWidget");
      profileElements.add(profileElement);

      profileElement = new ProfileElementImpl();
      profileElement.setProfileCode(profile);
      profileElement.setElementType(LovProfileElementType.SCREENACTION);
      profileElement.setFunctionId("AdminWidget");
      profileElement.setActionCode("reloadProfiles");
      profileElements.add(profileElement);

      return profileElements;
   }

   @Override
   public List<String> getUserProfiles(ActionContext arg0)
   {
      List<String> profiles = new ArrayList<String>();

      profiles.add("test");

      return profiles;
   }

   @Override
   public String getBeanId()
   {
      // TODO Auto-generated method stub
      return BEANID;
   }

   @Override
   public String getMainMenuForUserProfiles(ActionContext actionContext)
   {
      // TODO Auto-generated method stub
      return null;
   }

}
