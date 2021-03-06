/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.ClienteService;
import Modelo.ModeloService;
import Modelo.VehiculoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brian Gomez
 */
public class Controlador extends HttpServlet {

    String add = "add.jsp";
    String edit = "edit.jsp";
    String index = "index.jsp";
    String delete = "detele.jsp";
    String vehiculo = "Vehiculo.jsp";
    String modelo = "Modelo.jsp";
    String addM = "addM.jsp";
    String addV = "addV.jsp";
    String editM = "editM.jsp";
    String editV = "editV.jsp";
    String vehiculoN = "VehiculoN.jsp";
    String acceso = "";
    ClienteService cliente = new ClienteService();
    ModeloService modeloC = new ModeloService();
    VehiculoService vehiculoC = new VehiculoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equals("add")) {
            acceso = add;
        }
        if (accion.equals("modelo")) {
            acceso = modelo;
        } 
        
        if (accion.equals("addM")) {
            acceso = addM;
        }
        
        if (accion.equals("addV")) {
            acceso = addV;
        }
        
        if (accion.equals("vehiculoN")) {
            acceso = vehiculoN;
        }
        else if (accion.equals("vehiculo")) {
            acceso = vehiculo;
   
            
        } else if (accion.equals("index")) {
            acceso = index;
        } else if (accion.equals("Guardar")) {
            String Nombre = request.getParameter("txtNom");
            String Apellido = request.getParameter("txtApe");
            String Telefono = request.getParameter("txtTel");

            cliente.agregar(Nombre, Apellido, Telefono);
            acceso = index;
        }
        
        else if (accion.equals("Guardar Modelo")) {
            String Nombre = request.getParameter("txtNom");
            String Descripcion = request.getParameter("txtDes");

            modeloC.agregarModelo(Nombre, Descripcion);
            acceso = index;
        }
        
        else if (accion.equals("Guardar Vehiculo")) {
            String Nombre = request.getParameter("txtNom");
            String Descripcion = request.getParameter("txtDes");

            vehiculoC.agregarVehiculo(Nombre, Descripcion);
            acceso = index;
        }
        else if (accion.equals("editar")) {
            acceso = edit;
            request.setAttribute("ID", request.getParameter("ID"));
        }
       
        else if (accion.equals("Actualizar")) {
            String Nombre = request.getParameter("txtNom");
            String Apellido = request.getParameter("txtApe");
            String Telefono = request.getParameter("txtTel");
            int ID = Integer.parseInt(request.getParameter("txtID"));

            cliente.actualizar(ID, Nombre, Apellido, Telefono);
            acceso = index;
        } 
        
        else if (accion.equals("editarModelo")) {
            acceso = editM;
            request.setAttribute("ID", request.getParameter("ID"));
        }
             
        else if (accion.equals("Actualizar Modelo")) {
            String Nombre = request.getParameter("txtNom");
            String Descripcion = request.getParameter("txtDes");
            int ID = Integer.parseInt(request.getParameter("txtID"));

            modeloC.editModelo(ID, Nombre, Descripcion);
            acceso = index;
        }
        
        else if (accion.equals("editarVehiculo")) {
            acceso = editV;
            request.setAttribute("ID", request.getParameter("ID"));
        }
        
           else if (accion.equals("Actualizar Vehiculo")) {
            String Nombre = request.getParameter("txtNom");
            String Descripcion = request.getParameter("txtDes");
            int ID = Integer.parseInt(request.getParameter("txtID"));

            vehiculoC.editVehiculo(ID, Nombre, Descripcion);
            acceso = index;
        }
        
        else if (accion.equals("eliminar")) {
            int ID = Integer.parseInt(request.getParameter("ID"));
            cliente.eliminar(ID);
            acceso = index;
        }
        
        else if (accion.equals("eliminarM")) {
            int ID = Integer.parseInt(request.getParameter("ID"));
            modeloC.deleteModelo(ID);
            acceso = modelo;
        }
        
        else if (accion.equals("eliminarV")) {
            int ID = Integer.parseInt(request.getParameter("ID"));
            vehiculoC.deleteVehiculo(ID);
            acceso = vehiculo;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
