package com.linedata.project.management.std.services.serviceapi;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public interface MavenCompilerService {

	public void cleanProject(String projectLocation, PrintStream ps, PrintStream psErr)
			throws UnsupportedEncodingException;

	public void cleanInstallProjectSkipTest(String projectLocation, PrintStream ps, PrintStream psErr)
			throws UnsupportedEncodingException;

	public void eclipseCleanProject(String projectLocation, PrintStream ps, PrintStream psErr);

	public void eclipseEclipseProject(String projectLocation, PrintStream ps, PrintStream psErr);

	public void gwtRunProject(String projectLocation);

	public void gwtDebugProject(String projectLocation);

	public String runCommand(String projectLocation, String cmd) throws IOException;

	public void ValidateCompileAndTest(String projectLocation, PrintStream ps, PrintStream psErr);

	public String cmdCleanInstallProject(String path, String cmd) throws IOException;
}