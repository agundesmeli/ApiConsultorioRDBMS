package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dentists")
@Data
@NoArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String dni;

    @Column(name = "birth_date")
    private Date birthDate;

    private String phone;

    private String email;

    @Column(name = "code_mp")
    private String codeMp;

    public Dentist(String name, String lastName, String address, String dni, Date birthDate, String phone, String email, String codeMp) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.codeMp = codeMp;
    }
}
