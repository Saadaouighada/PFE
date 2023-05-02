package com.linedata.project.management.std.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	final static String url = "jdbc:oracle:thin:@TOOLSV7:1521:TOOLS7";
	final static String db = "TOOLSV7";
	final static String driver = "oracle.jdbc.driver.OracleDriver";
	final static String user = "jira_consult";
	final static String pass = "jira_consult";

   public static Connection getconnection(){
    
      try
      {
         Class.forName(driver);
        
         System.out.println("jdbc driver : " + driver);

         System.out.println("Connection url : " + url + db);
         System.out.println("Connection is created...");

         return DriverManager.getConnection(url, user, pass);
      }
      catch (Exception e)
      {
        return null;
      }

   }
}
