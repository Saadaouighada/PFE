package com.linedata.test.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.FormService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.form.StdComplexeValue;
import com.linedata.ekip.core.shared.lov.LovEvent;

@Component
public class TestFormService implements FormService
{

   private static final String BEANID = "TestFormService";

   // @Autowired
   // private PropertiesManager propertiesManager;

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   // @Timed
   @Override
   public Data provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openFunctionMode, ScreenContext screenContext, Data parameters,
            FunctionalContext functionalContext)
   {
      Data outData = new Data();

      outData.set("testProgress1", 0.25d);
      outData.set("testProgress2", 0.5d);
      outData.set("testProgress3", 0.75d);
      outData.set("testProgress4", 1.0d);
      outData.set("testAmountCurrency", "JPY");
      outData.set("testAmount", 1000);
      outData.set("testGrossAmount", 150.0);
      // outData.set("testPercentage", null);
      // outData.set("testSwitchMandatory", "n");

      // outData.set("currency", "EUR");
      // outData.set("simpleField1", 100.00);

      // MessageBean messageBean = propertiesManager.getMessage("es_es",
      // "subject.error.importCrmWrongFieldValue");

      // outData.set("simpleField2", messageBean.getMessage());

      // outData.set("firstQuestionYes", true);
      outData.set("secondQuestionYes", false);
      outData.set("thirdQuestionYes", true);

      // outData.set("firstQuestionNo", false);
      outData.set("secondQuestionNo", true);
      outData.set("thirdQuestionNo", false);

      outData.set("testString", "<h1>test dsfgdgf</h1>");
      Calendar cal = Calendar.getInstance();
      cal.set(2017, 0, 3);
      Date testDate = cal.getTime();
      outData.set("testDate", testDate);

      StdComplexeValue cv = new StdComplexeValue();
      cv.setCssClassName("toto");
      cv.setValue(outData.get("testString"));
      outData.set("testString", cv);

      Data testRemoteLov = new Data();
      testRemoteLov.set("value", "EUR");
      testRemoteLov.set("label", "Euro");

      outData.set("testRemoteLov", "EUR");

      // List<ScreenError> errors = new ArrayList<ScreenError>();
      // errors.add(new RemoteScreenWarning("Test Warning"));
      // List<ScreenMessage> messages = new ArrayList<ScreenMessage>();
      // messages.add(new ScreenMessage("Test message"));

      // FormInfoResultException e = new FormInfoResultException(errors,
      // messages, outData);
      // e.setResult(outData);
      // throw e;
      return outData;

   }
}
