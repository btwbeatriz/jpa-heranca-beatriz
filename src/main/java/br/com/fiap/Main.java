package br.com.fiap;

import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;

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
        Arrays.asList(beatriz, supermercado).forEach(manager::persist);
        manager.getTransaction().commit();

    }

}