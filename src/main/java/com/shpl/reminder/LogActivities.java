package com.shpl.reminder;

import com.uber.cadence.activity.ActivityMethod;

public interface LogActivities {

    @ActivityMethod(scheduleToStartTimeoutSeconds = 1, startToCloseTimeoutSeconds = 1)
    String init();

    @ActivityMethod(scheduleToStartTimeoutSeconds = 1, startToCloseTimeoutSeconds = 100)
    String run(int nLog);
}
