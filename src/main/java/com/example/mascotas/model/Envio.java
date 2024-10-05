package com.example.mascotas.model;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "envio") // Creamos una tabla llamada envio
public class Envio extends RepresentationModel<Envio> {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // le asignamos un id autogenerado
    @Column(name = "id")
    private Long id;

    @Column(name = "nombreProducto") // Columna llamada nombreproducto tipo string
    private String nombreProducto;
    @Column(name = "estadoEnvio")    // Columna llamada estado envio tipo string
    private String estadoEnvio;
    @Column(name = "ubicacion")      // columna llamada ubicacion de tipo string
    private String ubicacion;
    @Column(name = "destino")        // columna llamada destino tipo string
    private String destino;


    // Getters
    public Long getId(){
        return id;
    }

    public String getNombreProducto(){
        return nombreProducto;
    }

    public String getEstadoEnvio(){
        return estadoEnvio;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public String getDestino(){
        return destino;
    }

    // Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    public void setEstadoEnvio(String estadoEnvio){
        this.estadoEnvio = estadoEnvio;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }
}
