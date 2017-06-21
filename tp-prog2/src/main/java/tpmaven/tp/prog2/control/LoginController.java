/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tpmaven.tp.prog2.model.Usuario;
import tpmaven.tp.prog2.response.LoginResponseWrapper;
import tpmaven.tp.prog2.service.UsuarioService;
import tpmaven.tp.prog2.util.SessionData;

/**
 *
 * @author Matias
 */
@RestController
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SessionData sessionData;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<LoginResponseWrapper> getById(
            @RequestParam("user") String username,
            @RequestParam("password") String password
    ) {
        try {
            Usuario usuario = usuarioService.login(username, password);

            if (null != usuario) {
                String sessionid = sessionData.addSession(usuario);
                return new ResponseEntity<>(new LoginResponseWrapper(sessionid), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping("/logout")
    public @ResponseBody
    ResponseEntity getById(@RequestHeader("sessionid") String sessionid) {
        try {
            sessionData.removeSession(sessionid);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
