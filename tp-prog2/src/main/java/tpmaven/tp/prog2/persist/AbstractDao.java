/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.persist;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Matias
 */
public abstract class AbstractDao<K> {

  protected SessionFactory sessionFactory;

  public AbstractDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  abstract List<K> getAll();
  abstract K getById(int id);
  abstract void save(K value);

}

