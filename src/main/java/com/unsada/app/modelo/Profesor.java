package com.unsada.app.modelo;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table (name = "profesor")

public class Profesor implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
   
    @Column(name = "legajo")
    private Integer legajo;
   
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
   
    @Column(name = "especialidad")
    private String especialidad;
   
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
   
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
   
  


	@JoinColumn(name = "id_escuela", referencedColumnName = "id_escuela")
    @ManyToOne(optional = false)
    private Escuela idEscuela;





	public Profesor(Integer id, Integer legajo, String nombre, String apellido, String especialidad, Date fechaIngreso,
			Date fecha_nacimiento, Escuela idEscuela) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
		this.fecha_nacimiento = fecha_nacimiento;
		this.idEscuela = idEscuela;
	}





	public Profesor() {
		super();
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Integer getLegajo() {
		return legajo;
	}





	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getEspecialidad() {
		return especialidad;
	}





	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}





	public Date getFechaIngreso() {
		return fechaIngreso;
	}





	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}





	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}





	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}





	public Escuela getIdEscuela() {
		return idEscuela;
	}





	public void setIdEscuela(Escuela idEscuela) {
		this.idEscuela = idEscuela;
	}





	@Override
	public String toString() {
		return "Profesor [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", especialidad=" + especialidad + ", fechaIngreso=" + fechaIngreso + ", fecha_nacimiento="
				+ fecha_nacimiento + ", idEscuela=" + idEscuela + "]";
	}







}
