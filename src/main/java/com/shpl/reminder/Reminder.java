package com.shpl.reminder;

import com.uber.cadence.workflow.WorkflowMethod;

public interface Reminder {

    @WorkflowMethod(taskList = "ReminderTaskList")
    void remind();
}
