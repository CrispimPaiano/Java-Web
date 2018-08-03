/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(urlPatterns = "/Somar")
public class Calcular extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        // Name do input
        int numero01 = Integer.parseInt(req.getParameter("numero-01"));
        int numero02 = Integer.parseInt(req.getParameter("numero-02"));
        int soma = numero01 + numero02;
        
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head><body>");
        out.print("<h3>A soma é: "+soma+"</h3>");
        out.println("</body></html>");
        
    }
    
}
