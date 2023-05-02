package com.linedata.project.management.std.services.entity.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Author;
import com.linedata.project.management.std.services.entity.File;
import com.linedata.project.management.std.services.entity.Folder;

/**
 * The Class FolderImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Folder")
public class FolderImpl implements Folder {

	/** The file name. */
	private String fileName;

	/** The size. */
	private int size;
	
	/** The children. */
	private List<File> children;

	/** The author. */
	private Author author;

	/** The Constant BEAN_FACTORY_ID. */
	private static final String BEAN_FACTORY_ID = "FolderFactory";

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<File> getChildren() {
		return children;
	}

	public void setChildren(List<File> children) {
		this.children = children;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + size;
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
		FolderImpl other = (FolderImpl) obj;
		if (other.hashCode() != this.hashCode()) {
			return false;
		}
		return true;
	}

	

	
}
