package com.linedata.project.management.std.services.entity;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.linedata.project.management.std.services.entity.adaptor.RepositoryAdaptor;
import com.linedata.project.management.std.services.entity.impl.RepositoryImpl;

import util.Entity;
import util.RepositoryType;

/**
 * The Interface Repository.
 *
 * @author THouissa
 */
@XmlSeeAlso(RepositoryImpl.class)
@XmlJavaTypeAdapter(RepositoryAdaptor.class)
public interface Repository extends Entity {
	
	String BEANID = "Repository";

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl();

	/**
	 * Sets the url.
	 *
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url);

	/**
	 * Gets the branches.
	 *
	 * @return the branches
	 */
	public Branch getBranches();

	/**
	 * Sets the branches.
	 *
	 * @param branches
	 *            the new branches
	 */
	public void setBranches(Branch branches);

	/**
	 * Gets the repository type.
	 *
	 * @return the repository type
	 */
	public RepositoryType getRepositoryType();

	/**
	 * Sets the repository type.
	 *
	 * @param repositoryType
	 *            the new repository type
	 */
	public void setRepositoryType(RepositoryType repositoryType);

	/**
	 * Gets the local url.
	 *
	 * @return the local url
	 */
	public String getLocalURL();

	/**
	 * Sets the local url.
	 *
	 * @param localURL
	 *            the new local url
	 */
	public void setLocalURL(String localURL);


	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public Tags getTags();

	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(Tags tags);
	
	

}
