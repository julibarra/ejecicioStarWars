package com.ejercicio2clase3.starwars.control;

import com.ejercicio2clase3.starwars.model.ResultadoDTO;

import com.ejercicio2clase3.starwars.service.ISWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SWRestController {
    @Autowired
    private ISWService service;



    @PostMapping(path = "/starwars/{name}")
    public ResultadoDTO crearRespuesta(@PathVariable String name){

        return service.devolverPersonajes(name);
    }

}
