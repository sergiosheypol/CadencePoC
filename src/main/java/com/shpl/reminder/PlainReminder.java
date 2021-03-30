package com.shpl.reminder;

import com.uber.cadence.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class PlainReminder implements Reminder {

    private final static Logger LOGGER = Workflow.getLogger(PlainReminder.class);

    private int nReminds;

    public PlainReminder() {
        this.nReminds = 0;
    }

    @Override
    public void remind() {
        LOGGER.info("Starting reminds {}", nReminds);
        while (nReminds < 20) {
            Workflow.sleep(Duration.ofSeconds(2));
            nReminds++;
            LOGGER.info("Reminder {}", nReminds);
        }
    }
}
