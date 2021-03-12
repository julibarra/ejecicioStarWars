package com.ejercicio2clase3.starwars.service;

import com.ejercicio2clase3.starwars.model.PersonajeDTO;
import com.ejercicio2clase3.starwars.model.ResultadoDTO;
import com.ejercicio2clase3.starwars.repository.ISWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class SWService implements ISWService {
    @Autowired
    private ISWRepository repository;

    @Override
    public ResultadoDTO devolverPersonajes(String name) {
        ResultadoDTO resultado=new ResultadoDTO();

        resultado.setNombres(nombreCompletos(repository.buscarPorNombre(name)));
        return resultado;
    }

    private List<String> nombreCompletos(List<PersonajeDTO> character){
        List<String> resultados= new ArrayList<>();
        for (PersonajeDTO personaje:
             character) {
            resultados.add(personaje.getName());
        }
        return resultados;

    }
}
