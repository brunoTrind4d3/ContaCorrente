/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author brunotrindade
 */
@Entity
@Table(name = "contacorrente.movimentacoes")
public class Movimentacoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mov;

    private Integer conta_mov;
    private String tipo_mov;
    private String descricao_mov;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_mov;
    private double valor_mov;
    private String complemento_mov;

    public Long getId_mov() {
        return id_mov;
    }

    public void setId_mov(Long id_mov) {
        this.id_mov = id_mov;
    }

    public Integer getConta_mov() {
        return conta_mov;
    }

    public void setConta_mov(Integer conta_mov) {
        this.conta_mov = conta_mov;
    }

    public String getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public String getDescricao_mov() {
        return descricao_mov;
    }

    public void setDescricao_mov(String descricao_mov) {
        this.descricao_mov = descricao_mov;
    }

    public Date getData_mov() {
        return data_mov;
    }

    public void setData_mov(Date data_mov) {
        this.data_mov = data_mov;
    }

    public double getValor_mov() {
        return valor_mov;
    }

    public void setValor_mov(double valor_mov) {
        this.valor_mov = valor_mov;
    }

    public String getComplemento_mov() {
        return complemento_mov;
    }

    public void setComplemento_mov(String complemento_mov) {
        this.complemento_mov = complemento_mov;
    }

    public Movimentacoes(Integer conta_mov, String tipo_mov, String descricao_mov, Date data_mov, double valor_mov, String complemento_mov) {
        this.conta_mov = conta_mov;
        this.tipo_mov = tipo_mov;
        this.descricao_mov = descricao_mov;
        this.data_mov = data_mov;
        this.valor_mov = valor_mov;
        this.complemento_mov = complemento_mov;
    }

    public Movimentacoes() {
    }
    
     
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "================" + "\nIdentificador= " + id_mov + "\n Conta= " + conta_mov + "\n Tipo= " + tipo_mov + "\n Descricao =" + descricao_mov + "\n Data=" + sdf.format(data_mov) + "\n Valor= " + valor_mov + "\n Complemento=" + complemento_mov+"\n";
    }
    
    
}
