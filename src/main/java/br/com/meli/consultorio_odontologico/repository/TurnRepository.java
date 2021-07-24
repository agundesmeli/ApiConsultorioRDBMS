package br.com.meli.consultorio_odontologico.repository;

import br.com.meli.consultorio_odontologico.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'CONCLUIDO'")
    List<Turn> findAllFinishedTurns();

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'PENDENTE'")
    List<Turn> findAllPendingTurns();

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'PENDENTE'" +
                    "AND t.day = :day")
    List<Turn> findPendingTurns(LocalDate day);

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'CANCELADO'")
    List<Turn> findAllCancelledTurns();

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'REMARCADO'")
    List<Turn> findAllRescheduledTurns();

    @Query(
            value = "SELECT new br.com.meli.consultorio_odontologico.entity.Turn(t.day, t.turnStatus, " +
                    "t.diary, t.patient)" +
                    "FROM Turn t " +
                    "WHERE t.turnStatus.name = 'REMARCADO'" +
                    "AND t.diary.dentist.name = :name ")
    List<Turn> findRescheduledTurns(String name);

}
