/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entidade.Conta;
import entidade.Movimentacoes;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import repository.ContaRepository;
import repository.MovimentacoesRepository;

/**
 *
 * @author brunotrindade
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleBancoJPAPU");
        EntityManager manager = factory.createEntityManager();

        MovimentacoesRepository movimentacao = new MovimentacoesRepository(manager);
        List<Movimentacoes> lista = movimentacao.listarMovimentacoes();
        
        for(Movimentacoes mov: lista){
            System.out.println(mov.getTipo_mov());
        }
    }
}
