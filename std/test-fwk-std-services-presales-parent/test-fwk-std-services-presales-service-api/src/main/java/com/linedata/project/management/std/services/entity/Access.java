package com.linedata.project.management.std.services.entity;

import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.User;

import util.Entity;

/**
 * The Interface Access.
 *
 * @author THouissa
 */
public interface Access extends Entity{

	String BEANID = "Access";
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin();

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login);

	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	public String getPass();

	/**
	 * Sets the pass.
	 *
	 * @param pass the new pass
	 */
	public void setPass(String pass);

	/**
	 * Gets the repo.
	 *
	 * @return the repo
	 */
	public Repository getRepo();

	/**
	 * Sets the repo.
	 *
	 * @param repo the new repo
	 */
	public void setRepo(Repository repo);

	/**
	 * Gets the u.
	 *
	 * @return the u
	 */
	public User getU();

	/**
	 * Sets the u.
	 *
	 * @param u the new u
	 */
	public void setU(User u);
}
