package com.linedata.fwk.dev.server;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.linedata.ekip.commons.server.log.LogFactory;
import com.linedata.ekip.commons.server.log.Logger;

public class PdfLoaderServlet extends HttpServlet
{
   private final Logger logger = LogFactory.getLog(PdfLoaderServlet.class);

   public PdfLoaderServlet()
   {
      ApplicationContext springContext = ContextLoader.getCurrentWebApplicationContext();
   }
   private static final long serialVersionUID = 6215953069774189127L;

   @SuppressWarnings("unchecked")
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      resp.setContentType("application/pdf");

      try
      {
         InputStream in = this.getClass().getResourceAsStream("/pdf/DeNeuville-CatalogueCE2016.pdf");

         resp.setStatus(HttpServletResponse.SC_CREATED);
         byte[] tab = new byte[256];
         while (in.read(tab) > 0)
         {
            resp.getOutputStream().write(tab);
         }

         resp.getOutputStream().flush();
         resp.flushBuffer();
         in.close();

      }
      catch (Exception ex)
      {
         System.out.println("Exception " + ex.getMessage());
      }

   }

}
