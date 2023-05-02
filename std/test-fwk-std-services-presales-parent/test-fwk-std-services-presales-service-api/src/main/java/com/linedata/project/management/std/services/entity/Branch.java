package com.linedata.project.management.std.services.entity;

import java.util.List;

import com.linedata.project.management.std.services.entity.Commit;

import util.Entity;

/**
 * The Interface Branch.
 *
 * @author THouissa
 */
public interface Branch extends Entity {

	String BEANID = "Branch";
	/**
	 * Gets the branch name.
	 *
	 * @return the branch name
	 */
	public String getBranchName() ;
	
	/**
	 * Sets the branch name.
	 *
	 * @param branchName the new branch name
	 */
	public void setBranchName(String branchName) ;
	
	/**
	 * Gets the Commit.
	 *
	 * @return the Commit
	 */
	public List<Commit> getCommit() ;
	
	/**
	 * Sets the Commit.
	 *
	 * @param Commit the new Commit
	 */
	public void setCommit(List<Commit> Commit) ;
	
	
	
}
