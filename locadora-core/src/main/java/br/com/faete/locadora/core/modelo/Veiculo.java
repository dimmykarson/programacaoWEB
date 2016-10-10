/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.core.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sticdev30
 */
@Entity
@SequenceGenerator(name = "veiculo_seq", sequenceName = "veiculo_seq")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "veiculo_seq")
    private Long id;
    @Column(nullable = false)
    private String placa;
    private String modelo;
    @Column(nullable = false)
    private String chassi;
    private BigDecimal valorAluguelKM;
    private BigDecimal valorAluguelDias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public BigDecimal getValorAluguelKM() {
        return valorAluguelKM;
    }

    public void setValorAluguelKM(BigDecimal valorAluguelKM) {
        this.valorAluguelKM = valorAluguelKM;
    }

    public BigDecimal getValorAluguelDias() {
        return valorAluguelDias;
    }

    public void setValorAluguelDias(BigDecimal valorAluguelDias) {
        this.valorAluguelDias = valorAluguelDias;
    }

}
