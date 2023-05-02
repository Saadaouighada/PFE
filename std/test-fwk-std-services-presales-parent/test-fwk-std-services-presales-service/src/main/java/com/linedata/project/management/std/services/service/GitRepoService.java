package com.linedata.project.management.std.services.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import util.RepositoryType;
import com.linedata.project.management.std.model.GitRepositoryInfo;
import com.linedata.project.management.std.services.entity.Author;
import com.linedata.project.management.std.services.entity.Branch;
import com.linedata.project.management.std.services.entity.Commit;
import com.linedata.project.management.std.services.entity.File;
import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.Tags;
import com.linedata.project.management.std.services.entity.factory.AuthorFactory;
import com.linedata.project.management.std.services.entity.factory.BranchFactory;
import com.linedata.project.management.std.services.entity.factory.CommitFactory;
import com.linedata.project.management.std.services.entity.factory.FileFactory;
import com.linedata.project.management.std.services.entity.factory.RepositoryFactory;
import com.linedata.project.management.std.services.entity.factory.TagsFactory;
import com.linedata.project.management.std.services.entity.factory.UserFactory;
import com.linedata.project.management.std.services.serviceapi.RepoService;

@Service
@Scope("session")
public class GitRepoService implements RepoService
{
   @Autowired
   RepositoryFactory         repositoryFactory;
   @Autowired
   BranchFactory             branchFactory;
   @Autowired
   TagsFactory               tagFactory;
   @Autowired
   CommitFactory             commitFactory;
   @Autowired
   FileFactory               fileFactory;
   @Autowired
   AuthorFactory             authorFactory;
   @Autowired
   UserFactory               userFactory;

   private GitRepositoryInfo gitRepositoryInfo;

   private Git               git;

   public void initGitRepository(String username, String password, String url, String localRepository)
   {
      gitRepositoryInfo = new GitRepositoryInfo(username, password, url, localRepository);
   }

   private void createOrConfigureGit() throws IOException
   {
      if (git == null)
      {
         if (gitRepositoryInfo != null)
         {
            git = Git.open(new java.io.File(gitRepositoryInfo.getLocalRepository()));
         }
      }
   }

   public void deleteFile(String filePath)
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

   /* cloning the repository by it's branch Name */
   @SuppressWarnings("resource")
   public Repository downloadRepositoryByBranch(String branchName) throws Exception
   {
      java.io.File dir = new java.io.File(gitRepositoryInfo.getLocalRepository());
      if (dir.exists()) deleteFile(gitRepositoryInfo.getLocalRepository());
      // command Git to clone the repository wanted WITH THE BRANCH NAME
      // GIVEN
      git = Git.cloneRepository().setCredentialsProvider(new UsernamePasswordCredentialsProvider(gitRepositoryInfo.getUsername(), gitRepositoryInfo.getPassword()))
               .setURI(gitRepositoryInfo.getUrl()).setDirectory(new java.io.File(gitRepositoryInfo.getLocalRepository())).setBranch(branchName).call();
      // set the list of commits
      RevWalk walk = new RevWalk(git.getRepository());
      Iterable<RevCommit> commits = git.log().add(git.getRepository().resolve(branchName)).call();
      RevCommit commitOfBranch = commits.iterator().next();
      boolean branchFound = false;
      RevCommit targetCommit = walk.parseCommit(git.getRepository().resolve(commitOfBranch.getName()));
      for (Map.Entry<String, Ref> e : git.getRepository().getAllRefs().entrySet())
      {
         if (e.getKey().startsWith(Constants.R_HEADS))
         {
            if (walk.isMergedInto(targetCommit, walk.parseCommit(e.getValue().getObjectId())))
            {
               String foundInBranch = e.getValue().getName();
               System.out.println(" the tag name in repository is :" + foundInBranch);
               branchName = "refs/heads/".concat(branchName);
               if (branchName.equals(foundInBranch))
               {
                  branchFound = true;
                  break;
               }
            }
         }
      }
      if (branchFound)
      {
         // add in entity Author and user
         String userName_Commit = getDisplayName(commitOfBranch.getAuthorIdent());
         // Instantiate author bean
         Author authorUser = authorFactory.buildBean();
         authorUser.setName(userName_Commit);
         // add in the list of files of the commit given
         RevTree tree = targetCommit.getTree();
         TreeWalk treeWalk = new TreeWalk(git.getRepository());

         treeWalk.addTree(tree);
         treeWalk.setRecursive(true);
         // Instantiate the file list for a commit
         List<File> listFilesofCommits = new ArrayList<File>();
         while (treeWalk.next())
         {

            File fileinCommit = fileFactory.buildBean();
            fileinCommit.setFileName(treeWalk.getNameString());
            fileinCommit.setPathName(treeWalk.getPathString());
            listFilesofCommits.add(fileinCommit);
         }
         // Instantiate the list of commits for a branch
         List<Commit> listOfCommitInBranch = new ArrayList<Commit>();
         // Instantiate Commit bean
         Commit commit = commitFactory.buildBean();
         // add in entity commit
         commit.setCommitName(commitOfBranch.getName());
         commit.setCtxt(commitOfBranch.getFullMessage());
         commit.setList(listFilesofCommits);
         commit.setAuthor(authorUser);
         listOfCommitInBranch.add(commit);

         // Instantiate branch bean
         Branch branch = branchFactory.buildBean();
         // add in the entity branch
         branch.setBranchName(branchName);
         branch.setCommit(listOfCommitInBranch);
         // setting the repository
         Repository rep = repositoryFactory.buildBean();
         // add the entity repository
         rep.setUrl(gitRepositoryInfo.getUrl());
         rep.setBranches(branch);
         rep.setLocalURL(gitRepositoryInfo.getLocalRepository());
         rep.setRepositoryType(RepositoryType.GIT);
         rep.setTags(null);
         return rep;
      }
      else
      {
         // if the branch is not found in server
         // return an error message to the user
         throw new Exception(" the branch does not exist in server");
      }

   }

