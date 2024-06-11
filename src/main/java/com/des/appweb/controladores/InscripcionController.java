package com.des.appweb.controladores;

import com.des.appweb.entidades.Alumno;
import com.des.appweb.entidades.Inscripcion;
import com.des.appweb.entidades.Materia;
import com.des.appweb.negocio.DataService;
import com.des.appweb.negocio.DataServiceMateria;
import com.des.appweb.negocio.DataServiceInscripcion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class InscripcionController {

    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private Inscripcion inscripcion = new Inscripcion();
    private List<Alumno> alumnosList = new ArrayList<>();
    private List<Materia> materiasList = new ArrayList<>();

    @EJB
    DataServiceInscripcion inscripcionService;

    @EJB
    DataService dataService;

    @EJB
    DataServiceMateria dataServiceMateria;

    @PostConstruct
    public void cargarDatos() {
        cargarInscripciones();
        cargarAlumnos();
        cargarMaterias();
    }

    public void cargarInscripciones() {
        inscripcionesList = inscripcionService.getInscripciones();
    }

    public void cargarAlumnos() {
        alumnosList = dataService.getAlumnos();
    }

    public void cargarMaterias() {
        materiasList = dataServiceMateria.getMaterias();
    }

     
    
    public void guardarInscripcion() {
        // Establece la fecha de inscripción como la fecha actual
        inscripcion.setFechaInscripcion(Calendar.getInstance().getTime());   
        
        if (inscripcion == null) {
            inscripcion = new Inscripcion();
        }

        // Obtener el alumno y la materia seleccionados
        Alumno alumno = dataService.findAlumnoById(inscripcion.getAlumno().getId());
        Materia materia = dataServiceMateria.findMateriaById(inscripcion.getMateria().getId());

        // Verificar que no sean nulos
        if (alumno == null || materia == null) {
            return;
        }

        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);
        
        inscripcionService.saveInscripcion(inscripcion);
        
        inscripcion = new Inscripcion();
        cargarInscripciones();
    }

    // Getters y setters
    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }
}
