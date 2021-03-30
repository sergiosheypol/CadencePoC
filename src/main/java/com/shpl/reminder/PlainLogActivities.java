package com.shpl.reminder;

import com.uber.cadence.activity.Activity;

public class PlainLogActivities implements LogActivities {

    @Override
    public String run(int nLog) {
        return String.format("Reminder {%s} || Activity ID {%s}", nLog, Activity.getTask().getActivityId());
    }
}
