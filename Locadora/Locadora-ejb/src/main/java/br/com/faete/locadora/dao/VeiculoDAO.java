/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.dao;

import br.com.faete.locadora.core.modelo.Veiculo;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class VeiculoDAO extends BaseDAO {

    @Override
    public Class getClassUnit() {
        return Veiculo.class;
    }

}
