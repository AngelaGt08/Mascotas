package com.example.mascotas.services.impl;

import com.example.mascotas.dto.api.dummy.ResponseBodyDTO;
import com.example.mascotas.dto.api.dummy.ResponseEmployeeDTO;
import com.example.mascotas.providers.EmployeeFeingProvider;
import com.example.mascotas.services.IEmployeeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeImpl implements IEmployeeServices {

    private final EmployeeFeingProvider employeeFeingProvider;

    public EmployeeImpl(EmployeeFeingProvider employeeFeingProvider) {
        this.employeeFeingProvider = employeeFeingProvider;
    }

    @Override
    public ResponseEntity getEmployees() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity responseEntity ;
        responseBodyDTO= employeeFeingProvider.getListEmployee();
        responseEntity= ResponseEntity.ok(responseBodyDTO);
        return responseEntity;
    }

    @Override
    public ResponseEntity getFiltroEdad(){
        ResponseEntity responseEntity;
        try {
            List<ResponseEmployeeDTO> Empleados = employeeFeingProvider.getListEmployee().getData();
            List<ResponseEmployeeDTO> Edades = new ArrayList<>();
            for (ResponseEmployeeDTO emple:Empleados){
                if (emple.getEmployeeAge() > 30){
                    Edades.add(emple);
                }
            }
            responseEntity = ResponseEntity.ok(Edades);
        }catch(Exception e){
            responseEntity = ResponseEntity.ok(e.getCause());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity getFiltroSalario(){
        ResponseEntity responseEntity;
        try {
            List<ResponseEmployeeDTO> Empleados = employeeFeingProvider.getListEmployee().getData();
            Stream<ResponseEmployeeDTO>FiltroSalario = Empleados.stream();
            List<ResponseEmployeeDTO>Salario=FiltroSalario.filter(persona-> persona.getEmployeeSalary()>100000).collect(Collectors.toList());
            responseEntity = ResponseEntity.ok(Salario);
        }catch(Exception e){
            responseEntity = ResponseEntity.ok(e.getCause());
        }
        return responseEntity;
    }


}
