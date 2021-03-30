package com.shpl.reminder;

import com.uber.cadence.client.WorkflowClient;

public class Executor {
    public static void main(String[] args) {
        WorkflowClient workflowClient = WorkflowClient.newInstance(Constant.DOMAIN);
        // Get a workflow stub using the same task list the worker uses.
        ReminderWorkflow workflow = workflowClient.newWorkflowStub(ReminderWorkflow.class);
        // Execute a workflow waiting for it to complete.
        workflow.remind();
        System.exit(0);
    }
}
