package tech.ada.combustivel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    public Usuario() {
        dataCriacao = LocalDateTime.now();
    }

}
