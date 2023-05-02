package com.linedata.project.management.std.services.service;

public class RunProjectHistoricDiff
{

   public static void main(String[] args)
   {
      HistoricServiceImpl historicService = new HistoricServiceImpl();
      System.out.println("ghadaghada");
      String branchNameChild = "B_5_1_0";
      String branchNameParent = "master";
      String dateBorneMin = "01-11-2022"; //2021-07-21
      String dateBorneMax = "28-02-2023";      
      String workSpace = "C:\\GhadaPFE\\projects";
      String reportDir = "C:\\GhadaPFE\\projects\\reports";
      historicService.checkHistoricDiff(workSpace, branchNameChild, branchNameParent, dateBorneMin, dateBorneMax, reportDir);
     // System.getProperty("java.class.path");
   }
}
 