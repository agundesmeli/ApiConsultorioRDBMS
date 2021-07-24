package br.com.meli.consultorio_odontologico;

import br.com.meli.consultorio_odontologico.entity.Patient;
import br.com.meli.consultorio_odontologico.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class ConsultorioOdontologicoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConsultorioOdontologicoApplication.class, args);

    }

}
