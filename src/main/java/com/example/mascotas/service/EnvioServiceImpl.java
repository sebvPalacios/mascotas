package com.example.mascotas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mascotas.model.Envio;
import com.example.mascotas.repository.EnvioRepository;

@Service
public class EnvioServiceImpl implements EnvioService{
    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public List<Envio> getAllEnvios(){
        return envioRepository.findAll();
    }

    public Optional<Envio> getEnvioById(Long id){
        return envioRepository.findById(id);
    }

    // Crear un Envio
    @Override
    public Envio crearEnvio(Envio envio){
        return envioRepository.save(envio);
    }

    // Modificar un Envio
    @Override
    public Envio updateEnvio(Long id, Envio envio){
        if(envioRepository.existsById(id)){
            envio.setId(id);
            return envioRepository.save(envio);
        }
        else
        {
            return null;
        }
    }

    //Eliminar un envio
    @Override
    public void eliminarEnvio(Long id){
        envioRepository.deleteById(id);
    }   
}