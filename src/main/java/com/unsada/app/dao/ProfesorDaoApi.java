package com.unsada.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.unsada.app.modelo.Profesor;




@Transactional
public interface ProfesorDaoApi extends CrudRepository<Profesor, Integer>{
	@Query(value="select * from profesor ORDER by id DESC LIMIT 1",nativeQuery = true)
	Optional<Profesor> findUltimo();
}
