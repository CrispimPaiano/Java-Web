package br.com.entra21.web;

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

@WebServlet(urlPatterns = "/hello")
public class Exemplo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        // Request  -> Requisição: é o que chega para o servidor
        // Response -> Resposta: é o que é retornado para o cliente

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<title>Exercício 01</title>");
        out.println("</head>");
        out.println("	<body>");
        out.println("<h1>《《《《 olá novinhas 》》》》");
        out.println("		<h1>Olá mundo</h1>");
        out.println("		<form action='Somar' method='post'>");
        out.println("			<label>Número 01</label>");
        out.println("			<input type='number' name='numero-01'>");
        out.println("			<label>Número 02</label>");
        out.println("			<input type='number' name='numero-02'>");
        out.println("			<input type='submit' name='Calcular'>");
        out.println("		</form>");
        out.println("	</body>");
        out.println("</html>");
        
    }
    
}
