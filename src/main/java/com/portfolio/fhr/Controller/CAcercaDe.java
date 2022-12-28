/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Controller;

import com.portfolio.fhr.Dto.DtoAcercaDe;
import com.portfolio.fhr.Entity.AcercaDe;
import com.portfolio.fhr.Security.Controller.Mensaje;
import com.portfolio.fhr.Service.SAcercaDe;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acerca")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendprueba-e3ee5.web.app", "https://francorivarola.tech"})
public class CAcercaDe {
    @Autowired
    SAcercaDe sAcercaDe;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list(){
        List<AcercaDe> list = sAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id") int id){
        if (!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("Descripcion no existe"), HttpStatus.NOT_FOUND);
        }
        
        AcercaDe acercaDe = sAcercaDe.getone(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        sAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("Descripcion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAcercaDe dtoacercaDe){
        if (StringUtils.isBlank(dtoacercaDe.getDescripcion())){
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }
                    
        AcercaDe acercaDe = new AcercaDe(dtoacercaDe.getDescripcion());
        sAcercaDe.save(acercaDe);
            return new ResponseEntity(new Mensaje("Descripcion Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoAcercaDe dtoacercaDe){
        if (!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoacercaDe.getDescripcion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = sAcercaDe.getone(id).get();
        
        acercaDe.setDescripcion(dtoacercaDe.getDescripcion());
        
        sAcercaDe.save(acercaDe);
        
        return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
    }
}