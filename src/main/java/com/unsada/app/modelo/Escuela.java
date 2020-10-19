package com.unsada.app.modelo;



import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "escuela")

public class Escuela implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Basic(optional = false)
	    @Column(name = "id_escuela")
	    private Integer idEscuela;
	   
	    @Column(name = "nombre")
	    private String nombre;
	    
	  
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEscuela")
	    private Collection<Profesor> profesorCollection;


		public Escuela(Integer idEscuela, String nombre, Collection<Profesor> profesorCollection) {
			super();
			this.idEscuela = idEscuela;
			this.nombre = nombre;
			this.profesorCollection = profesorCollection;
		}


		public Escuela() {
			super();
		}


		public Integer getIdEscuela() {
			return idEscuela;
		}


		public void setIdEscuela(Integer idEscuela) {
			this.idEscuela = idEscuela;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		


		@Override
		public String toString() {
			return "Escuela [idEscuela=" + idEscuela + "]";
		}

	
	    

		
}