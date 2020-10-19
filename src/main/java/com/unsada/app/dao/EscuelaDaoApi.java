package com.unsada.app.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.unsada.app.modelo.Escuela;

@Transactional
public interface EscuelaDaoApi extends CrudRepository<Escuela, Integer> {
	
	 Optional<Escuela> findByNombre(String nombre);
	 Iterable<Escuela> findByNombreLike(String nombre);
}
