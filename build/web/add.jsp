<%-- 
    Document   : add
    Created on : 13/06/2020, 01:24:31 PM
    Author     : Brian Gomez
--%>

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
                    <h5>Agregar Nuevo Cliente</h5>
                </div>
                <div class="card-body">
                    <form action="Controlador">
                        <label>Nombre</label>
                        <input type="text" name="txtNom" class="form-control">
                        <label>Apellido</label>
                        <input type="text" name="txtApe" class="form-control">
                        <label>Telefono</label>
                        <input type="text" name="txtTel" class="form-control">
                        
                        <br />
                        <input type="submit" class="btn btn-primary" name="accion" value="Guardar">
                        <a href="Controlador?accion=index">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
