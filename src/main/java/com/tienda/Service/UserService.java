package com.tienda.Service;

import com.tienda.entity.Persona;
import com.tienda.Service.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private IPersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = this.personaService.findByApellido1(username);
        UserPrincipal userPrincipal = new UserPrincipal(persona);
        return userPrincipal;
    }
}
