package com.shpl.reminder;

import com.uber.cadence.workflow.WorkflowMethod;

public interface ReminderWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 40, taskList = Constant.TASK_LIST)
    void remind();
}
