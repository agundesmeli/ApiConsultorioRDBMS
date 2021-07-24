package br.com.meli.consultorio_odontologico.service;

import br.com.meli.consultorio_odontologico.entity.Turn;
import br.com.meli.consultorio_odontologico.repository.TurnRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
public class TurnService {

    private TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public List<Turn> getAllFinishedTurns() {
        return turnRepository.findAllFinishedTurns();
    }

    public List<Turn> getAllPendingTurns() {
        return turnRepository.findAllPendingTurns();
    }

    public List<Turn> getPendingTurns(LocalDate day) {
        return turnRepository.findPendingTurns(day);
    }

    public List<Turn> getAllCancelledTurns() {
        return turnRepository.findAllCancelledTurns();
    }

    public List<Turn> getAllRescheduledTurns() {
        return turnRepository.findAllRescheduledTurns();
    }

    public List<Turn> getRescheduledTurns(String name) {
        return turnRepository.findRescheduledTurns(name);
    }


}
