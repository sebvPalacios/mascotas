package com.example.mascotas.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.mascotas.model.Envio;
import com.example.mascotas.service.EnvioServiceImpl;

@WebMvcTest(EnvioController.class)
public class EnvioControllerTest {

     @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvioServiceImpl envioServicioMock;

    @Test
    public void obtenerTodosTest() throws Exception {
        // Arrange
        // Creación de HoraMedica
        Envio envio1 = new Envio();
        envio1.setNombreProducto("Shampoo Canino");


        Envio envio2 = new Envio();
        envio2.setNombreProducto("Juguetes Caninos");


        List<Envio> envio = Arrays.asList(envio1, envio2);
        when(envioServicioMock.getAllEnvios()).thenReturn(envio);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/envios"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.envioList[0].nombreProducto", Matchers.is("Shampoo Canino")))
            .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.envioList[1].nombreProducto", Matchers.is("Juguetes Caninos")));
    }
}
