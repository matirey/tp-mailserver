/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Matias
 */

@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuarioid", nullable = false)
    private long id;

    @NotEmpty(message = "Nombre")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotEmpty(message = "Apellido")
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotEmpty(message = "Direccion")
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotEmpty(message = "Telefono")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotEmpty(message = "Ciudad")
    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @NotEmpty(message = "Pais")
    @Column(name = "pais", nullable = false)
    private String pais;
    
    @NotEmpty(message = "Provincia")
    @Column(name = "provincia", nullable = false)
    private String provincia;

    @NotEmpty(message = "Username")
    @Column(name = "username", columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String username;

    @NotEmpty(message = "Password")
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty(message = "Email")
    @Column(name = "email", columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String email;

   // @OneToMany(mappedBy = "user")
   // @OnDelete(action = OnDeleteAction.CASCADE)
   // private List<Mensaje> listamsj;

    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, String direccion, String telefono, String ciudad, String pais, String provincia, String username, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.provincia = provincia;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
