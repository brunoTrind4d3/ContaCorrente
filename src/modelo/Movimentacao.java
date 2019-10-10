/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author brunotrindade
 */
public class Movimentacao {

    private Integer idMovimentacao;
    private Integer contaMovimentacao;
    private String tipoMovimentacao;
    private String descricaoMovimentacao;
    private Date dataMovimentacao;
    private Float valorMovimentacao;
    private String complementoMovimentacao;

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Integer getContaMovimentacao() {
        return contaMovimentacao;
    }

    public void setContaMovimentacao(Integer contaMovimentacao) {
        this.contaMovimentacao = contaMovimentacao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getDescricaoMovimentacao() {
        return descricaoMovimentacao;
    }

    public void setDescricaoMovimentacao(String descricaoMovimentacao) {
        this.descricaoMovimentacao = descricaoMovimentacao;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Float getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(Float valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public String getComplementoMovimentacao() {
        return complementoMovimentacao;
    }

    public void setComplementoMovimentacao(String complementoMovimentacao) {
        this.complementoMovimentacao = complementoMovimentacao;
    }

    public Movimentacao(Integer contaMovimentacao, String tipoMovimentacao, String descricaoMovimentacao, Date dataMovimentacao, Float valorMovimentacao, String complementoMovimentacao) {
        this.contaMovimentacao = contaMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.descricaoMovimentacao = descricaoMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.complementoMovimentacao = complementoMovimentacao;
    }

    public Movimentacao() {
    }

}
