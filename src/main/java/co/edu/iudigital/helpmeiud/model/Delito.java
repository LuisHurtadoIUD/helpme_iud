package co.edu.iudigital.helpmeiud.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "delitos")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column
    String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;
}
/*
CREATE TABLE delitos (
    id int auto_increment not null,
    nombre varchar(255) not null,
    descripcion varchar(255) null,
    usuarios_id int not null,
    PRIMARY KEY(id),
    FOREIGN KEY (usuarios_id) REFERENCES usuarios(id)
);


 */
