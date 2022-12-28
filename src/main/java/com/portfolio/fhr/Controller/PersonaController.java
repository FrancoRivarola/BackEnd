/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Controller;

import com.portfolio.fhr.Dto.DtoPersona;
import com.portfolio.fhr.Entity.Persona;
import com.portfolio.fhr.Security.Controller.Mensaje;
import com.portfolio.fhr.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendprueba-e3ee5.web.app", "https://francorivarola.tech"})
//@CrossOrigin(origins = "https://frontendprueba-e3ee5.web.app")
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if (!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("Persona no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getone(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }*/
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){
        if (StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //if (personaService.existsByNombre(dtopersona.getNombre())){
            //return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        //}
            
        Persona educacion = new Persona(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE());
        personaService.save(educacion);
            return new ResponseEntity(new Mensaje("Persona Agregada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoPersona dtopersona){
        if (!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        //if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId()!= id){
            //return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        //}
        if (StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getone(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
