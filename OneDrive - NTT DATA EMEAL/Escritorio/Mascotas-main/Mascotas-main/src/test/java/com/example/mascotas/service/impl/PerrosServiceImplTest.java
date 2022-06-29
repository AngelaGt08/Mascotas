package com.example.mascotas.service.impl;


import com.example.mascotas.model.PerrosEntity;
import com.example.mascotas.repository.PerrosRepository;
import com.example.mascotas.sample.controller.PerrosEntitySample;
import com.example.mascotas.services.IPerrosServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PerrosServiceImplTest {

    @MockBean
    PerrosRepository perrosRepository;

    @Autowired
    IPerrosServices iPerrosServices;
    private void assertInstanceOf(Class<PerrosEntity> perrosEntityClass, PerrosEntity perros) {
    }
    @Test
    void guardarPerros(){
        when(perrosRepository.save(any())).thenReturn(PerrosEntitySample.getRequestPerrosEntity());
        var responseEntity = iPerrosServices.guardarPerros(PerrosEntitySample.getRequestPerrosEntity());
        PerrosEntity perros = (PerrosEntity) responseEntity.getBody();
        verify(perrosRepository, times(1)).save(any());
        assertNotNull(perros);
        assertEquals("Rex", perros.getNombre());
        assertInstanceOf(PerrosEntity.class, perros);
    }

}
