<%-- 
    Document   : ListarEjemplo
    Created on : 31/08/2020, 05:34:32 PM
    Author     : PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script 
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script 
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
              <script src="Js/listarEjemplo.js" type="text/javascript"></script>
    </head>
 
<!DOCTYPE html>


    <body>
        
        <div class="container">
            
            <div class="row">
                <div class="page-header">
                    <h1>Pruebas de JSON con paginador</h1>
                </div>
                
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido P</th>
                            <th>Apellido M</th>
                        </tr>
                    </thead>
                    <tbody id="listado">
                    </tbody>
                </table>
                <div id="botones" class="btn-group btn-group-xs" 
                     role="group" arial-label="grupo">
                </div>
            </div>
            
        </div>
        
        
   
       
    </body>
</html>

