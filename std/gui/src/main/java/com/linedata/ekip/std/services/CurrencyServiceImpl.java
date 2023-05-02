package com.linedata.ekip.std.services;

import com.linedata.ekip.core.server.screenservices.CurrencyService;
import com.linedata.ekip.core.shared.data.CurrencyServiceResponse;

public class CurrencyServiceImpl implements CurrencyService
{

   @Override
   public String getBeanId()
   {
      return "CurrencyService";
   }

   @Override
   public CurrencyServiceResponse getCurrencySettings(String currencyCode)
   {
      CurrencyServiceResponse resp = new CurrencyServiceResponse();
      resp.setCurrencySymbol("€");
      resp.setCurrencySymbolPosition(true);
      resp.setDecimalPartDigits(3);
      resp.setDecimalPartSeparator(",");
      resp.setGroupingSeparator(".");
      return resp;
   }

}
