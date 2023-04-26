package br.com.fiap.conta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaPoupanca extends Conta{

    private Integer aniversario;
}
