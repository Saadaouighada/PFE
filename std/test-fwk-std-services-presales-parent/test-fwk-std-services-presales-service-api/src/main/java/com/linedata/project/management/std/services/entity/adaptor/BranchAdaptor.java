package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Branch;
import com.linedata.project.management.std.services.entity.impl.BranchImpl;

/**
 * The Class BranchAdaptor.
 *
 * @author THouissa
 */
public class BranchAdaptor extends XmlAdapter<BranchImpl, Branch> {

	@Override
	public Branch unmarshal(BranchImpl v) throws Exception {
		if (v instanceof BranchImpl) {
			return (BranchImpl) v;
		}
		return null;
	}

	@Override
	public BranchImpl marshal(Branch v) throws Exception {
		return (BranchImpl) v;
	}
}
