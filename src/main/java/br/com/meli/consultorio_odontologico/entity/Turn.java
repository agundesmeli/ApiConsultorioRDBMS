package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turns")
@Data
@NoArgsConstructor
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long id;

    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "id_turn_status")
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "id_diary")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    public Turn(LocalDate day, TurnStatus turnStatus, Diary diary, Patient patient) {
        this.day = day;
        this.turnStatus = turnStatus;
        this.diary = diary;
        this.patient = patient;
    }
}
