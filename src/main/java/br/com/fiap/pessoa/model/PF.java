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
@Table(name = "TB_PF")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PF")
public class PF extends Pessoa {

    @Column(name = "NR_CPF")
    private String CPF;

    @Column(name = "NR_RG")
    private String RG;

    public PF(Long id, String nome, LocalDate nascimento, String CPF, String RG) {
        super(id, nome, nascimento);
        this.CPF = CPF;
        this.RG = RG;
    }
    @Override
    public String toString() {
        return "PF{" +
                "CPF='" + CPF + '\'' +
                ", RG='" + RG + '\'' +
                "} " + super.toString();
    }
}
