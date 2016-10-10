/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.servlets.veiculo;

import br.com.faete.locadora.bo.VeiculoBO;
import br.com.faete.locadora.core.modelo.Veiculo;
import br.com.faete.locadora.exceptions.ValidacaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sticdev30
 */
@WebServlet("/veiculo")
public class VeiculoServlet3 extends HttpServlet {

    @EJB
    private VeiculoBO veiculoBO;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("listar") != null
                && !request.getParameter("listar").isEmpty()) {
            listar(request, response);
        } else if (request.getParameter("salvar") != null
                && !request.getParameter("salvar").isEmpty()) {
            salvar(request, response);
        }

    }

    private void salvar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String modelo = request.getParameter("modelo");
        String placa = request.getParameter("placa");
        String chassi = request.getParameter("chassi");
        BigDecimal valor1 = BigDecimal.ZERO;
        BigDecimal valor2 = BigDecimal.ZERO;
        boolean erro = false;
        try {
            String valorPorKM = request.getParameter("valorKM");
            String valorPorDia = request.getParameter("valorDia");
            valor1 = BigDecimal.valueOf(Double.valueOf(valorPorKM));
            valor2 = BigDecimal.valueOf(Double.valueOf(valorPorDia));
        } catch (Exception ex) {
            erro = true;
        }
        if (modelo == null || modelo.isEmpty()) {
            erro = true;
        }
        if (placa == null || placa.isEmpty()) {
            erro = true;
        }

        if (chassi == null || chassi.isEmpty()) {
            erro = true;
        }
        if (!erro) {
            Veiculo veiculo = new Veiculo();
            veiculo.setModelo(modelo);
            veiculo.setPlaca(placa);
            veiculo.setChassi(chassi);
            veiculo.setValorAluguelKM(valor1);
            veiculo.setValorAluguelDias(valor2);

            try {
                veiculoBO.salvarVeiculo(veiculo);
                PrintWriter out = response.getWriter();
                out.println("<html><body>Veículo cadastrado com sucesso!</body></html>");
            } catch (ValidacaoException | IOException ex) {
                PrintWriter out = response.getWriter();
                out.println("<html><body>" + ex.getMessage() + "</body></html>");
            }
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>Veículo não cadastrado!</body></html>");
        }

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Veiculo> veiculos = veiculoBO.getVeiculoDAO().listAll();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Veiculos cadastrados</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Modelo</th>"
                + "<th>Placa</th>"
                + "<th>Chassi</th>"
                + "<th>Valor p KM</th>"
                + "<th>Valor p Dia</th>");
        out.println("</tr>");

        for (Veiculo v : veiculos) {
            out.println("<tr>");
            out.println("<td>" + v.getModelo() + "</td>"
                    + "<td>" + v.getPlaca() + "</td>"
                    + "<td>" + v.getChassi() + "</td>"
                    + "<td>" + v.getValorAluguelKM() + "</td>"
                    + "<td>" + v.getValorAluguelDias() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");

        out.println("</html>");
    }

}
