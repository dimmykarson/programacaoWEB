/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.bo;

import br.com.faete.locadora.core.modelo.Veiculo;
import br.com.faete.locadora.dao.VeiculoDAO;
import br.com.faete.locadora.exceptions.ValidacaoException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ValidationException;

/**
 *
 * @author sticdev30
 */
@Stateless
public class VeiculoBO {

    @EJB
    private VeiculoDAO veiculoDAO;

    public void salvarVeiculo(Veiculo veiculo) throws ValidacaoException {

        if (veiculo == null) {
            throw new ValidacaoException("Veículo não pode ser nulo");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            throw new ValidacaoException("Informe o modelo do veículo");
        }
        Veiculo aux = (Veiculo) veiculoDAO.unique("placa", veiculo.getPlaca());
        if (aux != null) {
            throw new ValidacaoException(""
                    + "Já existe um veículo com esta placa no banco de dados");
        }
        aux = (Veiculo) veiculoDAO.unique("chassi", veiculo.getChassi());
        if (aux != null) {
            throw new ValidacaoException(""
                    + "Já existe um veículo com este chassi no banco de dados");
        }
        veiculoDAO.save(veiculo);
    }

    public VeiculoDAO getVeiculoDAO() {
        return veiculoDAO;
    }

}
