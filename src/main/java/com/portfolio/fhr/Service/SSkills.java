/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Service;

import com.portfolio.fhr.Entity.Skills;
import com.portfolio.fhr.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SSkills {
    @Autowired
    RSkills sskills;
    
    public List<Skills> list(){
        return sskills.findAll();
    }
    
    public Optional<Skills> getone(int id){
        return sskills.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return sskills.findByNombre(nombre);
    }
    
    public void save(Skills skill){
        sskills.save(skill);
    }
    
    public void delete(int id){
        sskills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return sskills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return sskills.existsByNombre(nombre);
    }
}
