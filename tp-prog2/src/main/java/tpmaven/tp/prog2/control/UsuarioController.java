/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.control;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tpmaven.tp.prog2.converter.UsuarioConverter;
import tpmaven.tp.prog2.model.Usuario;
import tpmaven.tp.prog2.persist.UsuarioDao;
import tpmaven.tp.prog2.request.UsuarioRequest;
import tpmaven.tp.prog2.response.UsuarioWrapper;
import tpmaven.tp.prog2.service.UsuarioService;


/**
 *
 * @author Matias
 */
@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioConverter usuarioConverter;

    @Autowired
    UsuarioDao usuariodao;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getAll() {
        //hay que usar un ITERABLE porque el FINDALL devuelve un ITERABLE
        try {
            Iterable<Usuario> iterable = usuariodao.findAll();
            List<Usuario> listado = Lists.newArrayList(iterable);
            if (listado.size() > 0) {
                return new ResponseEntity<>(this.convertirList(listado), HttpStatus.OK);
            }
            else{throw new Exception("No users");}
        } catch (Exception e) {
            return new ResponseEntity<>(new Exception(e.getMessage()), HttpStatus.NO_CONTENT);
        }
        
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity create(@RequestBody UsuarioRequest request) {
        try {
            if (usuariodao.countByUsername(request.getUsername()) > 0) {
                throw new Exception("Nombre de usuario ya usado.");
            } else if (usuariodao.countByEmail(request.getEmail()) > 0) {
                throw new Exception("Email ya registrado.");
            } else {
                Usuario usuario = usuarioService.newUser(request);
                return new ResponseEntity<>(usuarioConverter.convert(usuario), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Exception(e.getMessage()), HttpStatus.CONFLICT);
        } 
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestHeader("usuario") String username) {
        try {
            Usuario usuario = usuariodao.findByUsername(username);
            // Aca deberia borrar todos los msj del usuario pero como todavia no lo tengo terminado..
            usuariodao.delete(usuario.getId());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Exception(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

    private List<UsuarioWrapper> convertirList(List<Usuario> listado) {
        List<UsuarioWrapper> uwrapperArrayList = new ArrayList<>();

        for (Usuario u : listado) {
            uwrapperArrayList.add(usuarioConverter.convert(u));
        }
        return uwrapperArrayList;
    }

}
