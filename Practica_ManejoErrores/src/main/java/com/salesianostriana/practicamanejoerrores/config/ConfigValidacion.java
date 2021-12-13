package com.salesianostriana.practicamanejoerrores.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ConfigValidacion {

    //Indica que vamos a cargar el ficheor 'messages', que se encuentra dentro del classpath
    //cuya codificación es UTF-8
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    //Configura el validador por defecto asignándole como fuente de mensajes de validación el bean anterior
    @Bean
    public LocalValidatorFactoryBean getValidator(){

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(this.messageSource());

        return validator;
    }

}
