/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.control;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

/**
 *
 * @author Matias
 */
@RestController
@RequestMapping(
    value = "/api",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonaController  {


  @Autowired
  PersonaService personaService;

  @Autowired
  @Qualifier("uglyConverter")
  PersonaConverterInterface converter;

    @RequestMapping("/persona/{id}")
    public @ResponseBody ResponseEntity<PersonaWrapper> getById(@RequestHeader("usuario") String userName , @PathVariable("id") int id){
      Persona per = personaService.getPersona(id);
      if (per!=null) {
        PersonaWrapper p = converter.convert(per);
        return  new ResponseEntity<PersonaWrapper>(p,HttpStatus.OK);
      } else {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
    }

  @RequestMapping("/persona/")
  public @ResponseBody  ResponseEntity<List<PersonaWrapper>> getAll() {
   List<Persona> list = personaService.getAll();
    if (list.size()>0) {
      return new ResponseEntity<List<PersonaWrapper>>(this.convertList(list), HttpStatus.OK);
    } else {
      return new ResponseEntity<List<PersonaWrapper>>(HttpStatus.NO_CONTENT);
    }
  }

  @RequestMapping(value = "/persona", method = RequestMethod.GET)
  public ResponseEntity<List<PersonaWrapper>> getBySurname(@RequestParam ("ape") String apellido) {
    List<Persona> list = personaService.getByApellido(apellido);
    if (list.size()>0) {
      return new ResponseEntity<List<PersonaWrapper>>(this.convertList(list), HttpStatus.OK);
    } else {
      return new ResponseEntity<List<PersonaWrapper>>(HttpStatus.NO_CONTENT);
    }
  }

  @RequestMapping(value = "/persona", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addPersona(@RequestBody PersonaRequest request) {
    try {
      personaService.newPersona(request.getNombre(), request.getApellido(), request.getFechaNacimiento());
      return new ResponseEntity(HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  private List<PersonaWrapper> convertList(List<Persona> personas ){
    List<PersonaWrapper> personaWrapperList = new ArrayList<PersonaWrapper>();
    for (Persona p : personas) {
      personaWrapperList.add(converter.convert(p));
    }
    return personaWrapperList;
  }


}
