package com.salesianostriana.Apuntes_Service.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notas {

    @EmbeddedId
    private NotasPK id = new NotasPK();

    private int primeraEv;
    private int segundaEv;
    private int terceraEv;
    private int notaFinal;


    @ManyToOne
    @MapsId("asignaturaId")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne
    @MapsId("alumnoId")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;


    //HELPERS

    public void addToAlumno(Alumno a) {

        this.alumno = a;
        a.getNotas().add(this);
    }

    public void removeFromAlumno(Alumno a) {

        a.getNotas().remove(this);
        this.alumno = null;
    }

    public void addToAsignatura(Asignatura a) {

        this.asignatura = a;
        a.getNotas().add(this);
    }

    public void removeFromAsignatura(Asignatura a) {

        a.getNotas().remove(this);
        this.asignatura = null;
    }


}
