package com.des.appweb.entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    private Integer id;

    @OneToMany
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne 
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

    @Column(name = "ciclo")
    private String ciclo;

    @Column(name = "año")
    private String año;

    @Column(name = "fechaInscripcion")
    @Temporal(TemporalType.DATE)
    private Date  fechaInscripcion;

    public Inscripcion(Integer id, Alumno alumno, Materia materia, String ciclo, String año, Date fechaInscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.año = año;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion() {
    }


    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (!Objects.equals(this.ciclo, other.ciclo)) {
            return false;
        }
        if (!Objects.equals(this.año, other.año)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.materia, other.materia)) {
            return false;
        }
        return Objects.equals(this.fechaInscripcion, other.fechaInscripcion);
    }

    
    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", alumno=" + alumno +
                ", materia=" + materia +
                ", ciclo='" + ciclo + '\'' +
                ", año=" + año +
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }
}
