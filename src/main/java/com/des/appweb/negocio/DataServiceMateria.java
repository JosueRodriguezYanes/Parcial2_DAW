/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.des.appweb.negocio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import com.des.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


/**
 *
 * @author DOUGLAS
 */

@Stateless
public class DataServiceMateria {
     @PersistenceContext (unitName = "pu")
    EntityManager entityManager;  
    
    public List<Materia> getMaterias(){
        
        Query query = entityManager.createQuery("Select e FROM Materia e ORDER BY e.id DESC");
        
        List<Materia> materias = query.getResultList();
        
        return materias;
    }
    
    
    @Transactional
    public void saveMateria(Materia materia){
        entityManager.persist(materia);
    }
    
    @Transactional
    public void editMateria(Materia materia){
        entityManager.merge(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia){
      Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
      entityManager.remove(materiaEliminar);
    }
    
}
