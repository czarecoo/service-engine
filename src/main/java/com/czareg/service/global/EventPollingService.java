package com.czareg.service.global;

import com.google.common.util.concurrent.AbstractScheduledService;

import java.time.Duration;

public class EventPollingService extends AbstractScheduledService {
    private String url;

    public EventPollingService(String url) {
        this.url = url;
    }
    @Override
    protected void startUp() throws Exception {
        System.out.println(url + " EventPollingService Started");
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println(url + " EventPollingService Stopped");
    }

    @Override
    protected void runOneIteration() throws Exception {
        System.out.println(url + " EventPollingService runOneIteration");
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedDelaySchedule(Duration.ZERO, Duration.ofSeconds(10));
    }
}
