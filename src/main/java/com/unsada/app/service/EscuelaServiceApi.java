package com.unsada.app.service;




import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.unsada.app.modelo.Escuela;


public interface EscuelaServiceApi extends CrudRepository<Escuela, Integer> {

	
	Optional<Escuela> findByNombre(String nombre);
	List<Escuela> findByNombreLike(String nombre);

}
