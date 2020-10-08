package com.czareg.service.contexted;

import com.google.common.util.concurrent.AbstractScheduledService;

import java.time.Duration;

public class NodeCimService extends AbstractScheduledService {
    private String url;

    public NodeCimService(String url) {
        this.url = url;
    }
    @Override
    protected void startUp() throws Exception {
        System.out.println(url + " NodeCimService Started");
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println(url + " NodeCimService Stopped");
    }

    @Override
    protected void runOneIteration() throws Exception {
        System.out.println(url + " NodeCimService runOneIteration");
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedDelaySchedule(Duration.ZERO, Duration.ofSeconds(5));
    }
}
