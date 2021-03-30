package com.shpl.reminder;

import com.uber.cadence.workflow.Workflow;

import java.time.Duration;

public class PlainReminderWorkflow implements ReminderWorkflow {

    private final LogActivities activities;
    private int nReminds;

    public PlainReminderWorkflow() {
        this.activities = Workflow.newActivityStub(LogActivities.class);
        this.nReminds = 0;
    }

    @Override
    public void remind() {
        activities.init();
        while (nReminds < 20) {
            Workflow.sleep(Duration.ofSeconds(2));
            nReminds++;
            activities.run(nReminds);
        }
    }
}
