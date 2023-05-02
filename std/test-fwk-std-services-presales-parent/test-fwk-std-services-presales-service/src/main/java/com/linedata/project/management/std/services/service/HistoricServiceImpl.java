package com.linedata.project.management.std.services.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.DateUtils;

import org.apache.commons.lang3.time.DateFormatUtils;
//import org.apache.hc.client5.http.utils.DateUtils
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.util.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class HistoricServiceImpl
{// implements HistoricService {

   // static Git git;

   static List<RevCommit>                listResult       = new ArrayList<RevCommit>();
   List<RevCommit>                       listResultBefore = new ArrayList<RevCommit>();
   List<RevCommit>                       listAllResult    = new ArrayList<RevCommit>();

   private String                        selectedRelFile  = null;
   /****/
   final static String                   SEPERATOR        = "#�#�#�#";
   private static Workbook               wb;
   private static final SimpleDateFormat dateFormat       = new SimpleDateFormat("ddMMyyyy");
   private static final String           SEPERATOR2       = "#께#께#께#";

   static Hashtable<String, String>      htF              = new Hashtable<String, String>();
   static Hashtable<String, String>      htP              = new Hashtable<String, String>();

   public void checkHistoricDiff(String workSpace, String branchNameChild, String branchNameParent, String dateBorneMin, String dateBorneMax, String reportDir)
   {
      // // create dir workspace
      createDir(workSpace);
      // // create dir output report files
      createDir(reportDir);
      //

      try
      {

         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         Date startDate = sdf.parse(dateBorneMin);
         
         Date endDate = sdf.parse(dateBorneMax);
         List<String> listbranchF = downloadRepositoryByBranch(branchNameChild, workSpace + "/" + branchNameChild + "/ekip-appl", startDate, endDate);

         String[] split;
         for (String msg : listbranchF)
         {
            split = msg.split(SEPERATOR);
            if (!htF.containsKey(split[0]))
            {
               htF.put(split[0], split[0].concat(SEPERATOR).concat(split[1]));
            }
         }

         List<String> listbranchP = downloadRepositoryByBranch(branchNameParent, workSpace + "/" + branchNameParent + "/ekip-appl", startDate, endDate);
       
         //System.out.println("hii "+listbranchP);
         for (String msg : listbranchP)
         {
            split = msg.split(SEPERATOR);
            if (!htP.containsKey(split[0]))
            {
               htP.put(split[0], split[0].concat(SEPERATOR).concat(split[1]));
            }
         }
         List<String> listF = new ArrayList<String>();
         Enumeration<String> keys = htF.keys();
         while (keys.hasMoreElements())
         {
            listF.add(keys.nextElement());
         }
         List<String> listP = new ArrayList<String>();
         keys = htP.keys();
         while (keys.hasMoreElements())
         {
            listP.add(keys.nextElement());
         }
         Collection<String> col = org.codehaus.plexus.util.CollectionUtils.subtract(listF, listP);
         String fileTitle = reportDir + "/diff_".concat(branchNameChild).concat("_").concat(branchNameParent).concat("_").concat(dateFormat.format(new Date())).concat(".xls");
         System.out.println("Start generateExcelReport");
         generateExcelReport(col, fileTitle);
         System.out.println("ENd generateExcelReport");

      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   private static String getDisplayName(PersonIdent person)
   {
      final String pushDate = String.format( "yyyy-MM-dd",person.getWhen());
     
      
      if (StringUtils.isEmptyOrNull(person.getEmailAddress()))
      {

         return person.getName().concat(SEPERATOR2).concat(pushDate);
      }
      final StringBuilder r = new StringBuilder();
      r.append(person.getName()).append(SEPERATOR2).append(pushDate);
      // r.append(" <");
      // r.append(person.getEmailAddress());
      // r.append('>');
      return r.toString().trim();
   }

   private static void deleteFile(String filePath)
   {
      java.io.File f = new java.io.File(filePath);
      if (f.isDirectory())
      {

         for (java.io.File fc : f.listFiles())
         {
            if (fc.isFile()) fc.delete();
            else
               deleteFile(fc.getAbsolutePath());
         }
         f.delete();
      }
      else
         f.delete();

   }

   private static void pullRemoteRep(String local) throws Exception
   {
      FileRepository rep = null;

      System.out.println("get the remote head from GitHub  **** " + local);
      java.io.File repositoryCloned = new java.io.File(local);
      for (java.io.File dotGit : repositoryCloned.listFiles())
      {
         if (dotGit.isDirectory() && dotGit.getName().equals(".git"))
         {
            rep = new FileRepository(dotGit.getAbsolutePath());
            Git gitPull = Git.wrap(rep);
            PullResult result = gitPull.pull().setRebase(true).setRemoteBranchName("refs/heads/master").call();

            FetchResult fetchResult = result.getFetchResult();
            MergeResult mergeResult = result.getMergeResult();
            mergeResult.getMergeStatus();

            System.out.println("  MERGE RESULT : " + mergeResult + " ********  FETCH RESULT : " + fetchResult);
            rep.close();
            break;
         }
      }

   }

   private static void getFiles(Repository repository, RevTree tree)
   {
      TreeWalk treeWalk = new TreeWalk(repository);
      Map<String, String> ressources = new HashMap<String, String>();
      int javaFile = 0;
      int sqlFile = 0;
      int springFile = 0;
      int ihmFile = 0;
      try
      {
         treeWalk.addTree(tree);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      treeWalk.setRecursive(false);
      try
      {
         while (treeWalk.next())
         {
            if (treeWalk.isSubtree())
            {
               treeWalk.enterSubtree();
            }
            else
            {
               if (treeWalk.getPathString().contains(".java"))
               {
                  javaFile++;
               }

               else if (treeWalk.getPathString().contains(".spring.xml"))
               {
                  springFile++;
               }
               else if (treeWalk.getPathString().contains(".sql"))
               {
                  sqlFile++;
               }
               else if (treeWalk.getPathString().contains(".block.xml") || treeWalk.getPathString().contains(".screen.xml"))
               {
                  ihmFile++;
               }
            }
            System.out.println(treeWalk.getPathString());
         }
         System.out.println("javaFile: " + javaFile);

      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      System.out.println("file: " + treeWalk.getPathString());

   }

   private static List<String> downloadRepositoryByBranch(String branchName, String local, Date startDate, Date endDate) throws Exception
   {
      java.io.File dir = new java.io.File(local);
      System.out.println("hello "+dir);
      String foundInBranch = null;
      Git git = null;
      if (dir.exists())
      {
         System.out.println(" Branch:" + branchName + " already exist  in " + local);
         git = Git.open(new java.io.File(local));
      }
      else
      {
         git = Git.cloneRepository().setCredentialsProvider(new UsernamePasswordCredentialsProvider("ghada.saadaoui", "lds03"))
                  .setURI("http://git.cf.linedata.com/gitblit/git/ekip/ekip-appl.git").setDirectory(dir).setBranch(branchName).call();
      }
      List<String> listMSG = new ArrayList<String>();

      // set the list of commits
      RevWalk walk = new RevWalk(git.getRepository());
      System.out.println("gffg"+git.getRepository());
if (git != null && git.getRepository().resolve(branchName) != null && branchName != null) {
	System.out.println("no error null found "+git.getRepository().resolve(branchName));
}
if(git.log().add(git.getRepository().resolve(branchName))!=null)
	System.out.println(" null found");
      Iterable<RevCommit> commits = git.log().add(git.getRepository().resolve(branchName)).call();

      git.checkout();
      Iterator<RevCommit> iterator = commits.iterator();
      while (iterator.hasNext())
      {
         RevCommit commitOfBranch = iterator.next();
         boolean branchFound = false;

         RevCommit targetCommit = walk.parseCommit(git.getRepository().resolve(commitOfBranch.getName()));
         for (Map.Entry<String, Ref> e : git.getRepository().getAllRefs().entrySet())
         {
            if (e.getKey().startsWith(Constants.R_HEADS))
            {
               if (walk.isMergedInto(targetCommit, walk.parseCommit(e.getValue().getObjectId())))
               {
                  foundInBranch = e.getValue().getName();

                  if ("refs/heads/".concat(branchName).equals(foundInBranch))
                  {
                     branchFound = true;
                     break;
                  }
               }
            }
         }
         // System.out.println(commitOfBranch.getFullMessage());
         // getFiles(git.getRepository(), commitOfBranch.getTree());
         if (branchFound)
         {
            // add in entity Author and user
        	// System.out.println("heeeey found !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            String userName_Commit = getDisplayName(commitOfBranch.getAuthorIdent());

            if ((commitOfBranch.getFullMessage().trim().startsWith("[") || commitOfBranch.getFullMessage().trim().startsWith("LPS") || commitOfBranch.getFullMessage().trim()
                     .startsWith("DEV"))
                     && !commitOfBranch.getFullMessage().toLowerCase().contains("release"))
            {
               if (commitOfBranch.getAuthorIdent().getWhen().before(endDate) && commitOfBranch.getAuthorIdent().getWhen().after(startDate))
               {
                  String type = "Autre";
                  if (commitOfBranch.getFullMessage().toLowerCase().contains("perf"))
                  {
                     type = "PERF";
                  }
                  listMSG.add(extractNumJira(commitOfBranch.getFullMessage()).concat(SEPERATOR).concat(commitOfBranch.getFullMessage()).concat(SEPERATOR2).concat(userName_Commit)
                           .concat(SEPERATOR2).concat(type));
               }
            }

         }

      }
      System.out.println(foundInBranch + " Branch Ghada :" + branchName + "  list.size=" + listMSG.size());
      System.out.println("******************************DONE******************************");

      return listMSG;
   }

   private static Integer getIndexOfChar(String str)
   {
      for (int i = 0; i < str.length(); i++)
      {
         try
         {
            if (Integer.valueOf(str.substring(i, i + 1)) >= 0)
            {
               continue;
            }
         }
         catch (NumberFormatException e)
         {
            return i;
         }
      }
      return str.length();
   }

   private static void generateExcelReport(Collection<String> gitResults, String fileTitle)
   {
      wb = null;
      Sheet sheet = null;
      int index = 0;
      try
      {
         File inputWorkbook = new File(fileTitle);

         if (inputWorkbook.exists())
         {
            try
            {
               InputStream inputStream = new FileInputStream(fileTitle);
               POIFSFileSystem fileSystem = null;
               fileSystem = new POIFSFileSystem(inputStream);

               wb = new HSSFWorkbook(fileSystem);
               index = 0;
               // get old shett
               sheet = wb.getSheetAt(0);
               index = sheet.getLastRowNum() + 1;
            }
            catch (IOException e)
            {
               wb = new HSSFWorkbook();
               sheet = wb.createSheet(fileTitle);
               PrintSetup ps = sheet.getPrintSetup();

               sheet.setAutobreaks(true);

               ps.setFitHeight((short) 1);
               ps.setFitWidth((short) 1);
               ps.setLandscape(true);
               // Create header row
               Row header = sheet.createRow(0);

               // Create header row cells.
               createHeaderCell(header, 0, "Fiche Jira");
               createHeaderCell(header, 1, "Message");
               createHeaderCell(header, 2, "Utilisateur");
               createHeaderCell(header, 3, "Date");
               createHeaderCell(header, 4, "Type");

               index = 2;
            }
         }
         else
         {
            wb = new HSSFWorkbook();
            sheet = wb.createSheet(fileTitle.substring(fileTitle.indexOf("/") + 1, fileTitle.indexOf(".")));
            PrintSetup ps = sheet.getPrintSetup();

            sheet.setAutobreaks(true);

            ps.setFitHeight((short) 1);
            ps.setFitWidth((short) 1);
            ps.setLandscape(true);
            // Create header row
            Row header = sheet.createRow(0);

            // Create header row cells.
            createHeaderCell(header, 0, "Fiche Jira");
            createHeaderCell(header, 1, "Message");
            createHeaderCell(header, 2, "Utilisateur");
            createHeaderCell(header, 3, "Date");
            createHeaderCell(header, 4, "Type");

            index = 2;
         }
         Iterator<String> iterator = gitResults.iterator();
         Hashtable<String, String> ht = new Hashtable<String, String>();
         String key = null;
         while (iterator.hasNext())
         {

            String commit = iterator.next();

            Row row = sheet.createRow(index);
            String[] split = null;
            String[] split2 = null;
            // Create cells.
            if (htF.containsKey(commit))
            {
               split = htF.get(commit).split(SEPERATOR);
               split2 = split[1].split(SEPERATOR2);
            }
            else if (htP.containsKey(commit))
            {
               split = htP.get(commit).split(SEPERATOR);
               split2 = split[1].split(SEPERATOR2);
            }
            if (split != null && split2 != null && split2.length >= 2 && !"hudson".equals(split2[1].toLowerCase()))
            {
               row.createCell(0).setCellValue(split[0]);
               row.createCell(1).setCellValue(split2[0]);
               row.createCell(2).setCellValue(split2[1]);
               row.createCell(3).setCellValue(split2[2]);
               row.createCell(4).setCellValue(split2[3]);

               index++;
            }
         }

         sheet.autoSizeColumn(0);
         sheet.autoSizeColumn(1);
         sheet.autoSizeColumn(2);
         sheet.autoSizeColumn(2);
         // Write the output to a file
         FileOutputStream fileOut;

         fileOut = new FileOutputStream(fileTitle);
         wb.write(fileOut);
         fileOut.close();
      }
      catch (Exception e)
      {
         System.out.println("HistoricServiceImpl.generateExcelReport() Exception:" + e.getMessage());
      }
   }

   private static String extractNumJira(String commit)
   {
      String key = null;
      // System.out.println(commit);
      if (commit.trim().startsWith("["))
      {
         key = commit.trim().substring(0, commit.indexOf("-") + 1)
                  .concat(commit.substring(commit.indexOf("-") + 1, commit.indexOf("-") + 1 + getIndexOfChar(commit.substring(commit.indexOf("-") + 1))));
      }
      else if (commit.trim().startsWith("LPS") || commit.trim().startsWith("DEV"))
      {
         String[] split = commit.trim().split("-");
         key = "[".concat(split[0]).concat("-").concat(split[1].substring(0, getIndexOfChar(split[1]))).concat("]");
      }
      if (key.indexOf("]") == -1) key = key.concat("]");
      return key;
   }

   private static Cell createHeaderCell(Row row, int index, String value)
   {
      Cell cell = row.createCell(index);
      cell.setCellValue(value);

      CellStyle style = wb.createCellStyle();

      // Create a new font and alter it.
      Font font = wb.createFont();
      font.setFontHeightInPoints((short) 14);
      font.setFontName("Courier New");
      font.setItalic(true);
     // font.setBoldweight(Font.BOLDWEIGHT_BOLD);
      font.setColor(Font.COLOR_RED);
      style.setFont(font);

      cell.setCellStyle(style);

      return cell;
   }

   private static List<String> logFileLocalTest(String localPath) throws NoHeadException, GitAPIException, IOException
   {
      List<String> listResult2 = new ArrayList<String>();
      // Git git = Git.open(new java.io.File(localPath));
      Repository repo = new FileRepository(localPath);// new
      // FileRepositoryBuilder().setGitDir(new
      // java.io.File(localPath)).build();
      // // repo.create();
      Git git = new Git(repo);
      // git.gc().call();
      // git.clean().call();
      git.checkout().setName("B_3_3").call();
      git.pull().call();
      // String aux = filePath.substring(localPath.length()).replace('\\',
      // '/').replaceFirst("/", "");
      LogCommand lg = git.log().all(); /*
                                        * git.log().add(git.getRepository().resolve
                                        * (Constants.MASTER)).all();//
                                        */// addPath(aux);
      int count = 0;
      listResult2.clear();
      Iterable<RevCommit> log = lg.call();
      for (RevCommit rev : log)
      {
         listResult2.add(rev.getFullMessage());
         // String revId = changeCommitId(rev);
         System.out.println("Commit: " /* + revId + ", name: " */
                  + rev.getName() + ", Message:" + rev.getFullMessage() + ", Author: " + rev.getAuthorIdent().getName());// +
         // " , Date: "
         // +
         // dateCommit(rev));
         count++;
      }
      System.out.println(git.getRepository().getBranch() + "Had " + count + " commits of " + git.getRepository().getFullBranch());
      return listResult2;

   }

   /*****/
   private List<RevCommit> logFileLocal(String filePath, String fileName, String localPath) throws NoHeadException, GitAPIException, IOException
   {
      Git git = Git.open(new java.io.File(localPath));
      String aux = filePath.substring(localPath.length()).replace('\\', '/').replaceFirst("/", "");
      LogCommand lg = git.log().add(git.getRepository().resolve(Constants.HEAD)).all();// addPath(aux);
      int count = 0;
      listResult.clear();
      Iterable<RevCommit> log = lg.call();
      for (RevCommit rev : log)
      {
         listResult.add(rev);
         String revId = changeCommitId(rev);
         System.out.println("Commit: " + revId + ", name: " + rev.getName() + ", Message:" + rev.getFullMessage() + ", Author: " + rev.getAuthorIdent().getName() + " , Date: "
                  + dateCommit(rev));
         count++;
      }
      System.out.println("Had " + count + " commits on " + fileName);
      return listResult;

   }

   private List<RevCommit> logFileFirstLocal(String filePath, String fileName, String localPath_1, String localPath_2) throws NoHeadException, GitAPIException, IOException
   {
      Git git = Git.open(new java.io.File(localPath_2));
      String aux = filePath.substring(localPath_2.length()).replace('\\', '/').replaceFirst("/", "");
      setSelectedRelFile(aux);
      LogCommand lg = git.log().add(git.getRepository().resolve(Constants.HEAD)).addPath(aux);
      int count = 0;
      listResult.clear();
      Iterable<RevCommit> log = lg.call();
      for (RevCommit rev : log)
      {
         listResult.add(rev);
         String revId = changeCommitId(rev);
         System.out.println("Commit: " + revId + ", name: " + rev.getName() + ", Message:" + rev.getFullMessage() + ", Author: " + rev.getAuthorIdent().getName() + " , Date: "
                  + dateCommit(rev));
         count++;
      }
      System.out.println("Had " + count + " commits on " + fileName);
      return listResult;

   }

   private static String changeCommitId(RevCommit rev)
   {
      String id = rev.getId().abbreviate(7).name();
      return id;
   }

   private List<RevCommit> logFileLocalBefore(String filePath, String fileName, String localPath_1, String localPath_2) throws NoHeadException, GitAPIException, IOException
   {
      Git git = Git.open(new java.io.File(localPath_1));

      File pathFile = new File(localPath_1 + '\\' + selectedRelFile);
      if (pathFile.exists())
      {
         LogCommand lg = git.log().addPath(selectedRelFile);
         int count = 0;
         listResultBefore.clear();
         for (RevCommit rev : lg.call())
         {
            listResultBefore.add(rev);
            System.out.println("Commit: " + rev + ", name: " + rev.getName() + ", Message:" + rev.getFullMessage() + ", Author: " + rev.getAuthorIdent().getName() + " , Date: "
                     + dateCommit(rev));
            count++;
         }
         System.out.println("Had " + count + " commits on " + fileName);
         git.close();
         return listResultBefore;
      }
      else
         return null;
   }

   private List<RevCommit> logAll(String localPath) throws NoHeadException, GitAPIException, IOException
   {
      /* log Command of all commits in the current branch */
      Git git = Git.open(new java.io.File(localPath));
      LogCommand lg = git.log().all();
      Iterable<RevCommit> history = lg.call();
      for (RevCommit rev : history)
      {
         listAllResult.add(rev);
         System.out.println("Commit: " + rev + ", name: " + rev.getName() + ", Message:" + rev.getFullMessage() + ", Author: " + rev.getAuthorIdent().getName() + " , Date: "
                  + dateCommit(rev));
      }
      return listAllResult;
   }

   private static long dateCommit(RevCommit rev)
   {
      PersonIdent authorIdent = rev.getAuthorIdent();
      Date authorDate = authorIdent.getWhen();
      Date sysDate = new Date();
      long diff = sysDate.getTime() - authorDate.getTime();
      diff = diff / (1000 * 60 * 60 * 24);
      // TimeZone authorTimeZone = authorIdent.getTimeZone();
      return diff;
   }

   /* compare content of a file between head version and other version */
   private void difference(String localPath, String oldHash, String newHash, String fileName) throws IOException, GitAPIException
   {
      File gitWorkDir = new File(localPath);
      Git git = Git.open(gitWorkDir);

      ObjectId headId = git.getRepository().resolve(newHash + "^{tree}");
      ObjectId oldId = git.getRepository().resolve(oldHash + "^{tree}");

      ObjectReader reader = git.getRepository().newObjectReader();

      CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
      oldTreeIter.reset(reader, oldId);
      CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
      newTreeIter.reset(reader, headId);

      List<DiffEntry> diffs = git.diff().setPathFilter(PathFilter.create(fileName)).setNewTree(newTreeIter).setOldTree(oldTreeIter).call();
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      DiffFormatter df = new DiffFormatter(out);
      df.setRepository(git.getRepository());
      for (DiffEntry diff : diffs)
      {
         df.format(diff);
         diff.getOldId();
         String diffText = out.toString("UTF-8");
         System.out.println(diffText);
         out.reset();
      }

   }

   private String readFileFromRevCommit(String localPath, String fileName, String oldHash) throws IOException
   {

      // find the HEAD
      File gitWorkDir = new File(localPath);
      Git git = Git.open(gitWorkDir);
      String text = null;
      ObjectId lastCommitId = ObjectId.fromString(oldHash);
      // a RevWalk allows to walk over commits based on some filtering
      // that is
      // defined
      RevWalk revWalk = new RevWalk(git.getRepository());
      RevCommit commit = revWalk.parseCommit(lastCommitId);
      // and using commit's tree find the path
      RevTree tree = commit.getTree();
      System.out.println("Having tree: " + tree);

      // now try to find a specific file
      TreeWalk treeWalk = new TreeWalk(git.getRepository());
      treeWalk.addTree(tree);
      treeWalk.setRecursive(true);
      treeWalk.setFilter(PathFilter.create(fileName));
      if (!treeWalk.next())
      {
         throw new IllegalStateException("Did not find expected file " + fileName);
      }
      ObjectId objectId = treeWalk.getObjectId(0);
      ObjectLoader loader = git.getRepository().open(objectId);

      // and then one can the loader to read the file
      loader.copyTo(System.out);
      byte[] bytes = loader.getBytes();
      text = new String(bytes, "utf-8");
      revWalk.dispose();

      return text;
   }

   private void createDir(String directoryName)
   {
      File directory = new File(directoryName);
      if (!directory.exists())
      {
         directory.mkdir();
      }
      System.out.println("direct created" + directory.getAbsoluteFile());
   }

   private String getSelectedRelFile()
   {
      return selectedRelFile;
   }

   private void setSelectedRelFile(String selectedRelFile)
   {
      this.selectedRelFile = selectedRelFile;
   }

}
