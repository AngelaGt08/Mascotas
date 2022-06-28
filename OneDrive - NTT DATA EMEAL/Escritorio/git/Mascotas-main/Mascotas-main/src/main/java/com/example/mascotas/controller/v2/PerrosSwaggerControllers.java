package com.example.mascotas.controller.v2;

import com.example.mascotas.controller.v2.docs.PerrosDocs;
import com.example.mascotas.services.IPerrosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/employees")
@RestController
public class PerrosSwaggerControllers implements PerrosDocs {

    private  IPerrosServices iPerrosServices;

    public PerrosSwaggerControllers(IPerrosServices iPerrosServices) {
        this.iPerrosServices = iPerrosServices;
    }

    @Override
    @GetMapping("/employee-list")
    public ResponseEntity getEmployee() {
        return iPerrosServices.getEmployees();
    }
}
