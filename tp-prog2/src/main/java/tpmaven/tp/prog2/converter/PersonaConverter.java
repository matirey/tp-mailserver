/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.converter;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import tpmaven.tp.prog2.model.Persona;
import tpmaven.tp.prog2.model.Usuario;
import tpmaven.tp.prog2.response.PersonaWrapper;

/**
 *
 * @author Matias
 */
@Component
public class UsuarioConverter {

    public UsuarioConverter() {
    }

    public UsuarioWrapper convert(Usuario user) {
        UsuarioWrapper u = new UsuarioWrapper();

        u.setId(user.getId());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setAddress(user.getAddress());
        u.setPhone(user.getPhone());
        u.setCity(user.getCity());
        u.setState(user.getState());
        u.setCountry(user.getCountry());
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());

        return u;
    }
}


