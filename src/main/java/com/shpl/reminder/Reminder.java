package com.shpl.reminder;

import com.uber.cadence.workflow.WorkflowMethod;

public interface Reminder {

    @WorkflowMethod
    void remind();
}
