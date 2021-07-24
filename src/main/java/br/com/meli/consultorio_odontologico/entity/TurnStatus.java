package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "turn_status")
@Data
@NoArgsConstructor
public class TurnStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn_status")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TurnStatusEnum name;

    private String description;

    public TurnStatus(TurnStatusEnum name, String description) {
        this.name = name;
        this.description = description;
    }
}
