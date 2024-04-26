package br.flores.gustavo.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Email(message = "Email inválido")
    private String email;

    @NotBlank()
    @Pattern(regexp="^\\S*$", message = "O campo username nao pode ter espaço")
    private String username;

    @Length(min = 6, max=100, message = "A senha deve ter no mínimo 6 caracteres")
    private String password;

    private String description;
    private String name;
    private String website;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
