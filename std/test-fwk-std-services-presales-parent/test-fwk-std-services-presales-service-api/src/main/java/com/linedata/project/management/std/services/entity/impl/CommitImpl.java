package com.linedata.project.management.std.services.entity.impl;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.File;
import com.linedata.project.management.std.services.entity.Author;
import com.linedata.project.management.std.services.entity.Commit;

/**
 * The Class CommitImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Commit")
public class CommitImpl implements Commit {

	/** The ctxt. */
	private String ctxt;
	
	/** The list. */
	private List<File> list;
	
	/** The Commit name. */
	private String CommitName;
	
	/** The author. */
	private Author author;
	
	private Date date;
	
	

	private static final String BEAN_FACTORY_ID = "CommitFactory"; 
	
	public String getCtxt() {
		return ctxt;
	}

	public void setCtxt(String ctxt) {
		this.ctxt = ctxt;
	}

	public List<File> getList() {
		return list;
	}

	public void setList(List<File> list) {
		this.list = list;
	}

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

	public String getCommitName() {
		return CommitName;
	}

	public void setCommitName(String CommitName) {
		this.CommitName = CommitName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	@Override
	public void setDate(Date date) {
		this.date=date;
	}

}
