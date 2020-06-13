<%-- 
    Document   : index
    Created on : 13/06/2020, 10:49:41 AM
    Author     : Brian Gomez
--%>


<%@page import="webservice.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ClienteService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="container mt-4">
            <div class="card">
                <div class="card-header">
                    <a href="Controlador?accion=add" class="btn btn-success">Nuevo Cliente</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nommbre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            ClienteService c = new ClienteService();
                            List<Cliente> datos = c.listar();
                            for(Cliente cl:datos){
                            
                            %>
                            <tr>
                                <th><%= cl.getID()%></th>
                                <th><%= cl.getNombre()%></th>
                                <th><%= cl.getApellido()%></th>
                                <th><%= cl.getTelefono()%></th>
                                <th>
                                    <a href="Controlador?accion=editar&ID=<%= cl.getID()%>" class="btn btn-warning">
                                        Edit
                                    </a>
                                    <a href="Controlador?accion=eliminar&ID=<%= cl.getID()%>" class="btn btn-danger">
                                       Delete 
                                    </a>
                                </th>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
