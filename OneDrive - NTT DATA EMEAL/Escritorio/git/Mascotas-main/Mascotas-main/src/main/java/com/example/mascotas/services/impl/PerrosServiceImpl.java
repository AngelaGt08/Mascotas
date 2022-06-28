package com.example.mascotas.services.impl;

import com.example.mascotas.constants.AppConstans;
import com.example.mascotas.dto.PerrosDTO;
import com.example.mascotas.dto.PerrosLombokDTO;
import com.example.mascotas.dto.api.dummy.ResponseBodyDTO;
import com.example.mascotas.model.PerrosEntity;
import com.example.mascotas.providers.EmployeeFeingProvider;
import com.example.mascotas.repository.PerrosRepository;
import com.example.mascotas.services.IPerrosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PerrosServiceImpl implements IPerrosServices {
    private PerrosRepository perrosRepository;

    private  final EmployeeFeingProvider employeeFeingProvider;

    public PerrosServiceImpl(PerrosRepository perrosRepository, EmployeeFeingProvider employeeFeingProvider) {
        this.perrosRepository = perrosRepository;
        this.employeeFeingProvider = employeeFeingProvider;
    }

    public ResponseEntity guardarPerros(PerrosEntity perrosEntity) {
        perrosEntity.setFechaCreacion(new Date());
        PerrosEntity perros = perrosRepository.save(perrosEntity);
        return ResponseEntity.ok(perros);
    }

    @Override
    public ResponseEntity getAllPerros() {
        return ResponseEntity.ok(perrosRepository.findAll());
    }

    @Override
    public ResponseEntity getPerrosNameNativeQuery(String nombre) {
        return ResponseEntity.ok(perrosRepository.buscarPorNombrePerro(nombre));
    }

    @Override
    public ResponseEntity getPerrosNameForJPQL(String nombre) {
        return ResponseEntity.ok(perrosRepository.buscarPorNombrePerroJPQL(nombre));
    }

    @Override
    public ResponseEntity getPerrosNameForJpaRepository(String nombre) {
        return ResponseEntity.ok(perrosRepository.findByNombre(nombre));
    }

    @Override
    public ResponseEntity putPerrosInformation(PerrosEntity perrosEntity) {
        PerrosEntity perros = perrosRepository.findById(perrosEntity.getId()).orElse(new PerrosEntity());
        perros.setNombre(perrosEntity.getNombre());
        perros.setRaza(perrosEntity.getRaza());
        perrosRepository.save(perros);
        return ResponseEntity.ok("Registro actualizado");
    }

    public ResponseEntity actualizarPerros(Long id, PerrosDTO perrosDTO) {
           var perrosOptional = perrosRepository.findById(id);

        PerrosEntity perrosEntity = perrosOptional.get();
        perrosEntity.setRaza(perrosDTO.getRaza());
        perrosEntity.setNombre(perrosDTO.getNombre());
        perrosRepository.save(perrosEntity);
        return ResponseEntity.ok(AppConstans.ACTUALIZADO_EXITOSAMENTE);
    }

    @Override
    public ResponseEntity deleteHard(Long id) {
        var perrosOptional = perrosRepository.findById(id);
        perrosRepository.delete(perrosOptional.get());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity deleteLogic(Long id) {

        var perros = perrosRepository.findById(id).get();
        perros.setFechaEliminacion(new Date());

        perrosRepository.save(perros);

        return ResponseEntity.ok("Se elimino el registro de la mascota");

    }

    @Override
    public ResponseEntity savePerros(PerrosLombokDTO perrosLombokDTO) {

        PerrosEntity perros = new PerrosEntity();

        perros.setNombre(perrosLombokDTO.getNombre());
        perros.setRaza(perrosLombokDTO.getRaza());

        perros.setFechaCreacion(new Date());
        perros = perrosRepository.save(perros);

        return ResponseEntity.ok(perros);

    }

    @Override
    public ResponseEntity getEmployees() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity responseEntity ;
        responseBodyDTO= employeeFeingProvider.getListEmployee();
        responseEntity= ResponseEntity.ok(responseBodyDTO);
        return responseEntity;
    }



}
