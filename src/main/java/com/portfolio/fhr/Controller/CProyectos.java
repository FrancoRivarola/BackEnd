/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Controller;

import com.portfolio.fhr.Dto.DtoProyectos;
import com.portfolio.fhr.Entity.Proyectos;
import com.portfolio.fhr.Security.Controller.Mensaje;
import com.portfolio.fhr.Service.SProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendprueba-e3ee5.web.app", "https://francorivarola.tech"})
//@CrossOrigin(origins = "https://frontendprueba-e3ee5.web.app")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getbyId(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        
        Proyectos proyectos = sProyectos.getone(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //if (sProyectos.existsByNombre(dtoproyectos.getNombre())) {
            //return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //}

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombre(), dtoproyectos.getDescripcion());
        sProyectos.save(proyectos);
            return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproyectos) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }

        //if (sProyectos.existsByNombre(dtoproyectos.getNombre()) && sProyectos.getByNombre(dtoproyectos.getNombre()).get().getId() != id) {
            //return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //}

        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = sProyectos.getone(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());

        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);

    }
}
