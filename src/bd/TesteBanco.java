/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import persistencia.PersistenciaConta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conta;

/**
 *
 * @author brunotrindade
 */
public class TesteBanco {

    public static void main(String[] args) {
        try {
            List<Conta> listaContas;
            PersistenciaConta contaOBdc = new PersistenciaConta();

            listaContas = contaOBdc.listarConta();
            listaContas.forEach((conta) -> {
                System.out.println("Id: " + conta.getIdConta()+","+ " Numero: " + conta.getNumeroConta());
            });
        } catch (Exception ex) {
            Logger.getLogger(TesteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
