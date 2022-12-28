/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Service;

import com.portfolio.fhr.Entity.Experiencias;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.fhr.Repository.RExperiencia;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencias;
    
    public List<Experiencias> list(){
        return rExperiencias.findAll();
    }
    
    public Optional<Experiencias> getone(int id){
        return rExperiencias.findById(id);
    }
    
    public Optional<Experiencias> getByNombreE(String nombreE){
        return rExperiencias.findByNombreE(nombreE);
    }
    
    public void save(Experiencias expe){
        rExperiencias.save(expe);
    }
    
    public void delete(int id){
        rExperiencias.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencias.existsById(id);
    }
    
    public boolean existsbyNombreE(String nombreE){
        return rExperiencias.existsByNombreE(nombreE);
    }
}
