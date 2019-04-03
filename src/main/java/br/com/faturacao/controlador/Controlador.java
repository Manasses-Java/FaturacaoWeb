package br.com.faturacao.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manases
 * @param <T>
 */
public abstract class Controlador <T,J> extends ControladorImpl <T,J>  {
    
    private String acao;
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            acao = request.getParameter("acao");
            
            if (acao.equalsIgnoreCase(AcaoControlador.CADASTRAR.getAcao())) {
                this.cadastrar(request, response);
            } else if (acao.equals(AcaoControlador.CARREGAR.getAcao())) {
                this.carregar(request, response);
            } else if (acao.equals(AcaoControlador.DELETAR.getAcao())) {
                this.deletar(request, response);
            } else if (acao.equals(AcaoControlador.EDITAR.getAcao())) {
                this.editar(request, response);
            } else if (acao.equals(AcaoControlador.LISTAR.getAcao())) {
                this.listar(request, response);
            }
        } catch (Exception e) {
//            throw new Exception();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}