package com.shpl.reminder;

import com.uber.cadence.client.WorkflowClient;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        WorkflowClient workflowClient = WorkflowClient.newInstance(Constant.DOMAIN);
        // Get a workflow stub using the same task list the worker uses.
        ReminderWorkflow workflow = workflowClient.newWorkflowStub(ReminderWorkflow.class);
        // Execute a workflow waiting for it to complete.

        // Async start so it's the same Thread
        WorkflowClient.start(workflow::remind);

        Thread.sleep(15000);
        System.out.println(workflow.getCounter());

        Thread.sleep(40000);
        workflow.kill();

        System.exit(0);
    }
}
