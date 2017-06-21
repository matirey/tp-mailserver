/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.converter;

import org.springframework.stereotype.Component;
import tpmaven.tp.prog2.model.Usuario;
import tpmaven.tp.prog2.response.UsuarioWrapper;

/**
 *
 * @author Matias
 */
@Component
public class UsuarioConverter {

    public UsuarioConverter() {
    }

    public UsuarioWrapper convert(Usuario usuario) {
        UsuarioWrapper uwrapper = new UsuarioWrapper();

        uwrapper.setId(usuario.getId());
        uwrapper.setNombre(usuario.getNombre());
        uwrapper.setApellido(usuario.getApellido());
        uwrapper.setDireccion(usuario.getDireccion());
        uwrapper.setTelefono(usuario.getTelefono());
        uwrapper.setCiudad(usuario.getCiudad());
        uwrapper.setProvincia(usuario.getProvincia());
        uwrapper.setPais(usuario.getPais());
        uwrapper.setUsername(usuario.getUsername());
        uwrapper.setEmail(usuario.getEmail());

        return uwrapper;
    }
}