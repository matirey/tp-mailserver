
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.persist;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tpmaven.tp.prog2.model.Usuario;

/**
 *
 * @author Matias
 */
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);

    List<Usuario> findByApellido(String apellido);

    int countByUsername(String username);

    int countByEmail(String email);
}

