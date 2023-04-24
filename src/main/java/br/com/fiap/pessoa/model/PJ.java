package br.com.fiap.pessoa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PJ")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PJ")
public class PJ extends Pessoa {

    @Column(name = "NR_CNPJ")
    private String CNPJ;

    @Column(name = "NR_IE")
    private String InscricaoEstadual;

    public PJ(Long id, String nome, LocalDate nascimento, String CNPJ, String inscricaoEstadual) {
        super(id, nome, nascimento);
        this.CNPJ = CNPJ;
        InscricaoEstadual = inscricaoEstadual;
    }
    @Override
    public String toString() {
        return "PJ{" +
                "CNPJ='" + CNPJ + '\'' +
                ", InscricaoEstadual='" + InscricaoEstadual + '\'' +
                "} " + super.toString();
    }
}
