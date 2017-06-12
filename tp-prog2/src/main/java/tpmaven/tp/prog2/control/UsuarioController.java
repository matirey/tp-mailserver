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
public class UsuarioController {


  @Autowired
  UsuarioService usuarioService;

  @Autowired
  SessionData sessionData;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd){
      Usuario u = usuarioService.login(nombreUsuario, pwd);
      if (null != u) {
        String sessionId = sessionData.addSession(u);
        return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionId), HttpStatus.OK);
      }
      return new ResponseEntity(HttpStatus.FORBIDDEN);
  }


  @RequestMapping("/logout")
  public @ResponseBody ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
      sessionData.removeSession(sessionId);
      return new ResponseEntity(HttpStatus.ACCEPTED);
  }


}
