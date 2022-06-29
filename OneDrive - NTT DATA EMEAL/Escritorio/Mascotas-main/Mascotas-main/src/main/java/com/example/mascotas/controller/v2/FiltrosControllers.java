package com.example.mascotas.controller.v2;

import com.example.mascotas.controller.v2.docs.Docs;
import com.example.mascotas.services.IEmployeeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/employees")
@RestController
public class FiltrosControllers implements Docs {
    private IEmployeeServices iEmployeeServices;

    public FiltrosControllers(IEmployeeServices iEmployeeServices) {
        this.iEmployeeServices = iEmployeeServices;
    }

    @Override
    @GetMapping("/employee-list")
    public ResponseEntity getEmployee() {
        return iEmployeeServices.getEmployees();
    }

    @GetMapping("/employee-edad")
    public ResponseEntity getEdad(){
        return iEmployeeServices.getFiltroEdad();
    }

    @GetMapping("/employee-salario")
    public ResponseEntity getSalario(){
        return iEmployeeServices.getFiltroSalario();
    }
}
