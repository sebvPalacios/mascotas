package com.example.mascotas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mascotas.model.Envio;
import com.example.mascotas.repository.EnvioRepository;
import com.example.mascotas.service.EnvioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MascotasApplicationTests {

	@InjectMocks
	private EnvioServiceImpl envioServicio;

	@Mock
	private EnvioRepository envioRepositorioMock;

	@Test
	public void guardarEnvioTest(){
		// Arrange
		Envio envio = new Envio();
		envio.setNombreProducto("Shampoo Canino");
		envio.setUbicacion("Santiago");
		envio.setDestino("Maipu");
		envio.setEstadoEnvio("Sin Enviar");

		when(envioRepositorioMock.save(any())).thenReturn(envio);

		// Act
		Envio resultado = envioServicio.crearEnvio(envio);

		// Assert
		assertEquals("Shampoo Canino", resultado.getNombreProducto());

	}

	@Test
	public void guardarEnvioTest2(){
		// Arrange
		Envio envio = new Envio();
		envio.setNombreProducto("Juguetes Caninos");
		envio.setUbicacion("Santiago");
		envio.setDestino("San Bernardo");
		envio.setEstadoEnvio("Sin Enviar");

		when(envioRepositorioMock.save(any())).thenReturn(envio);

		// Act
		Envio resultado = envioServicio.crearEnvio(envio);

		// Assert
		assertEquals("Juguetes Caninos", resultado.getNombreProducto());

	}


}
