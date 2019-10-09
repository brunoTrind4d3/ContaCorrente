/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author brunotrindade
 */
public class Conta {

    private Integer idConta;
    private Integer bancoConta;
    private Integer agenciaConta;
    private String numeroConta;
    private Float saldoInicialConta;
    private String situacaoConta;

    public Conta(Integer bancoConta, Integer agenciaConta, String numeroConta, Float saldoInicialConta, String situacaoConta) {
        this.bancoConta = bancoConta;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.saldoInicialConta = saldoInicialConta;
        this.situacaoConta = situacaoConta;
    }

    public Conta() {
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getBancoConta() {
        return bancoConta;
    }

    public void setBancoConta(Integer bancoConta) {
        this.bancoConta = bancoConta;
    }

    public Integer getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(Integer agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Float getSaldoInicialConta() {
        return saldoInicialConta;
    }

    public void setSaldoInicialConta(Float saldoInicialConta) {
        this.saldoInicialConta = saldoInicialConta;
    }

    public String getSituacaoConta() {
        return situacaoConta;
    }

    public void setSituacaoConta(String situacaoConta) {
        this.situacaoConta = situacaoConta;
    }

}
