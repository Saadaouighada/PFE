package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.ColDiff;
import com.linedata.project.management.std.services.entity.impl.ColDiffImpl;

public class ColDiffAdaptor extends XmlAdapter<ColDiffImpl, ColDiff> {

	@Override
	public ColDiff unmarshal(ColDiffImpl v) throws Exception {
		if (v instanceof ColDiffImpl) {
			return (ColDiffImpl) v;
		}
		return null;
	}

	@Override
	public ColDiffImpl marshal(ColDiff v) throws Exception {
		return (ColDiffImpl) v;
	}
}
