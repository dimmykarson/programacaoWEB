/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.core.modelo.enuns;

/**
 *
 * @author sticdev30
 */
public enum TipoPagamento {
    AVISTA("À vista"), CHEQUE("Cheque"), CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de débito");

    private String descricao;

    private TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
