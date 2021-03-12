package com.ejercicio2clase3.starwars.repository;

import com.ejercicio2clase3.starwars.model.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


@Repository

public class SWRepository implements ISWRepository {

    List<PersonajeDTO> personajes;

    public SWRepository() {
        this.personajes = loadFromDB();
    }
    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        return this.personajes.stream()
                .filter(personaje -> personaje.getName()
                        .toLowerCase()
                        .contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<PersonajeDTO> loadFromDB() {

        List<PersonajeDTO> ret = null;
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {};

        try {
            ret = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}


