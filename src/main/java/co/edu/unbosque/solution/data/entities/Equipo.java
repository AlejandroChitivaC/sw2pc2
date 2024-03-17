package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipo", schema = "bd_sw2pc2")
public class Equipo {
    @Id
    @Column(name = "id_equipo", nullable = false)
    private Integer id;

}