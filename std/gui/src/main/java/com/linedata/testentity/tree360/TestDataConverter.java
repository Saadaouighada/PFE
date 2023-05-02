package com.linedata.testentity.tree360;

import org.springframework.stereotype.Component;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.core.server.entityconverter.EntityDataConverter;
import com.linedata.ekip.testfwkgui.shared.TestData;
import com.linedata.testentity.tree360.impl.TestReferenceImpl;

@Component
public class TestDataConverter extends EntityDataConverter<TestReference, TestData> {

	private static final String BEANID = "TestDataConverter";
	
	@Override
	public String getBeanId() {
		return BEANID;
	}

	@Override
	public Class<TestReference> getEntityReferenceClass() {
		return TestReference.class;
	}

	@Override
	public Class<TestData> getEntityDataClass() {
		return TestData.class;
	}

	@Override
	public TestReference getEntityReference(TestData testData) {
		TestReference testReference = new TestReferenceImpl();
		testReference.setInternalId((String)testData.get("id"));
		return testReference;
	}

	@Override
	public TestData getEntityData(ActionContext actionContext, TestReference testReference) {
		TestData testData = new TestData();
		testData.set("id", testReference.getInternalId());
		testData.set("label", "label de " + testReference.getInternalId());
		testData.set("description", "description de " + testReference.getInternalId());
		return testData;
	}

}
