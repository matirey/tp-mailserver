/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.converter;

import tpmaven.tp.prog2.model.Persona;
import tpmaven.tp.prog2.response.PersonaWrapper;

/**
 *
 * @author Matias
 */
public interface PersonaConverterInterface {

  public PersonaWrapper convert(Persona persona);
}

