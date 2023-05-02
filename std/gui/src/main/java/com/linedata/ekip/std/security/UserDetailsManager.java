package com.linedata.ekip.std.security;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.linedata.ekip.commons.server.log.LogFactory;
import com.linedata.ekip.commons.server.log.Logger;
import com.linedata.ekip.std.services.core.authentication.entity.UserReference;
import com.linedata.ekip.std.utils.ioc.BeanFactory;

public class UserDetailsManager implements org.springframework.security.provisioning.UserDetailsManager
{
   private static String PASSWORD              = "manager";

   private static Logger log                   = LogFactory.getLog(UserDetailsManager.class);

   /** A list of regular expressions a new password must match to be valid */
   private List<String>  passwordValidationRegexp;

   BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      // PasswordEncoder encodeur = new BCryptPasswordEncoder();
      UserDetails springUser = getSpringUser(username);
      boolean accountNonExpired = true;

      return new org.springframework.security.core.userdetails.User(username, bCryptPasswordEncoder.encode(PASSWORD), true, accountNonExpired, true, true,
               new ArrayList<GrantedAuthority>());
   }

   @Override
   public void createUser(UserDetails user)
   {
   }

   @Override
   public void updateUser(UserDetails user)
   {
   }

   @Override
   public void deleteUser(String username)
   {
   }

   @Override
   public void changePassword(String oldPassword, String newPassword)
   {

      UserReference usrRef = BeanFactory.buildBean(UserReference.class);
      if (!checkNewPasswordValidity(newPassword))
      {
         throw new InsufficientAuthenticationException("New password does not match validity rules");
      }
      if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof org.springframework.security.core.userdetails.User)
      {
         org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication()
                  .getPrincipal();
         usrRef = getUserRef(user.getUsername());
      }

      String encryptedPassword;
      encryptedPassword = bCryptPasswordEncoder.encode(newPassword);
      PASSWORD = encryptedPassword;

   }

   private static UserDetails getSpringUser(String username)
   {
      return new org.springframework.security.core.userdetails.User(username, PASSWORD, new ArrayList<GrantedAuthority>());
   }

   private static UserReference getUserRef(String username)
   {
      UserReference usrRef = BeanFactory.buildBean(UserReference.class);
      usrRef.setEndUser(username);
      return usrRef;
   }

   private boolean checkNewPasswordValidity(String password)
   {
      if (getPasswordValidationRegexp() == null)
      {
         return true;
      }
      for (String regexp : getPasswordValidationRegexp())
      {
         if (!Pattern.matches(regexp, password))
         {
            log.debug(null, "New password did not match validation rule: " + regexp);
            return false;
         }
      }
      return true;
   }

   public List<String> getPasswordValidationRegexp()
   {
      return passwordValidationRegexp;
   }

   public void setPasswordValidationRegexp(List<String> passwordValidationRegexp)
   {
      this.passwordValidationRegexp = passwordValidationRegexp;
   }

   @Override
   public boolean userExists(String username)
   {
      return true;
   }

}
