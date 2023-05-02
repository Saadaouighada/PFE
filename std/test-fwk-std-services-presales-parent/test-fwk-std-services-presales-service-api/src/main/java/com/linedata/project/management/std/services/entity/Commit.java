package com.linedata.project.management.std.services.entity;

import java.util.Date;
import java.util.List;

import com.linedata.project.management.std.services.entity.File;

import util.Entity;

/**
 * The Interface Commit.
 *
 * @author THouissa
 */
public interface Commit extends Entity{

	
	String BEANID = "Commit";
	/**
	 * Gets the ctxt.
	 *
	 * @return the ctxt
	 */
	public String getCtxt();

	/**
	 * Sets the ctxt.
	 *
	 * @param ctxt the new ctxt
	 */
	public void setCtxt(String ctxt);

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<File> getList();

	/**
	 * Sets the list.
	 *
	 * @param list the new list
	 */
	public void setList(List<File> list);
	
	/**
	 * Gets the Commit name.
	 *
	 * @return the Commit name
	 */
	public String getCommitName() ;

	/**
	 * Sets the Commit name.
	 *
	 * @param CommitName the new Commit name
	 */
	public void setCommitName(String CommitName) ;


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
	
	Date getDate();
	
	void setDate(Date date);
}
