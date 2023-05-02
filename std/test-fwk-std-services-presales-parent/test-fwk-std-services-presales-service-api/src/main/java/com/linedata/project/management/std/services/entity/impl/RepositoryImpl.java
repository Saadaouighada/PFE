package com.linedata.project.management.std.services.entity.impl;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Branch;
import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.Tags;

import util.RepositoryType;

/**
 * The Class RepositoryImpl.
 *
 * @author THouissa
 */

@XmlType(name = "Repository")
public class RepositoryImpl implements Repository {

	/** The url. */
	private String url;

	/** The branches. */
	private Branch branches;

	/** The repository type. */
	private RepositoryType repositoryType;

	/** The local url. */
	private String localURL;

	/** The tags. */
	private Tags tags;

	private static final String BEAN_FACTORY_ID = "RepositoryFactory";

	@PostConstruct
	public void initRepo() {

	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Branch getBranches() {
		return branches;
	}

	public void setBranches(Branch branches) {
		this.branches = branches;
	}

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

	public RepositoryType getRepositoryType() {
		return repositoryType;
	}

	public void setRepositoryType(RepositoryType repositoryType) {
		this.repositoryType = repositoryType;
	}

	public String getLocalURL() {
		return localURL;
	}

	public void setLocalURL(String localURL) {
		this.localURL = localURL;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

}
