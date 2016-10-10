/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.core.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author sticdev30
 */
@Entity
@SequenceGenerator(name = "locacao_seq", sequenceName = "locacao_seq")
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "locacao_seq")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locacao")
    private List<VeiculoLocacao> veiculosLocados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locacao")
    private List<Pagamento> pagamentos;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VeiculoLocacao> getVeiculosLocados() {
        return veiculosLocados;
    }

    public void setVeiculosLocados(List<VeiculoLocacao> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
