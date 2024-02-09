package it.epicode.be.U5S1G5;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class U5S1G5Application {

	public static void main(String[] args) {
		SpringApplication.run(U5S1G5Application.class, args);
	}

	public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
		List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
		List<Postazione> findByEdificio_Citta(String citta);
	}

	public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	}

	public interface UtenteRepository extends JpaRepository<Utente, String> {
	}

	public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
		List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
	}



}
