package com.czareg.controller;

import com.czareg.model.VCenterContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class VCenterController {
    Map<String, VCenterContext> vCenters = new HashMap<>();

    @PostMapping
    public void addVCenter(@RequestParam(value = "url") String url) {
        VCenterContext vCenterContext = new VCenterContext(url);
        vCenterContext.start();
        vCenters.put(url, vCenterContext);
    }

    @DeleteMapping
    public void deleteVCenter(@RequestParam(value = "url") String url) {
        Optional.ofNullable(vCenters.get(url))
                .ifPresent(VCenterContext::stop);
    }
}
