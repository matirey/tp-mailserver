/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpmaven.tp.prog2.model.Usuario;
import tpmaven.tp.prog2.persist.UsuarioDao;
import tpmaven.tp.prog2.request.UsuarioRequest;

/**
 *
 * @author Matias
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuariodao;

    public Usuario login(String username, String password) {

        Usuario u = usuariodao.findByUsername(username);

        if (u == null) {
            return null;
        }

        if (password.equals(u.getPassword())) {
            return u;
        }

        return null;
    }

    public Usuario newUser(UsuarioRequest usuariorequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuariorequest.getNombre());
        usuario.setApellido(usuariorequest.getApellido());
        usuario.setDireccion(usuariorequest.getDireccion());
        usuario.setTelefono(usuariorequest.getTelefono());
        usuario.setCiudad(usuariorequest.getCiudad());
        usuario.setProvincia(usuariorequest.getProvincia());
        usuario.setPais(usuariorequest.getPais());
        usuario.setUsername(usuariorequest.getUsername());
        usuario.setEmail(usuariorequest.getEmail());
        usuario.setPassword(usuariorequest.getPassword());

        return usuariodao.save(usuario);
    }    
}
