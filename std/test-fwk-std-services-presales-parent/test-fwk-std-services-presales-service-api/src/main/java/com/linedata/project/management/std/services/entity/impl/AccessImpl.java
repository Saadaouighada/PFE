package com.linedata.project.management.std.services.entity.impl;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Access;
import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.User;

/**
 * The Class AccessImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Access")
public class AccessImpl implements Access {

	/** The login. */
	private String login;
	
	/** The pass. */
	private String pass;
	
	/** The repo. */
	private Repository repo;
	
	/** The u. */
	private User u;
	
	private static final String BEAN_FACTORY_ID = "AccessFactory";
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Repository getRepo() {
		return repo;
	}

	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}
	
	
}
