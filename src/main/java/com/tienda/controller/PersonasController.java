package com.tienda.controller;
import com.tienda.Service.IPaisService;
import com.tienda.Service.IPersonaService;
import com.tienda.entity.Persona;
import com.tienda.entity.Pais;
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
    @Autowired
    private IPaisService paisService;

    @GetMapping("/personas")
    public String index(Model model){
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas",listaPersonas);
        return "personas";
    }

    @GetMapping("/eliminarPersona/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.delete(id);
        return "redirect:/personas";
    }

    @GetMapping("/modificarPersona/{id}")
    public String modificarPersona(@PathVariable Long id, Model model){
        Persona persona=personaService.getPersonById(id);
        List<Pais> listaPais=paisService.getAllPaises();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPais);
        return "agregarPersona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(Persona persona){
        personaService.savePerson(persona);
        return "redirect:/personas";
    }

    @GetMapping("/agregarPersona")
    public String agregarPersona(Model model){
        List<Pais> listaPaises=paisService.getAllPaises();
        model.addAttribute("paises", listaPaises);
        model.addAttribute("persona", new Persona());
        return "agregarPersona";
    }
}
