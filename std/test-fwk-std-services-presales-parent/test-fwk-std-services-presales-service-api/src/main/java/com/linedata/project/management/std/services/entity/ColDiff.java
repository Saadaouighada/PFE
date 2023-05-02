package com.linedata.project.management.std.services.entity;

import util.Entity;

public interface ColDiff extends Entity {
	
	String BEANID = "ColDiff";
	
	public String getS1();

	public void setS1(String s1);

	public String getS2();

	public void setS2(String s2);

}
