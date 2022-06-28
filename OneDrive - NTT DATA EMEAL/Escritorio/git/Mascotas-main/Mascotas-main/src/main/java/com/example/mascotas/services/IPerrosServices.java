package com.example.mascotas.services;

import com.example.mascotas.dto.PerrosDTO;
import com.example.mascotas.dto.PerrosLombokDTO;
import com.example.mascotas.model.PerrosEntity;
import org.springframework.http.ResponseEntity;

public interface IPerrosServices {

    ResponseEntity guardarPerros(PerrosEntity perrosEntity);

    ResponseEntity getAllPerros();


    ResponseEntity getPerrosNameNativeQuery(String nombre);

    ResponseEntity getPerrosNameForJPQL(String nombre);


    ResponseEntity getPerrosNameForJpaRepository(String nombre);


    ResponseEntity putPerrosInformation(PerrosEntity perrosEntity);


    ResponseEntity actualizarPerros(Long id, PerrosDTO perrosDTO);

    ResponseEntity deleteHard(Long id);

    ResponseEntity deleteLogic(Long id);

    ResponseEntity savePerros(PerrosLombokDTO perrosLombokDTO);

    ResponseEntity getEmployees();

}
