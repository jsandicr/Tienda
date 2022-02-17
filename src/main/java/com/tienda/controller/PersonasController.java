package com.tienda.controller;
import com.tienda.Service.IPersonaService;
import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonasController{
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")
    public String index(Model model){
        System.out.println("Aqui empieza");
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas",listaPersonas);
        System.out.println("Registros\n"+listaPersonas);
        return "personas";
    }
}
