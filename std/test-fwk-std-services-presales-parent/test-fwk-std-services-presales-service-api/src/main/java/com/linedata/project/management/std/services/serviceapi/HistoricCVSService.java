package com.linedata.project.management.std.services.serviceapi;

import java.io.IOException;
import java.util.List;

import org.netbeans.lib.cvsclient.command.CommandException;
import org.netbeans.lib.cvsclient.command.log.LogInformation.Revision;
import org.netbeans.lib.cvsclient.connection.AuthenticationException;

public interface HistoricCVSService {

	public void extractHistory(String host, String user, String cvsUrl, String pass, String cvsURL, String localPath,
			String s) throws AuthenticationException, IOException, CommandException;

	public List<Revision> check(String cvsRoot, String pass, String cvsURL, String localPath, String fileName,
			String project);

}
