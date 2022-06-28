package com.example.mascotas.repository;

import com.example.mascotas.model.PerrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerrosRepository extends JpaRepository<PerrosEntity,Long> {

    @Query(value = "SELECT u.* FROM perros u where u.nombre = :nombre",nativeQuery = true)
    List<PerrosEntity> buscarPorNombrePerro(String nombre);

    @Query("SELECT u FROM  PerrosEntity u WHERe u.nombre = :nombre")
    List<PerrosEntity> buscarPorNombrePerroJPQL(String nombre);

    List<PerrosEntity> findByNombre(String nombre);
}
