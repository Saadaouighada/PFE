package com.linedata.project.management.std.services.entity;

import util.ComparableEntity;

/**
 * The Interface Tags.
 *
 * @author THouissa
 */
public interface Tags extends ComparableEntity<Tags> {
	
	String BEANID = "Tags";

	/**
	 * Gets the commit.
	 *
	 * @return the commit
	 */
	public Commit getCommit();

	/**
	 * Sets the commit.
	 *
	 * @param comit the new commit
	 */
	public void setCommit(Commit commit);
	
	/**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
	public String getTagName() ;
	
	/**
	 * Sets the tag name.
	 *
	 * @param tagName the new tag name
	 */
	public void setTagName(String tagName) ;
}
