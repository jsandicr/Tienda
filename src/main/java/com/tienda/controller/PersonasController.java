package com.tienda.controller;
import com.tienda.Service.IPersonaService;
import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/modificarPersona/{id}")
    public String modificarPersona(@PathVariable Long id, Model model){
        Persona persona=personaService.getPersonById(id);
        model.addAttribute("persona", persona);
        System.out.println(persona);
        return "modificarPersona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(Persona persona){
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
}
