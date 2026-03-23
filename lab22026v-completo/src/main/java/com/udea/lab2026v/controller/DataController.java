package com.udea.lab2026v.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.udea.lab2026v.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String healthCheck() {
        return dataService.healthCheck();
    }

    @GetMapping("/version")
    public String version() {
        return dataService.version();
    }

    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        return dataService.getRandomNations();
    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        return dataService.getRandomCurrencies();
    }

    @GetMapping("/aviation")
    public JsonNode getRandomAviation() {
        return dataService.getRandomAviation();
    }
}
