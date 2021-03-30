package com.shpl.reminder;

import com.uber.cadence.worker.Worker;

public class Runner {
    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory(Constant.DOMAIN);
        Worker worker = factory.newWorker(Constant.TASK_LIST);
        worker.registerWorkflowImplementationTypes(PlainReminderWorkflow.class);
        worker.registerActivitiesImplementations(new PlainLogActivities());
        factory.start();
    }
}
