package com.example.mascotas.service;

import com.example.mascotas.model.Envio;

import java.util.List;
import java.util.Optional;

public interface EnvioService {
    List<Envio> getAllEnvios();
    Optional<Envio> getEnvioById(Long id);
    Envio crearEnvio(Envio envio);
    Envio updateEnvio(Long id, Envio envio);
    void eliminarEnvio(Long id);
}
