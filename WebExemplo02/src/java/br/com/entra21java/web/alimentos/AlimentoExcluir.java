package br.com.entra21java.web.alimentos;

import br.com.entra21java.dao.AlimentoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */

@WebServlet(urlPatterns = "/alimentos/excluir")
public class AlimentoExcluir extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new AlimentoDAO().excluir(id);
        
        if (apagou) {
            resp.getWriter().print("Apagou com sucesso");
        }else{
            resp.getWriter().print("Não foi possível apagar");
        }
        
    }
    
    
}
