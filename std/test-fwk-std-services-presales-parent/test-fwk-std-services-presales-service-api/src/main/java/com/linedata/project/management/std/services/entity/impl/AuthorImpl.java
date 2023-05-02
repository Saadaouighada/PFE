package com.linedata.project.management.std.services.entity.impl;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Author;
import com.linedata.project.management.std.services.entity.User;

/**
 * The Class AuthorImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Author")
public class AuthorImpl extends UserImpl implements Author, User {
	private static final String BEAN_FACTORY_ID = "AuthorFactory";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

}
