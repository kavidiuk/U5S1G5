package it.epicode.be.U5S1G5;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
public class PrenotazioneService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codiceUnivoco;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    // getter and setter methods
}

public enum TipoPostazione {
    PRIVATO,
    OPENSPACE,
    SALA_RIUNIONI
}

@Entity
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;

}

@Entity
public class Utente {
    @Id
    private String username;

    private String nomeCompleto;
    private String email;

}

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;

    private LocalDate dataPrenotazione;

}
    }

