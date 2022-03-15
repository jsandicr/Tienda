package com.tienda.Service;

import com.tienda.entity.Pais;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaisService {
    public List<Pais> getAllPaises();
    public void savePais(Pais pais);
    public Pais getPaisById(long id);
    public void delete(long id);
}
