/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import dao.ClientDAO;
import entity.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 26134
 */
@WebServlet("/")
public class ClientServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private ClientDAO clientDAO;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
        @Override
        public void init() {
            clientDAO = new ClientDAO();
        }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doGet(request, response);
        }
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String action = request.getServletPath();
            
            
            try {
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        insertClient(request, response);
                        break;
                    case "/delete":
                        deleteClient(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/update":
                        updateClient(request, response);
                        break;
                    default:
                        listClient(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
        
        
        private void listClient(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
                List <Client> listClient = clientDAO.selectAllClient();
                request.setAttribute("listClient", listClient);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list_Client.jsp");
                dispatcher.forward(request, response);
        }
        
        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("client_form.jsp");
            dispatcher.forward(request, response);
        }
        
        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            Client existingClient = clientDAO.selectClient(idClient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("client_form.jsp");
            request.setAttribute("client", existingClient);
            dispatcher.forward(request, response);
        }
        
        
        private void insertClient(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException{
            int idClient = 0;
            String nomClient = request.getParameter("nomClient");
            String prenomClient = request.getParameter("prenomClient");
            String sexeClient = request.getParameter("sexeClient");
            String situationMatClient = request.getParameter("situationMatClient");
            String adresseClient = request.getParameter("adresseClient");
            String telephoneClient = request.getParameter("telephoneClient");
            String emailClient = request.getParameter("emailClient");
            Client newClient = new Client(idClient,nomClient,prenomClient,sexeClient,adresseClient,situationMatClient,telephoneClient,emailClient);
            clientDAO.insertClient(newClient);
            response.sendRedirect("list");
        }
        
        private void updateClient(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
            int  idClient = Integer.parseInt(request.getParameter("idClient"));
            String nomClient = request.getParameter("nomClient");
            String prenomClient = request.getParameter("prenomClient");
            String sexeClient = request.getParameter("sexeClient");
            String situationMatClient = request.getParameter("situationMatClient");
            String adresseClient = request.getParameter("adresseClient");
            String telephoneClient = request.getParameter("telephoneClient");
            String emailClient = request.getParameter("emailClient");
            
            Client book = new Client(idClient,nomClient,prenomClient,sexeClient,adresseClient,situationMatClient,telephoneClient,emailClient);
            clientDAO.updateClient(book);
            response.sendRedirect("list");
        }
        
        private void deleteClient(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
            int  idClient = Integer.parseInt(request.getParameter("idClient"));
            clientDAO.deleteClient(idClient);
            response.sendRedirect("list");
        }
  
}
