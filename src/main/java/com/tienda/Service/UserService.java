package com.tienda.Service;
import com.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private IPersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String apellido1) throws UsernameNotFoundException {
        Persona p=personaService.findByApellido1(apellido1);
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority ("ADMIN"));
        UserDetails userDet=new User(p.getApellido1(), p.getApellido2(),roles);
        return userDet;
    }
}
