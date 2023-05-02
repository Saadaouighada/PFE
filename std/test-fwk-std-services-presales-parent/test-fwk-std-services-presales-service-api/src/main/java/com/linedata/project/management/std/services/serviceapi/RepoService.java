package com.linedata.project.management.std.services.serviceapi;

import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;

import com.linedata.project.management.std.services.entity.Branch;
import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.Tags;

public interface RepoService {

	public void initGitRepository(String username, String password, String url, String localRepository);

	Repository downloadRepositoryByBranch(String branchName) throws Exception;

	public Repository downloadRepositoryByTag(String tagName) throws Exception;

	public void pullRemoteRep(String remote) throws Exception;

	public void commit(String message, String fileName) throws IOException, NoFilepatternException, GitAPIException;

	public Status push(String remote) throws IOException, NoFilepatternException, GitAPIException;

	public List<Branch> getlistBranches(String url);

	public List<Tags> getListTags(String url);

}
