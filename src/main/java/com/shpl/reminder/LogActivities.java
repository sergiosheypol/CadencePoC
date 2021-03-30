package com.shpl.reminder;

import com.uber.cadence.activity.ActivityMethod;

public interface LogActivities {
    @ActivityMethod(scheduleToStartTimeoutSeconds = 1, startToCloseTimeoutSeconds = 30)
    void init();

    @ActivityMethod(scheduleToStartTimeoutSeconds = 1, startToCloseTimeoutSeconds = 30)
    void run(int nLog);
}
