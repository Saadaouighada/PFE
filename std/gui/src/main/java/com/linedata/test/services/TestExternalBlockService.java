package com.linedata.test.services;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.server.log.LogFactory;
import com.linedata.ekip.commons.server.log.Logger;
import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.commons.shared.lov.LovOpenFunctionMode;
import com.linedata.ekip.core.server.screenservices.ExternalBlockService;
import com.linedata.ekip.core.shared.context.functionalcontext.FunctionalContext;
import com.linedata.ekip.core.shared.context.screencontext.ScreenContext;
import com.linedata.ekip.core.shared.data.Data;
import com.linedata.ekip.core.shared.data.logging.StdExternalBlockResponse;
import com.linedata.ekip.core.shared.lov.LovEvent;

@Component
public class TestExternalBlockService implements ExternalBlockService
{

   public static final String BEANID = "TestExternalBlockService";
   private static Logger      log    = LogFactory.getLog(TestExternalBlockService.class);

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public StdExternalBlockResponse provideData(ActionContext actionContext, LovEvent event, LovOpenFunctionMode openLovOpenFunctionMode, ScreenContext screenContext,
            Data inParameters, FunctionalContext functionalContext)
   {
      StdExternalBlockResponse stdExternalBlockResponse = new StdExternalBlockResponse();
      String htmlContent = "<legend>Test</legend><table border=\"1\"><thead><tr><th>Header Cell 01</th><th>Header Cell 02</th><th>Header Cell 03</th><th>Header Cell 04</th></tr></thead><tfoot><tr><th>Footer Cell 01</th><th>Footer Cell 02</th><th>Footer Cell 03</th><th>Footer Cell 04</th></tr></tfoot><tbody><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr><tr><td class=\"cell-1\">Data Cell 01</td><td class=\"cell-2\">Data Cell 02</td><td class=\"cell-3\">Data Cell 03</td><td class=\"cell-4\">Data Cell 04</td></tr></tbody></table>";

      stdExternalBlockResponse.setHtmlContent(htmlContent);
      return stdExternalBlockResponse;
      // StdExternalBlockResponse ret = new StdExternalBlockResponse();

      // ret.setUrl("file://localhost/C:/dev/test/EkipPos.pdf");
      // ret.setUrl("/loadPdf");

      // return ret;
   }
}
