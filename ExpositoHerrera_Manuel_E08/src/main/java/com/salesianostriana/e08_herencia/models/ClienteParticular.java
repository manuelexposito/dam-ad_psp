package com.salesianostriana.e08_herencia.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@SuperBuilder

public class ClienteParticular extends Cliente implements Serializable {


}
