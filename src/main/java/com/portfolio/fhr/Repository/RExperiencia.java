/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.fhr.Repository;

import com.portfolio.fhr.Entity.Experiencias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencias, Integer>{
    public Optional<Experiencias> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
