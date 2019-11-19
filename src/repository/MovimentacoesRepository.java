/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entidade.Conta;
import entidade.Movimentacoes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author brunotrindade
 */
public class MovimentacoesRepository {

    private EntityManager manager;

    public MovimentacoesRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void inserirMovimentacao(Movimentacoes mov) {
        this.manager.getTransaction().begin();
        this.manager.persist(mov);
        this.manager.getTransaction().commit();
    }

    public Movimentacoes consultarPorId(Long id) {
        return this.manager.find(Movimentacoes.class, id);
    }

    public List<Movimentacoes> listarMovimentacoes() {
        Query query = this.manager.createQuery("SELECT c FROM Movimentacoes c");
        return query.getResultList();
    }

    public List<Movimentacoes> listarMovimentacaoes(Long id) {
        Query query = this.manager.createQuery("SELECT c FROM Movimentacoes c WHERE c.conta_mov = " + id);

        return query.getResultList();
    }
}
