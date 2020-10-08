package com.czareg.service.handler;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ServiceHandler {
    private List<Service> services;
    private ServiceManager manager;

    public ServiceHandler() {
        services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void start() {
        manager = new ServiceManager(services);
        /*manager.addListener(new ServiceManager.Listener() {
                                public void stopped() {
                                    //System.out.println("Stopped");
                                }

                                public void healthy() {
                                    //System.out.println("Healthy");
                                    // Services have been initialized and are healthy, start accepting requests...
                                }

                                public void failure(Service service) {
                                    //System.out.println("Failure");
                                }
                            },
                MoreExecutors.directExecutor());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Give the services 5 seconds to stop to ensure that we are responsive to shutdown
            // requests.
            try {
                manager.stopAsync().awaitStopped(5, TimeUnit.SECONDS);
            } catch (TimeoutException timeout) {
                // stopping timed out
            }
        }));
*/
        manager.startAsync();  // start all the services asynchronously
        try {
            manager.awaitHealthy(Duration.ofSeconds(5));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("Started");
    }

    public void stop() {
        manager.stopAsync();
        try {
            manager.awaitStopped(Duration.ofSeconds(5));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("Stopped");
    }
}
