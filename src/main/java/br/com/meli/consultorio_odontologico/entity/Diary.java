package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diarys")
@Data
@NoArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "ending_time")
    private LocalDateTime endingTime;

    @JoinColumn(name = "id_dentist")
    @ManyToOne
    private Dentist dentist;

    public Diary(LocalDateTime startTime, LocalDateTime endingTime, Dentist dentist) {
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
    }
}
