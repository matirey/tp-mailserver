/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpmaven.tp.prog2.model.Persona;
import tpmaven.tp.prog2.persist.PersonaDao;
import tpmaven.tp.prog2.util.HibernateUtil;

/**
 *
 * @author Matias
 */
@Service
public class PersonaService {

  @Autowired
  PersonaDao personaDao;

  public PersonaService() {
    this.personaDao = new PersonaDao(HibernateUtil.getSessionFactory());
  }


  public List<Persona> getAll() {
        return personaDao.getAll();
  }


  public Persona getPersona(int id) {
      return personaDao.getById(id);
  }

  public void newPersona(String nombre, String apellido, String fechaNacimiento)  throws ParseException  {
      Persona p = new Persona();
      p.setApellido(apellido);
      p.setNombre(nombre);
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      p.setFechaNacimiento(sdf.parse(fechaNacimiento));
      this.personaDao.save(p);
  }

  public List<Persona> getByApellido(String surname) {
    return personaDao.getBySurname(surname);
  }

}
