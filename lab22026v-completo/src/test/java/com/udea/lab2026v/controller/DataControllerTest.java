package com.udea.lab2026v.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Debe responder health check correctamente")
    void healthCheckShouldReturnOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("HEALTH CHECK OK")));
    }

    @Test
    @DisplayName("Debe exponer la versión de la aplicación")
    void versionShouldReturnCurrentVersion() throws Exception {
        mockMvc.perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1.0.0")));
    }

    @Test
    @DisplayName("Debe generar 10 naciones falsas")
    void nationsShouldReturnTenItems() throws Exception {
        mockMvc.perform(get("/nations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    @DisplayName("Debe generar 10 monedas falsas")
    void currenciesShouldReturnTenItems() throws Exception {
        mockMvc.perform(get("/currencies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    @DisplayName("Debe generar 20 registros de aviación")
    void aviationShouldReturnTwentyItems() throws Exception {
        mockMvc.perform(get("/aviation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(20)));
    }
}
