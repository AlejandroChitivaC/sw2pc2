package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Equipo.
 */
@Getter
@Setter
@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @Column(name = "id_equipo", nullable = false)
    private Integer id;

    //TODO [JPA Buddy] generate columns from DB
}