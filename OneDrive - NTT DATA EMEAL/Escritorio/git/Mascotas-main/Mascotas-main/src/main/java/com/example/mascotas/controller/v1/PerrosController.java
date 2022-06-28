package com.example.mascotas.controller.v1;

import com.example.mascotas.dto.PerrosDTO;
import com.example.mascotas.model.PerrosEntity;
import com.example.mascotas.services.IPerrosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/perros/v1")
public class PerrosController {
    private IPerrosServices iPerrosServices;

    public PerrosController(IPerrosServices iPerrosServices) {
        this.iPerrosServices = iPerrosServices;
    }

    @PostMapping
    public ResponseEntity guardarPerros(@RequestBody PerrosEntity perrosEntity){

        return iPerrosServices.guardarPerros(perrosEntity);
    }

    @GetMapping
    public ResponseEntity listAllPerros(){
        return iPerrosServices.getAllPerros();
    }

    @GetMapping("/nombre/native-query")
    public ResponseEntity getPerrosForNativeQuery(@PathParam("nombre")String nombre){
        return iPerrosServices.getPerrosNameNativeQuery(nombre);
    }


    @GetMapping("/nombre/jpql")
    public ResponseEntity getPerrosForJPQL(@PathParam("nombre") String nombre){
        return iPerrosServices.getPerrosNameForJPQL(nombre);
    }


    @GetMapping("/nombre/jpa-repository")
    public ResponseEntity getPerrosForJPARespository(@PathParam("nombre") String nombre){
        return iPerrosServices.getPerrosNameForJpaRepository(nombre);
    }

    @PutMapping
    public ResponseEntity modificarPerros(@RequestBody PerrosEntity perrosEntity){
        return iPerrosServices.putPerrosInformation(perrosEntity) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity putPerros(@PathVariable Long id ,@RequestBody PerrosDTO perros){
        return iPerrosServices.actualizarPerros(id,perros);
    }

    @DeleteMapping("/logic/{id}")
    public ResponseEntity deleteHard(@PathVariable Long id){
        return iPerrosServices.deleteLogic(id);
    }
}
