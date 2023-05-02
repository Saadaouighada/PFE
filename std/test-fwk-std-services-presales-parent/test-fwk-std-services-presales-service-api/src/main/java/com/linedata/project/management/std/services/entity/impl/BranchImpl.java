package com.linedata.project.management.std.services.entity.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.Branch;
import com.linedata.project.management.std.services.entity.Commit;

/**
 * The Class BranchImpl.
 *
 * @author THouissa
 */
@XmlType(name = "Branch")
public class BranchImpl implements Branch {
	
	/** The branch name. */
	private String branchName ;
	
	/** The Commit. */
	private List<Commit> Commit;
	
	private static final String BEAN_FACTORY_ID = "AuthorFactory";

	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public List<Commit> getCommit() {
		return Commit;
	}
	public void setCommit(List<Commit> Commit) {
		this.Commit = Commit;
	}
	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}
	
	

}
