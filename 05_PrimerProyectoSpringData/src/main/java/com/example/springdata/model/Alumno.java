package com.example.springdata.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

@NoArgsConstructor
//@Getter  @Setter  @EqualsAndHashCode
/*Si se usan las tres de arriba mejor sustituir por @Data*/
@Data

@AllArgsConstructor
@Builder //Se basa en el constructor de la clase (si no lo tiene, usa el de todos los
        //atributos y permite crear un nuevo objeto con su método builder().

public class Alumno implements Serializable {
                //no es obligatorio pero ayuda a asegurar que funcione en un futuro
    @Id
    @GeneratedValue//(generator = ) podemos pasarle nosotros nuestra propia forma de generar el id
                    //@SequenceGenerator()
    private Long id;


    private String nombre, apellido, email;






}
