package br.com.meli.consultorio_odontologico.controller;

import br.com.meli.consultorio_odontologico.service.DentistService;
import br.com.meli.consultorio_odontologico.service.PatientService;
import br.com.meli.consultorio_odontologico.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

    private PatientService patientService;
    private DentistService dentistService;
    private TurnService turnService;

    public ConsultorioController() {
    }

    @Autowired
    public ConsultorioController(PatientService patientService, DentistService dentistService, TurnService turnService) {
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.turnService = turnService;
    }

    @GetMapping("/patients/{day}")
    public ResponseEntity<?> getAllPatients(@PathVariable String day) {
        return ResponseEntity.ok().body(patientService.getAllPatientsOfTheDay(LocalDate.parse(day)));
    }

    @GetMapping("/dentists/{day}")
    public ResponseEntity<?> getAllDentists(@PathVariable String day) {
        return ResponseEntity.ok().body(dentistService.getAllDentists(LocalDate.parse(day)));
    }

    @GetMapping("/dentist/{id}")
    public ResponseEntity<?> getDentistDiary(@PathVariable Long id) {
        return ResponseEntity.ok().body(dentistService.getDentistDiary(id));
    }

    @GetMapping("/turns/finished")
    public ResponseEntity<?> getAllFinishedTurns() {
        return ResponseEntity.ok().body(turnService.getAllFinishedTurns());
    }

    @GetMapping("/turns/pending")
    public ResponseEntity<?> getAllPendingTurns() {
        return ResponseEntity.ok().body(turnService.getAllPendingTurns());
    }

    @GetMapping("/turns/pending/{day}")
    public ResponseEntity<?> getPendingTurns(@PathVariable String day) {
        return ResponseEntity.ok().body(turnService.getPendingTurns(LocalDate.parse(day)));
    }

    @GetMapping("/turns/cancelled")
    public ResponseEntity<?> getAllCancelledTurns() {
        return ResponseEntity.ok().body(turnService.getAllCancelledTurns());
    }

    @GetMapping("/turns/rescheduled")
    public ResponseEntity<?> getAllRescheduledTurns() {
        return ResponseEntity.ok().body(turnService.getAllRescheduledTurns());
    }

    @GetMapping("/turns/rescheduled/{name}")
    public ResponseEntity<?> getRescheduledTurns(@PathVariable String name) {
        return ResponseEntity.ok().body(turnService.getRescheduledTurns(name));
    }

}
