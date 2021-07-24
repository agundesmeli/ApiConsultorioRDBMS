package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Patient(p.name, " +
                    "p.lastName, p.address, p.dni, p.birthDate, p.phone, p.email) " +
                    "FROM Patient p, Turn t " +
                    "WHERE p.id = t.patient.id "+
                    "AND t.turnStatus.id = 1 " +
                    "AND t.day = :day ")
    List<Patient> findAllPatients(LocalDate day);

}