package com.linedata.project.management.std.services.entity.impl;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.User;

/**
 * The Class UserImpl.
 *
 * @author THouissa
 */
@XmlType(name = "User")
public class UserImpl implements User {

	/** The name. */
	protected String name;

	private static final String BEAN_FACTORY_ID = "UserFactory";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

}
