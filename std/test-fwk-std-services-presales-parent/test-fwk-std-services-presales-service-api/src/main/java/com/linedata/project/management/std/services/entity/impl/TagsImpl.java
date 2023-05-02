package com.linedata.project.management.std.services.entity.impl;

import com.linedata.project.management.std.services.entity.Tags;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Commit;

/**
 * The Class TagsImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Tags")
public class TagsImpl implements Tags {
	
	/** The tag name. */
	private String tagName;
	
	/** The commit. */
	private Commit commit ;
	
	/** The Constant BEAN_FACTORY_ID. */
	private static final String BEAN_FACTORY_ID = "TagsFactory";

	/**
	 * Gets the commit.
	 *
	 * @return the commit
	 */
	public Commit getCommit() {
		return commit;
	}

	/**
	 * Sets the commit.
	 *
	 * @param comit the new commit
	 */
	public void setCommit(Commit commit) {
		this.commit = commit;
	}
	
	

	/**
	 * Gets the factory bean id.
	 *
	 * @return the factory bean id
	 */
	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

	/**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Sets the tag name.
	 *
	 * @param tagName the new tag name
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


}
