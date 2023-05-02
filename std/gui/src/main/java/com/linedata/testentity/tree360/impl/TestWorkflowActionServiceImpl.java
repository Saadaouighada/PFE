package com.linedata.testentity.tree360.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.std.services.core.tree360.EntityReferenceDescriptor;
import com.linedata.ekip.std.services.core.tree360.service.EntityReferenceDescriptorConverter;
import com.linedata.ekip.std.services.core.workflow.entity.WorkflowActionReference;
import com.linedata.ekip.std.services.core.workflow.menu.MenuDescription;
import com.linedata.ekip.std.services.core.workflow.response.WorkflowActionResponse;
import com.linedata.ekip.std.services.core.workflow.service.WorkflowActionService;
import com.linedata.testentity.tree360.TestReference;

public class TestWorkflowActionServiceImpl implements WorkflowActionService
{

   private static final String                BEANID = "TestWorkflowActionServiceImpl";

   @Autowired
   private EntityReferenceDescriptorConverter entityReferenceDescriptorConverter;

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public List<WorkflowActionReference> computeWorkflowActions(ActionContext actionContext, List<EntityReferenceDescriptor> entityReferenceDescriptors)
   {
      List<WorkflowActionReference> workflowActionReferences = new ArrayList<WorkflowActionReference>();

      TestReference testReference = new TestReferenceImpl();
      testReference.setInternalId("1");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("2");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("3");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("4");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("5");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("6");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("7");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("8");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("9");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      testReference = new TestReferenceImpl();
      testReference.setInternalId("10");
      workflowActionReferences.add((WorkflowActionReference) testReference);
      return workflowActionReferences;
   }

   @Override
   public WorkflowActionResponse callWorkflowAction(ActionContext actionContext, WorkflowActionReference workflowActionReference)
   {
      return null;
   }

   @Override
   public MenuDescription computeWorkflowMenuDescription(ActionContext actionContext, List<EntityReferenceDescriptor> entityReferences,
            List<WorkflowActionReference> workflowActionReferenceList)
   {
      MenuDescription mainMenu = new MenuDescription();
      List<MenuDescription> mainMenuChildren = mainMenu.getChildren();
      mainMenuChildren.add(new MenuDescription("label 1"));
      List<MenuDescription> menu1 = mainMenu.getChildren().get(0).getChildren();
      menu1.add(new MenuDescription("label 2"));
      menu1.add(new MenuDescription("label 10"));
      menu1.add(new MenuDescription("label 3"));
      List<MenuDescription> sousMenu1 = menu1.get(0).getChildren();
      sousMenu1.add(new MenuDescription("label 4"));
      sousMenu1.add(new MenuDescription("label 5"));
      List<MenuDescription> sousMenu2 = menu1.get(2).getChildren();
      sousMenu2.add(new MenuDescription("label 7"));
      mainMenuChildren.add(new MenuDescription("label 9"));
      mainMenuChildren.add(new MenuDescription("label 6"));
      List<MenuDescription> menu3 = mainMenu.getChildren().get(2).getChildren();
      menu3.add(new MenuDescription("label 8"));
      return mainMenu;
   }

}
