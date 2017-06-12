/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Matias
 */
@org.springframework.context.annotation.Configuration
public class HibernateUtil {

	private static  final SessionFactory sessionFactory = buildSessionFactory();

	@Bean
	private  static SessionFactory buildSessionFactory() {
		try {
			
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static  SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static  void shutdown() {
		getSessionFactory().close();
	}

}