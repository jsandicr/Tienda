package com.tienda.Service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements  IPaisService{

    @Autowired
    private PaisRepository repository;

    @Override
    public List<Pais> getAllPaises() {
        return (List<Pais>)repository.findAll();
    }

    @Override
    public void savePais(Pais pais) {
        repository.save(pais);
    }

    @Override
    public Pais getPaisById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
