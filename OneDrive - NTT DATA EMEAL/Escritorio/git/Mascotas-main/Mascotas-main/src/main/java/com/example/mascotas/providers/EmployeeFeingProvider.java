package com.example.mascotas.providers;

import com.example.mascotas.dto.api.dummy.ResponseBodyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "restapiexample",
        url = "${restapiexample.url}"
)
public interface EmployeeFeingProvider {

    @GetMapping("/employees")
    ResponseBodyDTO getListEmployee();

}

