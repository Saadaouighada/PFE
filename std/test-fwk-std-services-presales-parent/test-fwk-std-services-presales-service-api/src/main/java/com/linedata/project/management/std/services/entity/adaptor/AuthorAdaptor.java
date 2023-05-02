package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Author;
import com.linedata.project.management.std.services.entity.impl.AuthorImpl;

/**
 * The Class AuthorAdaptor.
 *
 * @author THouissa
 */
public class AuthorAdaptor extends XmlAdapter<AuthorImpl, Author> {

	@Override
	public Author unmarshal(AuthorImpl v) throws Exception {
		if (v instanceof AuthorImpl) {
			return (AuthorImpl) v;
		}
		return null;
	}

	@Override
	public AuthorImpl marshal(Author v) throws Exception {
		return (AuthorImpl) v;
	}



}
