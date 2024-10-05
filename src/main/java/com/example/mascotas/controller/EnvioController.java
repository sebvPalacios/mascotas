package com.example.mascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mascotas.model.Envio;
import com.example.mascotas.service.EnvioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/envios")
public class EnvioController {
    
    @Autowired
    private EnvioService envioService;

     @GetMapping
    public CollectionModel<EntityModel<Envio>>  getAllEnvios(){
        List<Envio> envios = envioService.getAllEnvios();

        List<EntityModel<Envio>> envioResources = envios.stream()
                .map(envio -> EntityModel.of(envio,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(envio.getId())).withSelfRel()
                        ))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios());
        CollectionModel<EntityModel<Envio>> resources = CollectionModel.of(envioResources, linkTo.withRel("envios"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<Envio> getEnvioById(@PathVariable Long id){
        Optional<Envio> envio = envioService.getEnvioById(id);

        if(envio.isPresent()){
            return EntityModel.of(envio.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
        } else{
            throw new EnvioNotFoundException("Envio no encontrado con el id" + id);
        }
    }

    @PostMapping
    public EntityModel<Envio> crearEnvio(@RequestBody Envio envio){
        Envio createdEnvio = envioService.crearEnvio(envio);
        return EntityModel.of(createdEnvio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(createdEnvio.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
    }

    @PutMapping("/{id}")
    public EntityModel<Envio> updateEnvio(@PathVariable Long id, @RequestBody Envio envio){
        Envio updatedEnvio = envioService.updateEnvio(id, envio);
        return EntityModel.of(updatedEnvio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id){
        envioService.eliminarEnvio(id);
    }   
    
    
}
