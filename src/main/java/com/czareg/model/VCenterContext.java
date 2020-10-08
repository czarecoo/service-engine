package com.czareg.model;

import com.czareg.service.contexted.HealthUpdateService;
import com.czareg.service.contexted.NodeCimService;
import com.czareg.service.handler.ServiceHandler;

public class VCenterContext {
    private final ServiceHandler serviceHandler;
    private String url;

    public VCenterContext(String url) {
        this.url = url;
        this.serviceHandler = new ServiceHandler();
    }

    public void start() {
        serviceHandler.addService(new HealthUpdateService(url));
        serviceHandler.addService(new NodeCimService(url));
        serviceHandler.start();
    }

    public void stop() {
        serviceHandler.stop();
    }
}
