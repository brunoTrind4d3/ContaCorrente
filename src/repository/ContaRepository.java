/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entidade.Conta;
import java.util.ArrayList;

/**
 *
 * @author brunotrindade
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContaRepository {

    private EntityManager manager;

    public ContaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void inserirConta(Conta e) {
        this.manager.getTransaction().begin();
        this.manager.persist(e);
        this.manager.getTransaction().commit();
    }
    public void alterarConta(Conta e) {
        this.manager.getTransaction().begin();
        this.manager.merge(e);
        this.manager.getTransaction().commit();
    }
    public Conta consultarPorId(Long id) {
        return this.manager.find(Conta.class, id);
    }

    public List<Conta> buscarTodas() {
        Query query = this.manager.createQuery("SELECT c FROM Conta c");
        return query.getResultList();
    }
}
