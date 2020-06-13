<%-- 
    Document   : edit
    Created on : 13/06/2020, 02:16:50 PM
    Author     : Brian Gomez
--%>


<%@page import="webservice.Cliente"%>
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
                    <%
                        int ID=Integer.parseInt((String)request.getAttribute("ID"));
                        ClienteService cliente = new ClienteService();
                        Cliente c = cliente.listarID(ID);
                    %>
                    <h5>Actualizar Cliente</h5>
                </div>
                
                <div class="card-body">
                    <form action="Controlador">
                        <label>ID</label>
                        <input type="text" value="<%= c.getID()%>"readonly="" name="txtID" class="form-control">
                        <label>Nombre</label>
                        <input type="text" name="txtNom" class="form-control" value="<%= c.getNombre()%>">
                        <label>Apellido</label>
                        <input type="text" name="txtApe" class="form-control" value="<%= c.getApellido()%>">
                        <label>Telefono</label>
                        <input type="text" name="txtTel" class="form-control" value="<%= c.getTelefono()%>">
                        
                        <br />
                        <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
                        <a href="Controlador?accion=index">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
