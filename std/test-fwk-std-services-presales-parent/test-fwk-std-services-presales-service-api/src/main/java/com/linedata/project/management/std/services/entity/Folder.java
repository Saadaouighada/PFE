package com.linedata.project.management.std.services.entity;

import java.util.List;

import com.linedata.project.management.std.services.entity.Author;

import util.ComparableEntity;

/**
 * The Interface File.
 *
 * @author THouissa
 */
public interface Folder extends ComparableEntity<Folder> {

	String BEANID = "Folder";
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
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() ;

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size);

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List<File> getChildren();

	/**
	 * Sets the children.
	 *
	 * @param children the new children
	 */
	public void setChildren(List<File> children);
	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public Author getAuthor() ;

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(Author author) ;

}
