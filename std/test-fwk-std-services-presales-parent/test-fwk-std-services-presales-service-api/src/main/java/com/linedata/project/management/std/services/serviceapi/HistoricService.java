package com.linedata.project.management.std.services.serviceapi;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.primefaces.showcase.domain.Theme;

import com.linedata.project.management.std.model.JiraLabel;

public interface HistoricService {

	List<RevCommit> logFileLocal(String path, String name, String localPath)
			throws NoHeadException, GitAPIException, IOException;

	List<RevCommit> logFileFirstLocal(String filePath, String fileName, String localPath_1, String localPath_2)
			throws NoHeadException, GitAPIException, IOException;

	List<RevCommit> logFileLocalBefore(String filePath, String fileName, String localPath_1, String localPath_2)
			throws NoHeadException, GitAPIException, IOException;

	List<RevCommit> logAll(String localPath) throws NoHeadException, GitAPIException, IOException;

	void difference(String localPath, String s1, String newHash, String fileName) throws IOException, GitAPIException;

	String readFileFromRevCommit(String localPath, String fileName, String oldHash) throws IOException;
	
	String generate(Theme branchChild, Theme branchParent) throws Exception;
	
	Hashtable<String, JiraLabel> getJiraLabels();

	List<JiraLabel> getLabels() ;
	void getListAllJiraExclu() ;

}
