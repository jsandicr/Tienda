package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*
Internalizacion ---- i18n --- 18 letras entre la i y la n
Locale:Representa es el lenguaje, la region geografica, variantes del dialecto de un usuario
SessionLocaleResolver:Guardar el Locale seleccionado por un usuario como atributo en el request HTTP
LocalChangeInterceptor:Detectar cualquier cambio de parte del usuario hacia lo que es el Locale
*/

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr=new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en"));
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci=new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("crear");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errrores/403");
    }
    
}
