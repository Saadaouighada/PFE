package com.linedata.project.management.std.services.entity.impl;

import javax.xml.bind.annotation.XmlType;

import com.linedata.project.management.std.services.entity.ColDiff;

@XmlType(name = "ColDiff")
public class ColDiffImpl implements ColDiff {

	private String s1;
	private String s2;
	
	private static final String BEAN_FACTORY_ID = "AuthorFactory";


	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	@Override
	public String getFactoryBeanId() {
		return BEAN_FACTORY_ID;
	}

}
