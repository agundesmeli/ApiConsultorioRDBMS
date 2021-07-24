package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Dentist;
import br.com.meli.consultorio_odontologico.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Dentist(d.name, d.lastName, " +
                    "d.address, d.dni, d.birthDate, d.phone, d.email, d.codeMp) " +
                    "FROM Dentist d, Turn t, Diary di " +
                    "WHERE d.id = di.dentist.id " +
                    "AND di.id = t.diary.id " +
                    "AND t.day = :day " +
                    "GROUP BY d.name, d.lastName, d.address, d.dni, d.birthDate, d.phone, d.email, d.codeMp " +
                    "HAVING COUNT(t.id) > 2 ")
    List<Dentist> findAllDentists(LocalDate day);

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Diary(di.startTime, di.endingTime, " +
                    "di.dentist) " +
                    "FROM Diary di " +
                    "WHERE di.dentist.id = :id")
    List<Diary> findDentistDiary(Long id);
}