package com.unsada.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.app.dao.ProfesorDaoApi;
import com.unsada.app.modelo.Profesor;
@Service
public class ProfesorServiceImpl  implements ProfesorServiceApi{
	
	@Autowired
	ProfesorDaoApi profesorDaoApi;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Profesor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Profesor> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		profesorDaoApi.deleteById(id);
		
	}

	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Profesor> findAll() {
		// TODO Auto-generated method stub
		return profesorDaoApi.findAll();
	}

	@Override
	public Iterable<Profesor> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Profesor> findById(Integer id) {
		// TODO Auto-generated method stub
		return profesorDaoApi.findById(id);
	}

	@Override
	public <S extends Profesor> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Profesor> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Profesor> findUltimo() {
		// TODO Auto-generated method stub
		return profesorDaoApi.findUltimo();
	}



}
