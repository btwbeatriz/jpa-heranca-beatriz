package br.com.fiap;

import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
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

        manager.getTransaction().begin();
        List<Pessoa> pessoas = Arrays.asList(beatriz, supermercado);
        pessoas.forEach(manager::persist);
        manager.getTransaction().commit();
        pessoas.forEach(System.out::println);

    }

}