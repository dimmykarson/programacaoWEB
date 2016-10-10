/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.core.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sticdev30
 */
@Entity
@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "funcionario_seq")
    private Long id;
    @Column(nullable = false)
    private String CPF;
    private String nome;
    private String endereco;
    private String telefone;
    @OneToMany(mappedBy = "funcionario")
    private List<Locacao> locacoesRealizadas;

    public List<Locacao> getLocacoesRealizadas() {
        return locacoesRealizadas;
    }

    public void setLocacoesRealizadas(List<Locacao> locacoesRealizadas) {
        this.locacoesRealizadas = locacoesRealizadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
