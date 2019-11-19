/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author brunotrindade
 */
@Entity
@Table(name = "contacorrente.contas")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;

    private int banco_conta;
    private int agencia_conta;
    private String numero_conta;
    private double saldo_inicial_conta;
    private String situacao_conta;

    public Long getId_conta() {
        return id_conta;
    }

    public void setId_conta(Long id_conta) {
        this.id_conta = id_conta;
    }

    public int getBanco_conta() {
        return banco_conta;
    }

    public void setBanco_conta(int banco_conta) {
        this.banco_conta = banco_conta;
    }

    public int getAgencia_conta() {
        return agencia_conta;
    }

    public void setAgencia_conta(int agencia_conta) {
        this.agencia_conta = agencia_conta;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public double getSaldo_inicial_conta() {
        return saldo_inicial_conta;
    }

    public void setSaldo_inicial_conta(double saldo_inicial_conta) {
        this.saldo_inicial_conta = saldo_inicial_conta;
    }

    public String getSituacao_conta() {
        return situacao_conta;
    }

    public void setSituacao_conta(String situacao_conta) {
        this.situacao_conta = situacao_conta;
    }

    public Conta(int banco_conta, int agencia_conta, String numero_conta, double saldo_inicial_conta, String situacao_conta) {
        this.banco_conta = banco_conta;
        this.agencia_conta = agencia_conta;
        this.numero_conta = numero_conta;
        this.saldo_inicial_conta = saldo_inicial_conta;
        this.situacao_conta = situacao_conta;
    }
    
    public Conta(){}

    public Conta(Long id_conta, int banco_conta, int agencia_conta, String numero_conta, double saldo_inicial_conta, String situacao_conta) {
        this.id_conta = id_conta;
        this.banco_conta = banco_conta;
        this.agencia_conta = agencia_conta;
        this.numero_conta = numero_conta;
        this.saldo_inicial_conta = saldo_inicial_conta;
        this.situacao_conta = situacao_conta;
    }
    
    
}
