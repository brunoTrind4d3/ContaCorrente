/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

public enum EnumBanco {

    ITAU(1), SANTANDER(2), BRADESCO(3), CAIXA(4), SICOOB(5);
    
    private final int valor;

    EnumBanco(int valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return valor;
    }

}
