package com.example.mascotas.services;

import org.springframework.http.ResponseEntity;

public interface IEmployeeServices {
    ResponseEntity getFiltroEdad();

    ResponseEntity getEmployees();

    ResponseEntity getFiltroSalario();
}
