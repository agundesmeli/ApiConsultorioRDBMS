package br.com.meli.consultorio_odontologico.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name")
    private String name;

    private String password;

    @Column(name = "user_status")
    private Boolean status;

    public User(String name, String password, Boolean status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }
}
