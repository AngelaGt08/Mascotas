package com.example.mascotas.controller.v2.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public interface PerrosDocs {

    @Operation(summary = "Servicio para traer informacion de perros")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna listado perros",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployee();
}
