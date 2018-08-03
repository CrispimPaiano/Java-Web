package br.com.entra21java.web.alimentos;

import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.dao.AlimentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */

@WebServlet(urlPatterns = "/alimentos/editar")
public class AlimentoEditar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        int id = Integer.parseInt(req.getParameter("id"));
        AlimentoBean alimento = new AlimentoDAO().obterPeloId(id);
        
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alimentos - Editar</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='/alimentos/update' method='post'>");
        out.println("<input type='hidden' name='id' value='"+alimento.getId()+"'>");
        out.println("<div>");
        out.println("<label for='campo-nome'>Nome</label>");
        out.println("<input type='text' id='campo-nome' name='nome' value='"+alimento.getNome()+"'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-quantidade'>Quantidade</label>");
        out.println("<input type='text' id='campo-quantidade' name='quantidade' value='"+alimento.getQuantidade()+"'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-preco'>Preço</label>");
        out.println("<input type='text' id='campo-preco' name='preco' value='"+alimento.getPreco()+"'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-descricao'>Descrição</label>");
        out.println("<textarea id='campo-descricao' cols='30' rows='10' name='descricao' value='"+alimento.getDescricao()+"'>");
        out.println("</textarea>");
        out.println("</div>");
        out.println("<input type='submit' value='Alterar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    
    }    
    
}
