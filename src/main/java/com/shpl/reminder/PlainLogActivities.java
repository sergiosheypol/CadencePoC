package com.shpl.reminder;

import com.uber.cadence.activity.Activity;
import com.uber.cadence.activity.ActivityTask;
import com.uber.cadence.workflow.Workflow;
import org.slf4j.Logger;

public class PlainLogActivities implements LogActivities {

    private final static Logger LOGGER = Workflow.getLogger(PlainLogActivities.class);

    @Override
    public void init() {
        LOGGER.info("Starting reminds {0}");
    }

    @Override
    public void run(int nLog) {
        ActivityTask activityTask = Activity.getTask();
        LOGGER.info("Reminder {} || {}", nLog, activityTask.getActivityId());
    }
}
