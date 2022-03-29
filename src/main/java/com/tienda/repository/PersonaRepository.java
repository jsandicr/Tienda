package com.tienda.repository;
import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    //Select * from Persona Where nombre=String nombre
    Persona findByApellido1(String apellido1);
}