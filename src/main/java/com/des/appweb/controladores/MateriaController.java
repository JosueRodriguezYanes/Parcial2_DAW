/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.des.appweb.controladores;

import com.des.appweb.entidades.Materia;
import com.des.appweb.negocio.DataServiceMateria;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DOUGLAS
 */
@Named
@RequestScoped
public class MateriaController {
    private List<Materia> materiasList = new ArrayList<>();
    
    private Materia materia = new Materia();
    
    @EJB
    DataServiceMateria servicio;
    
    @PostConstruct
    public void cargarDatos()
    {
        cargarMaterias();
    }
    
    public void cargarMaterias()
    {
        materiasList = servicio.getMaterias();
    }
    
    
    public void guardarMateria()
    {
        if(materia.getId()!=null)
        {
            servicio.editMateria(materia);
        }else{
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }
    
    public void llenarFormEditarMateria(Materia materia)
    {
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo(materia.getCodigo());
    }

    public void eliminarMateria(Materia materia)
    {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }
 
    
    // Getters y Setters
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasLists) {
        this.materiasList = materiasLists;
    }
    

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
