/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.model;

/**
 *
 * @author Matias
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;


public class Persona {

	private int id;
	private String nombre;
	private String apellido;
	private long edad;
	private Date fechaNacimiento;

	public Persona(){
	}
	

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public long getEdad() {
		long today = new Date().getTime();
		long fechaNac = this.getFechaNacimiento().getTime();
		long diff = (today - fechaNac);
		long year = (1000L*60L*60L*24L*365L);
		return diff / year ;

	}

	public void setEdad(long edad) {
		this.edad = edad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
