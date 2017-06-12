/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.converter;

import java.text.SimpleDateFormat;
import tpmaven.tp.prog2.model.Persona;
import tpmaven.tp.prog2.response.PersonaWrapper;

/**
 *
 * @author Matias
 */
public class PersonaConverter implements PersonaConverterInterface {

    public String dateFormat;

    public PersonaConverter(String dateFormat) {
        this.dateFormat = dateFormat;
    }

     public PersonaWrapper convert(Persona persona) {
        PersonaWrapper p = new PersonaWrapper();
        p.setApellido(persona.getApellido());
        p.setNombre(persona.getNombre());
        p.setEdad(persona.getEdad());
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        p.setFechaNacimiento(sdf.format(persona.getFechaNacimiento()));
        return p;
    }

}

