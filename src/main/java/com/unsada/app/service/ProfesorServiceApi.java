package com.unsada.app.service;





import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unsada.app.modelo.Profesor;

public interface ProfesorServiceApi extends CrudRepository<Profesor, Integer>{
	@Query(value="select * from profedor ORDER by id DESC LIMIT 1",nativeQuery = true)
	Optional<Profesor> findUltimo();	
}
