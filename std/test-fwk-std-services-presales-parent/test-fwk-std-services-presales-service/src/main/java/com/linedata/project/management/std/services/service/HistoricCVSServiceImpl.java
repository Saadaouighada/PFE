package com.linedata.project.management.std.services.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.netbeans.lib.cvsclient.CVSRoot;
import org.netbeans.lib.cvsclient.Client;
import org.netbeans.lib.cvsclient.admin.StandardAdminHandler;
import org.netbeans.lib.cvsclient.command.Builder;
import org.netbeans.lib.cvsclient.command.CommandAbortedException;
import org.netbeans.lib.cvsclient.command.CommandException;
import org.netbeans.lib.cvsclient.command.GlobalOptions;
import org.netbeans.lib.cvsclient.command.checkout.CheckoutCommand;
import org.netbeans.lib.cvsclient.command.log.LogBuilder;
import org.netbeans.lib.cvsclient.command.log.LogCommand;
import org.netbeans.lib.cvsclient.command.log.LogInformation;
import org.netbeans.lib.cvsclient.command.log.LogInformation.Revision;
import org.netbeans.lib.cvsclient.connection.AuthenticationException;
import org.netbeans.lib.cvsclient.connection.PServerConnection;
import org.netbeans.lib.cvsclient.connection.StandardScrambler;
import org.netbeans.lib.cvsclient.event.CVSAdapter;
import org.netbeans.lib.cvsclient.event.FileInfoEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.linedata.project.management.std.services.serviceapi.HistoricCVSService;

@Service
@Scope("session")
public class HistoricCVSServiceImpl implements HistoricCVSService {
	// Global informations
	public static final String workspace_dir = "C:\\GhadaPFE";
	public static final String report_out_dir = "C:\\GhadaPFE\\reports";
	public static final String date_format = "dd-MM-yyyy";

	public static int nbFiles = 0;

	// excludes
	public static final String[] except_dirs = { "target", "CVS" };

	// cvs connection
	public static PServerConnection connection = null;
	public static Client client = null;
	public static GlobalOptions globalOptions = new GlobalOptions();

	public static File cvsOutputFile = null;

	/**
	 * The Main method
	 * 
	 * @param args
	 *            command args
	 * @throws AuthenticationException
	 * @throws IOException
	 * @throws CommandException
	 */
	public void extractHistory(String host, String user, String cvsRoot, String pass, String cvsURL, String localPath,
			String filePath) throws AuthenticationException, IOException, CommandException {
		// init the cvs connection
		initCVS(host, user, cvsRoot, pass, cvsURL);
		// save the repo in a folder
		cvsOutputFile = new File(filePath);
		if (cvsOutputFile.exists()) {
			getFileCreator(cvsOutputFile);
		}
	}

	public List<Revision> check(String cvsRoot, String pass, String cvsURL, String localPath, final String fileName,
			String project) {
		// Create the Client for connection

		globalOptions = new GlobalOptions();
		globalOptions.setCVSRoot(cvsRoot);
		// connecting to the cvs server
		CVSRoot cvsRootData = CVSRoot.parse(cvsURL);
		// testing the cvsRootData options
		connection = new PServerConnection(cvsRootData);
		connection.setEncodedPassword(StandardScrambler.getInstance().scramble(pass));
		// opening connection with CVS client
		try {
			connection.open();

		} catch (AuthenticationException  e) {
			e.printStackTrace();
		}catch (CommandAbortedException e) {
			e.printStackTrace();
		}

		//final List<Revision> revisionList = new ArrayList<>();

		Client client = new Client(connection, new StandardAdminHandler());
		client.getEventManager().addCVSListener(new CVSAdapter() {
			public void fileInfoGenerated(FileInfoEvent fileinfoevent) {
				// Handle control to Super class.
				super.fileInfoGenerated(fileinfoevent);
				// Get the log information for the current file event.
				LogInformation infoContainer = (LogInformation) fileinfoevent.getInfoContainer();
				if (infoContainer.getFile().getAbsolutePath().equals(fileName)) {
					if (!infoContainer.getRevisionList().isEmpty()) {
						List<Revision> listRev = infoContainer.getRevisionList();
						for (Revision rev : listRev) {
							//revisionList.add(rev);
						}
					}

				}

			}
		});

		/*
		 * this line is important, because otherwise you'll get a
		 * NullpointerException!
		 */
		client.setLocalPath(localPath);
		System.setProperty("javacvs.multiple_commands_warning", "false");
		/* checkout command */
		CheckoutCommand command = new CheckoutCommand();
		command.setBuilder(null);
		command.setModule("reporter");
		command.setPruneDirectories(true);
		command.setUseHeadIfNotFound(true);
		/* test of log command */
		try {

			/* Execution of _CHECKOUT_Command */
			client.executeCommand(command, globalOptions);

			LogCommand logcommand = new LogCommand();
			Builder builderlog = new LogBuilder(client.getEventManager(), logcommand);
			logcommand.setBuilder(builderlog);
			logcommand.setRecursive(false);
			logcommand.setCVSCommand('b', null);

			/* Execution of _LOG_command */
			client.executeCommand(logcommand, globalOptions);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;//revisionList;
	}

	/**
	 * method to initialize the cvs connection
	 * 
	 * @param cvsURL
	 * 
	 * @throws AuthenticationException
	 * @throws CommandAbortedException
	 */
	public static void initCVS(String host, String user, String cvsUrl, String pass, String cvsURL)
			throws CommandAbortedException, AuthenticationException {
		CVSRoot cvsRootData = CVSRoot.parse(cvsURL);
		connection = new PServerConnection(cvsRootData);
		connection.setHostName(host);
		connection.setUserName(user);
		connection.setRepository(cvsUrl);
		connection.setEncodedPassword(StandardScrambler.getInstance().scramble(pass));
		connection.verify();
		connection.open();
	}

	public static void getFileCreator(java.io.File file)
			throws CommandAbortedException, CommandException, AuthenticationException, IOException {
		client = new Client(connection, new StandardAdminHandler());
		client.setLocalPath(file.getAbsolutePath());
		client.getEventManager().addCVSListener(new CVSAdapter());

		LogCommand command = new LogCommand();
		Builder builder = new LogBuilder(client.getEventManager(), command);
		command.setBuilder(builder);
		command.setCVSCommand('h', file.getName());
		client.executeCommand(command, globalOptions);
		connection.close();

	}

}
