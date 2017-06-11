/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Matias
 */
public class PersonaWrapper {

  @JsonProperty
  String apellido;
  @JsonProperty
  String nombre;
  @JsonProperty
  long edad;
  @JsonProperty
  String fechaNacimiento;


  @JsonProperty("nombreyapellido")
  public String getNyP() {
    return this.nombre + this.apellido;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEdad(long edad) {
    this.edad = edad;
  }

  public String getApellido() {
    return apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public long getEdad() {
    return edad;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

}
