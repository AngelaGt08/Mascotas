package com.example.mascotas.sample.controller;

import com.example.mascotas.model.PerrosEntity;
import org.springframework.http.ResponseEntity;
import java.util.Date;
public class PerrosEntitySample{

    public static ResponseEntity getPerrosEntity(){
        PerrosEntity perros = new PerrosEntity(1L,"Rex","Pastor Aleman",4,new Date(), new Date());
        return ResponseEntity.ok(perros);
    }

    public static  PerrosEntity getRequestPerrosEntity(){
        PerrosEntity perros = new PerrosEntity();
        perros.setNombre("Rex");
        perros.setRaza("Florez");
        perros.setEdad(4);
        perros.setFechaCreacion(new Date());
        return perros;
    }

}
