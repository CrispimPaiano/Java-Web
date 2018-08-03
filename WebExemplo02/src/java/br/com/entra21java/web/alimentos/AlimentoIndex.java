package br.com.entra21java.web.alimentos;

import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.dao.AlimentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */
@WebServlet(urlPatterns = "/alimentos")
public class AlimentoIndex extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<AlimentoBean> alimentos = new AlimentoDAO().obterTodos();
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alimentos - Lista</title>");
        out.println("<link rel='stylesheet' type='text/css' href='alimentos-index.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Lista de Alimentos</h3>");
        out.println("<a href='/WebExemplo02/alimentos/cadastro' class='botao-cadastro'>Novo Alimento</a>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Quantidade</th>");
        out.println("<th>Preço</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        for(AlimentoBean alimento: alimentos){
            out.println("<tr>");
            out.println("<th>"+alimento.getId()+"</th>");
            out.println("<th>"+alimento.getNome()+"</th>");
            out.println("<th>"+alimento.getQuantidade()+"</th>");
            out.println("<th>"+alimento.getPreco()+"</th>");
            out.println("<th>");
            
            out.println("<a href='/WebExemplo02/alimentos/editar?id="+alimento.getId()+"' class='botao-editar'>Editar</a>");
            out.println("<a href='/WebExemplo02/alimentos/excluir?id="+alimento.getId()+"' class='botao-excluir'>Excluir</a>");
            
            out.println("</th>");
            out.println("</tr>");
        }
        
        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Quantidade</th>");
        out.println("<th>Preço</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
}
