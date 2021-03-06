/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Profesor
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet { 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        //Obtener datos para el registro
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("password");
        Integer edad = Integer.parseInt(request.getParameter("edad"));
        String experiencia = request.getParameter("user_bio");
        String especialidad = request.getParameter("especialidad");
        String interes = request.getParameter("interes");
        
        //Crear un objeto Perfil
        paq.Perfil nuevo = new paq.Perfil(nombre, correo, clave, edad, experiencia, especialidad, interes);
        
        //Insertar un registro de Perfil en la BD
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.18.87.76:3306/academico","maq9", "maq9");
            paq.UtileriasBD.registroPerfil(nuevo,con);
	} 
	catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
	}
        
        //Debe desplegar el contenido de la tabla

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos de registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Nombre " + nombre + "</h2>");
            out.println("<h2>Correo " + correo + "</h2>");
            out.println("<h2>Clave " + clave + "</h2>");
            out.println("<h2>Edad " + edad + "</h2>");
            out.println("<h2>Experiencia " + experiencia + "</h2>");
            out.println("<h2>Especialidad " + especialidad + "</h2>");
            out.println("<h2>Interes " + interes + "</h2>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
