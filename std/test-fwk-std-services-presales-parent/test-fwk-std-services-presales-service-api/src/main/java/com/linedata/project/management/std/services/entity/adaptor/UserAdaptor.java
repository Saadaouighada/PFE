package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.User;
import com.linedata.project.management.std.services.entity.impl.UserImpl;

/**
 * The Class UserAdaptor.
 *
 * @author THouissa
 */
public class UserAdaptor extends XmlAdapter<UserImpl, User>{
	
	@Override
	public User unmarshal(UserImpl v) throws Exception {
		if (v instanceof UserImpl) {
			return (UserImpl) v;
		}
		return null;
	}

	@Override
	public UserImpl marshal(User v) throws Exception {
		return (UserImpl) v;
	}


}
