package com.udea.lab2026v.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DataService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Faker faker = new Faker(new Locale("en_US"));

    public String healthCheck() {
        return "HEALTH CHECK OK";
    }

    public String version() {
        return "The actual version is 1.0.0";
    }

    public JsonNode getRandomNations() {
        var nations = objectMapper.createArrayNode();

        for (int i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                    .put("nationality", nation.nationality())
                    .put("language", nation.language())
                    .put("capital", nation.capitalCity()));
        }

        return nations;
    }

    public JsonNode getRandomCurrencies() {
        var currencies = objectMapper.createArrayNode();

        for (int i = 0; i < 10; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                    .put("code", currency.code())
                    .put("name", currency.name()));
        }

        return currencies;
    }

    public JsonNode getRandomAviation() {
        var aviations = objectMapper.createArrayNode();

        for (int i = 0; i < 20; i++) {
            var aviation = faker.aviation();
            aviations.add(objectMapper.createObjectNode()
                    .put("aircraft", aviation.aircraft())
                    .put("airport", aviation.airport())
                    .put("METAR", aviation.METAR()));
        }

        return aviations;
    }
}
