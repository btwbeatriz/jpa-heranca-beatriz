package br.com.fiap;

import br.com.fiap.conta.model.Agencia;
import br.com.fiap.conta.model.Conta;
import br.com.fiap.conta.model.ContaCorrente;
import br.com.fiap.conta.model.ContaPoupanca;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
        EntityManager manager = factory.createEntityManager();

        PF beatriz = new PF();
        beatriz.setRG("12345678");
        beatriz.setCPF("12345656789");
        beatriz.setNome("Beatriz Fernandes");
        beatriz.setNascimento(LocalDate.of(1997,6,25));

        var supermercado = new PJ();
        supermercado.setCNPJ("1234326");
        supermercado.setInscricaoEstadual("6546276");
        supermercado.setNascimento(LocalDate.now().minusYears(5));
        supermercado.setNome("SuperBenê");

        Agencia agencia = new Agencia();
        agencia.setNumero(1200);

        ContaCorrente ccBeatriz = new ContaCorrente();
        ccBeatriz.setLimite(1_000_000);
        ccBeatriz.setSaldo(2_000);
        ccBeatriz.setNumero(1234);
        ccBeatriz.setAgencia(agencia);
        ccBeatriz.addTitular(beatriz);

        ContaPoupanca cpBeatriz = new ContaPoupanca();
        cpBeatriz.setAgencia(agencia);
        cpBeatriz.setNumero(9069);
        cpBeatriz.setAniversario(MonthDay.now().getDayOfMonth());
        cpBeatriz.setSaldo(20_000);
        cpBeatriz.addTitular(beatriz);

        ContaCorrente ccSuper = new ContaCorrente();
        ccSuper.setNumero(9999);
        ccSuper.setAgencia(agencia);
        ccSuper.setSaldo(250_000_000);
        ccSuper.setLimite(1_000_000);
        ccSuper.addTitular(supermercado);

        manager.getTransaction().begin();
        List<Pessoa> pessoas = Arrays.asList(beatriz, supermercado);
        pessoas.forEach(manager::persist);

        List<Conta> contas = Arrays.asList(ccBeatriz, ccSuper);
        contas.forEach(manager::persist);

        manager.getTransaction().commit();
        pessoas.forEach(System.out::println);

    }

}