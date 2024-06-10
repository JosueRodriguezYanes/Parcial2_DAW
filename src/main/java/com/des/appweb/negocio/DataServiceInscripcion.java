/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.des.appweb.negocio;

import com.des.appweb.entidades.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author DOUGLAS
 */
@Stateless
public class DataServiceInscripcion {
    @PersistenceContext (unitName = "pu")
    EntityManager entityManager;  
    
    public List<Inscripcion> getInscripciones() {
        return entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id DESC", Inscripcion.class).getResultList();
    }

    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }

    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }

    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}