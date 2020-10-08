package com.czareg;

import com.czareg.service.global.CimConnectionRefreshService;
import com.czareg.service.global.EventPollingService;
import com.czareg.service.handler.ServiceHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Main {
    private ServiceHandler serviceHandler;

    @PostConstruct
    public void start() {
        serviceHandler = new ServiceHandler();
        serviceHandler.addService(new CimConnectionRefreshService("main"));
        serviceHandler.addService(new EventPollingService("main"));
        serviceHandler.start();
    }

    @PreDestroy
    public void stop() {
        serviceHandler.stop();
    }
}
