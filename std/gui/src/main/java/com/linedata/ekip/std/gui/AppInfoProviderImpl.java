/**
 * 
 */
package com.linedata.ekip.std.gui;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.signer.AppInfoProvider;

/**
 * @author IGorodenco
 */
@Component
public class AppInfoProviderImpl implements AppInfoProvider
{

   @Override
   public String getProductName()
   {
      return "EKIP360";
   }

   @Override
   public String getCoreModuleName()
   {
      return "STD";
   }

   // @Override
   // public String getDTKLevel0FeatureName()
   // {
   // return "DTK0";
   // }

   @Override
   public String getDTKLevel1FeatureName()
   {
      return "DTK1";
   }

   @Override
   public String getDTKLevel2FeatureName()
   {
      return "DTK2";
   }

   @Override
   public String getDTKLevel3FeatureName()
   {
      // TODO Auto-generated method stub
      return null;
   }

}
