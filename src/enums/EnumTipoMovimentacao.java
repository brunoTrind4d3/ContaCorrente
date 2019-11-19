/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author brunotrindade
 */
public enum EnumTipoMovimentacao {

    SAQUE("s"), DEPOSITO("d");
    
    private final String valor;

    EnumTipoMovimentacao(String valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return valor;
    }
}
