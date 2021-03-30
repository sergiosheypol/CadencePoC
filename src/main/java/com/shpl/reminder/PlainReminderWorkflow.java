package com.shpl.reminder;

import com.uber.cadence.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class PlainReminderWorkflow implements ReminderWorkflow {

    private final static Logger LOGGER = Workflow.getLogger(PlainReminderWorkflow.class);

    private final LogActivities activities;
    private int nReminds;

    public PlainReminderWorkflow() {
        this.activities = Workflow.newActivityStub(LogActivities.class);
        this.nReminds = 0;
    }

    @Override
    public void remind() {
        LOGGER.info(activities.init());
        while (nReminds < 20) {
            Workflow.sleep(Duration.ofMillis(50));
            nReminds++;
            LOGGER.info(activities.run(nReminds));
        }
    }
}
