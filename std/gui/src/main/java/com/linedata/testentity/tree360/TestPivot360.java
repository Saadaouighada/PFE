package com.linedata.testentity.tree360;

import com.linedata.ekip.std.services.core.tree360.Pivot360;

public class TestPivot360 extends Pivot360<TestReference> {

	private static final String BEANID = "TestPivot360";
	
	@Override
	public String getBeanId() {
		return BEANID;
	}

	@Override
	public Class<TestReference> getTargetClass() {
		return TestReference.class;
	}

	@Override
	public Object getPrimaryKey(TestReference testReference) {
		return testReference.getInternalId();
	}

}
