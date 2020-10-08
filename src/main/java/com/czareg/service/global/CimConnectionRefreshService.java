package com.czareg.service.global;

import com.google.common.util.concurrent.AbstractScheduledService;

import java.time.Duration;

public class CimConnectionRefreshService extends AbstractScheduledService {
    private String url;

    public CimConnectionRefreshService(String url) {
        this.url = url;
    }
    @Override
    protected void startUp() throws Exception {
        System.out.println(url + " CimConnectionRefreshService Started");
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println(url + " CimConnectionRefreshService Stopped");
    }

    @Override
    protected void runOneIteration() throws Exception {
        System.out.println(url + " CimConnectionRefreshService runOneIteration");
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedDelaySchedule(Duration.ZERO, Duration.ofSeconds(10));
    }
}
