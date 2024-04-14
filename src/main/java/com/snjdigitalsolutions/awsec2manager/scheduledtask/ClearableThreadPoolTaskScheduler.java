package com.snjdigitalsolutions.awsec2manager.scheduledtask;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class ClearableThreadPoolTaskScheduler extends ThreadPoolTaskScheduler {

    private final List<ScheduledFuture<?>> scheduledTasks;

    public ClearableThreadPoolTaskScheduler()
    {
        this.scheduledTasks = new ArrayList<>();
    }

    public void schedule(Runnable task, CronTrigger trigger)
    {
        scheduledTasks.add(super.schedule(task,trigger));
    }

    public void clearTasks()
    {
        for (ScheduledFuture<?> scheduledTask : scheduledTasks)
        {
            scheduledTask.cancel(false);
        }
    }

}
