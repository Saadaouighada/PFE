package com.linedata.project.management.std.services.entity;

import util.Entity;

/**
 * The Interface User.
 *
 * @author THouissa
 */
public interface User extends Entity{

	String BEANID = "User";
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name);
}
