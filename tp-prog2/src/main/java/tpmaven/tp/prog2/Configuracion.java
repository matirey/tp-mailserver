/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tpmaven.tp.prog2.converter.PersonaConverter;
import tpmaven.tp.prog2.converter.PersonaConverterInterface;

/**
 *
 * @author Matias
 */
@Configuration
public class Configuracion {

    @Autowired
    AuthFilter authFilter;

    @Value("${date.format}")
    String dateFormat;

    @Bean(name="normalConverter")
    public PersonaConverterInterface getNormalConverter(){
        return  new PersonaConverter(dateFormat);

    }

    

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

}

