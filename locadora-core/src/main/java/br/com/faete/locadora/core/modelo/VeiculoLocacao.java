/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.core.modelo;

import br.com.faete.locadora.core.modelo.enuns.TipoLocacao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sticdev30
 */
@Entity
@SequenceGenerator(name = "veiculo_locacao_seq", sequenceName = "veiculo_locacao_seq")
public class VeiculoLocacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "veiculo_locacao_seq")
    private Long id;
    private Date dataLocacao;
    private Date dataDevolucao;
    private BigDecimal quilometragemInicio;
    private BigDecimal quilometragemFim;
    @Enumerated(EnumType.STRING)
    private TipoLocacao tipoLocacao;
    private BigDecimal valorLocacao;
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Locacao locacao;

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getQuilometragemInicio() {
        return quilometragemInicio;
    }

    public void setQuilometragemInicio(BigDecimal quilometragemInicio) {
        this.quilometragemInicio = quilometragemInicio;
    }

    public BigDecimal getQuilometragemFim() {
        return quilometragemFim;
    }

    public void setQuilometragemFim(BigDecimal quilometragemFim) {
        this.quilometragemFim = quilometragemFim;
    }

    public TipoLocacao getTipoLocacao() {
        return tipoLocacao;
    }

    public void setTipoLocacao(TipoLocacao tipoLocacao) {
        this.tipoLocacao = tipoLocacao;
    }

    public BigDecimal getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(BigDecimal valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
