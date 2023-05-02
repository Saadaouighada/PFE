package com.linedata.project.management.std.services.entity;


import util.ComparableEntity;

/**
 * The Interface File.
 *
 * @author THouissa
 */
public interface File extends ComparableEntity<File> {

	
	String BEANID="File";
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	
	
	public String getFileName() ;

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) ;

	
	/**
	 * Gets the parent name.
	 *
	 * @return the parent name
	 */
	public String getPathName() ;

	/**
	 * Sets the parent name.
	 *
	 * @param parentName the new parent name
	 */
	public void setPathName(String pathName) ;

	public int hashCode();
	
	public boolean equals(Object obj);

}
