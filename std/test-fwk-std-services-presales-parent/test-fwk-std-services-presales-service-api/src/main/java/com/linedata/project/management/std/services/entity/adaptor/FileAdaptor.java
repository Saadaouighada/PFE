package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.File;
import com.linedata.project.management.std.services.entity.impl.FileImpl;

public class FileAdaptor extends XmlAdapter<FileImpl, File> {

	@Override
	public File unmarshal(FileImpl v) throws Exception {
		if (v instanceof FileImpl) {
			return (FileImpl) v;
		}
		return null;
	}

	@Override
	public FileImpl marshal(File v) throws Exception {
		return (FileImpl) v;
	}


}
