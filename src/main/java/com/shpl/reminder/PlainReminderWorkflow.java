package com.shpl.reminder;

import com.uber.cadence.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class PlainReminderWorkflow implements ReminderWorkflow {

    private final static Logger LOGGER = Workflow.getLogger(PlainReminderWorkflow.class);

    private final LogActivities activities;
    private int nReminds;
    private boolean execute;

    public PlainReminderWorkflow() {
        this.activities = Workflow.newActivityStub(LogActivities.class);
        this.nReminds = 0;
        this.execute = true;
    }

    @Override
    public void remind() {
        LOGGER.info(activities.init());
        LOGGER.info("Workflow id {{}}", Workflow.getWorkflowInfo().getWorkflowId());
        while (nReminds < 20 && execute) {
            Workflow.sleep(Duration.ofSeconds(5));
            nReminds++;
            LOGGER.info(activities.run(nReminds));
        }
    }

    @Override
    public void kill() {
        LOGGER.info("Stopping...");
        execute = false;
    }

    @Override
    public String getCounter() {
       return String.format("Reminder {%s}", nReminds);
    }
}
