package com.ejercicio2clase3.starwars.repository;

import com.ejercicio2clase3.starwars.model.PersonajeDTO;

import java.util.List;

public interface ISWRepository {
  List<PersonajeDTO> buscarPorNombre(String nombre);
}
