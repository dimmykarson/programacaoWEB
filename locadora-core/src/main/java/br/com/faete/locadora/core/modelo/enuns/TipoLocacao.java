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
public enum TipoLocacao {
    PORTEMPO("Por dias locados"), PORKMRODADOS("Por quilometros rodados");
    private String descricao;

    private TipoLocacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
