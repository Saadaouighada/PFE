package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Commit;
import com.linedata.project.management.std.services.entity.impl.CommitImpl;

/**
 * The Class CommitAdaptor.
 *
 * @author THouissa
 */
public class CommitAdaptor extends XmlAdapter<CommitImpl,Commit>
{

	@Override
	public Commit unmarshal(CommitImpl v) throws Exception {
		if (v instanceof CommitImpl) {
			return (CommitImpl) v;
		}
		return null;
	}

	@Override
	public CommitImpl marshal(Commit v) throws Exception {
		return (CommitImpl) v;
	}
}
