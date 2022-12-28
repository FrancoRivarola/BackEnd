/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.fhr.Repository;

import com.portfolio.fhr.Entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer>{
    public Optional<AcercaDe> findByDescripcion(String descripcion);
    public boolean existsByDescripcion(String descripcion);
}
