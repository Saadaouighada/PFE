package com.linedata.project.management.std.services.entity.impl;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.File;

/**
 * The Class FileImpl.
 *
 * @author THouissa
 */
@XmlType(name = "File")
public class FileImpl implements File {

	/** The file name. */
	private String fileName;

	

	/** The parent name. */
	private String pathName;

	
	
	
	private static final String BEAN_FACTORY_ID = "FileFactory";

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String parentName) {
		this.pathName = parentName;
	}

	

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

	// genere un code unique selon l'auteur le nom de fichier et le nom de
	// parent
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((pathName == null) ? 0 : pathName.hashCode());
		//result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileImpl other = (FileImpl) obj;
		if (other.hashCode() != this.hashCode()) {
			return false;
		}
		// TODO if this condition is not consistent add a block that compare file contents 
		return true;
	}

}
