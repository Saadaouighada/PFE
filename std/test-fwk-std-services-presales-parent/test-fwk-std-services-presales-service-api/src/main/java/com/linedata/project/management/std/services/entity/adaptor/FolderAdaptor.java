package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Folder;
import com.linedata.project.management.std.services.entity.impl.FolderImpl;

public class FolderAdaptor extends XmlAdapter<FolderImpl, Folder> {

	@Override
	public Folder unmarshal(FolderImpl v) throws Exception {
		if (v instanceof FolderImpl) {
			return (FolderImpl) v;
		}
		return null;
	}

	@Override
	public FolderImpl marshal(Folder v) throws Exception {
		return (FolderImpl) v;
	}


}
