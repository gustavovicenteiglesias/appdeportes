package com.unsada.app.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.app.dao.EscuelaDaoApi;
import com.unsada.app.modelo.Escuela;

import com.unsada.app.service.EscuelaServiceApi;

@Service
public class EscuelaServiceImpl  implements EscuelaServiceApi {
	
	@Autowired
	EscuelaDaoApi escuelaDaoApi;
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Escuela> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		escuelaDaoApi.deleteById(id);
		
	}

	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Escuela> findAll() {
		// TODO Auto-generated method stub
		return escuelaDaoApi.findAll();
	}

	@Override
	public Iterable<Escuela> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Escuela> findById(Integer id) {
		// TODO Auto-generated method stub
		return escuelaDaoApi.findById( id);
	}
	
	

	@Override
	public <S extends Escuela> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Escuela> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(Escuela arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Optional<Escuela> findByNombre(String nombre){
		
		return escuelaDaoApi.findByNombre(nombre);
	}



	@Override
	public List<Escuela> findByNombreLike(String nombre) {
		
		
		return (List<Escuela>) escuelaDaoApi.findByNombreLike(nombre);
	}

}
