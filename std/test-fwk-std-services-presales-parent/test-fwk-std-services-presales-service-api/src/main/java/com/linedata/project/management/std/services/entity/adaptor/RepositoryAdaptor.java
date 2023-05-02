package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Repository;
import com.linedata.project.management.std.services.entity.impl.RepositoryImpl;

/**
 * The Class RepositoryAdaptor.
 *
 * @author THouissa
 */
public class RepositoryAdaptor extends XmlAdapter<RepositoryImpl, Repository> {

	@Override
	public Repository unmarshal(RepositoryImpl v) throws Exception {
		if (v instanceof RepositoryImpl) {
			return (RepositoryImpl) v;
		}
		return null;
	}

	@Override
	public RepositoryImpl marshal(Repository v) throws Exception {
		return (RepositoryImpl) v;
	}

}