   public static String getDisplayName(PersonIdent person)
   {
      if (StringUtils.isEmptyOrNull(person.getEmailAddress()))
      {
         return person.getName();
      }
      final StringBuilder r = new StringBuilder();
      r.append(person.getName());
      r.append(" <");
      r.append(person.getEmailAddress());
      r.append('>');
      return r.toString().trim();
   }

   public List<Branch> getlistBranches(String url)
   {
      return null;
   }

   /* cloning of the repository by it's tag Name */
   @SuppressWarnings("resource")
   public Repository downloadRepositoryByTag(String tagName) throws Exception
   {
      try
      {

         // Instantiate author bean
         Author authorUser = authorFactory.buildBean();

         // Instantiate the file list for a commit
         List<File> listFilesofCommits = new ArrayList<File>();

         // Instantiate the list of commits for a branch
         List<Commit> listOfCommitInTag = new ArrayList<Commit>();

         // command Git to clone the repository wanted WITH THE BRANCH NAME
         // GIVEN

         git = Git.cloneRepository().setCredentialsProvider(new UsernamePasswordCredentialsProvider(gitRepositoryInfo.getUsername(), gitRepositoryInfo.getPassword()))
                  .setURI(gitRepositoryInfo.getUrl()).setDirectory(new java.io.File(gitRepositoryInfo.getLocalRepository())).call();

         RevWalk walk = new RevWalk(git.getRepository());
         Iterable<RevCommit> commits = git.log().add(git.getRepository().resolve(tagName)).call();
         // getting the commit of the tag mentioned before in the method
         // parameter
         RevCommit commitOfTag = commits.iterator().next();

         // PersonIdent authorIdent = commitOfTag.getAuthorIdent();
         // Date authorDate = authorIdent.getWhen();
         // TimeZone authorTimeZone = authorIdent.getTimeZone();
         //
         // System.out.println(
         // " commit : " + commitOfTag + " === date : " + authorDate + "
         // TimeZone : " + authorTimeZone);
         boolean foundInThisTag = false;
         RevCommit targetCommit = walk.parseCommit(git.getRepository().resolve(commitOfTag.getName()));
         for (Map.Entry<String, Ref> e : git.getRepository().getAllRefs().entrySet())
         {
            if (e.getKey().startsWith(Constants.R_TAGS))
            {
               if (walk.isMergedInto(targetCommit, walk.parseCommit(e.getValue().getObjectId())))
               {
                  String foundInTag = e.getValue().getName();
                  System.out.println(" the tag name in repository is :" + foundInTag);
                  tagName = "refs/tags/".concat(tagName);
                  if (tagName.equals(foundInTag))
                  {
                     foundInThisTag = true;
                     break;
                  }
               }
            }
         }

         if (foundInThisTag)
         {
            // add in entity Author and user
            String userCommit = getDisplayName(commitOfTag.getAuthorIdent());
            authorUser.setName(userCommit);

            // add in the list of files of the commit given
            RevTree tree = targetCommit.getTree();

            TreeWalk treeWalk = new TreeWalk(git.getRepository());
            treeWalk.addTree(tree);
            treeWalk.setRecursive(true);
            while (treeWalk.next())
            {
               // Instantiate File bean
               File fileinCommit = fileFactory.buildBean();
               System.out.println("found: " + treeWalk.getPathString());
               fileinCommit.setFileName(treeWalk.getNameString());
               fileinCommit.setPathName(treeWalk.getPathString());
               listFilesofCommits.add(fileinCommit);
            }

            // add in entity commit
            // Instantiate Commit bean
            Commit commit = commitFactory.buildBean();
            commit.setCommitName(commitOfTag.getName());
            commit.setCtxt(commitOfTag.getFullMessage());
            commit.setList(listFilesofCommits);
            commit.setAuthor(authorUser);
            listOfCommitInTag.add(commit);

            // add in entity tag
            // Instantiate Tags bean
            Tags tag = tagFactory.buildBean();
            tag.setTagName(tagName);
            tag.setCommit(commit);

            // add the entity repository
            // setting the repository
            Repository rep = repositoryFactory.buildBean();
            rep.setUrl(gitRepositoryInfo.getUrl());
            rep.setBranches(null);
            rep.setLocalURL(gitRepositoryInfo.getLocalRepository());
            git.getRepository().getTags();
            rep.setTags(tag);
            // Test of entities
            return rep;

         }
         else
            throw new Exception(" this tag does not exist in server");

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return null;

   }

   /* Checked */
   public void pullRemoteRep(String remote) throws Exception
   {
      FileRepository rep = null;

      System.out.println("get the remote head from GitHub  **** " + gitRepositoryInfo.getLocalRepository());
      java.io.File repositoryCloned = new java.io.File(gitRepositoryInfo.getLocalRepository());
      for (java.io.File dotGit : repositoryCloned.listFiles())
      {
         if (dotGit.isDirectory() && dotGit.getName() == ".git")
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

   public void commit(String message, String fileName) throws IOException, NoFilepatternException, GitAPIException
   {
      // initialize or configure git object
      createOrConfigureGit();
      try
      {
         // writeToFile("file1.txt.txt", message);
         DirCache add = git.add().addFilepattern(".").call();
         updateCache(add);
      }
      catch (NoFilepatternException e)
      {
         throw new IllegalStateException("Unable to add file to the Git cache", e);
      }
      CommitCommand commit = git.commit();
      RevCommit rev = commit.setMessage(message).call();
      System.out.println(" REVCOMMIT MESSAGE RESULT : " + rev.getFullMessage());
   }

   // update cache after changes
   private void updateCache(DirCache cache) throws IOException
   {
      if (!cache.lock())
      {
         throw new IllegalStateException("Unable to lock Git repository cache");
      }
      cache.write();
      if (!cache.commit())
      {
         throw new IllegalStateException("Unable to commit Git repository cache");
      }

   }

   public Status push(String remote) throws IOException, NoFilepatternException, GitAPIException
   {
      // initialize or configure git object
      createOrConfigureGit();
      Iterable<PushResult> iterable = git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(gitRepositoryInfo.getUsername(), gitRepositoryInfo.getPassword()))
               .call();
      PushResult pushResult = iterable.iterator().next();
      Status status = pushResult.getRemoteUpdates().iterator().next().getStatus();
      return status;
   }

   @Override
   public List<Tags> getListTags(String url)
   {
      return null;
   }

}
