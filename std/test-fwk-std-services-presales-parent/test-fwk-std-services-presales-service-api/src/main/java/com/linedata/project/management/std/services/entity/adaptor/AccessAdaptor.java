package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Access;
import com.linedata.project.management.std.services.entity.impl.AccessImpl;

/**
 * The Class AccessAdaptor.
 *
 * @author THouissa
 */
public class AccessAdaptor extends XmlAdapter<AccessImpl, Access> {

	@Override
	public Access unmarshal(AccessImpl v) throws Exception {
		if (v instanceof AccessImpl) {
			return (AccessImpl) v;
		}
		return null;
	}

	@Override
	public AccessImpl marshal(Access v) throws Exception {
		return (AccessImpl) v;
	}

}
