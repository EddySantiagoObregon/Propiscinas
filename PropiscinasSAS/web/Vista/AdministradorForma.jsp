<%-- 
    Document   : AdministradorForma
    Created on : 25/08/2020, 10:35:19 AM
    Author     : PAULA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
 if (session.getAttribute("idUsuario")!="900127905"){
   response.sendRedirect("Salir.jsp");
 }
%>
<!DOCTYPE html>
<html lang="es">
<head>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>ListarFormaDesdeAdmininstrador</title>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
         <link rel="stylesheet" href="/resources/demos/style.css">
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
         <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
         <script src="Js/AdministradorForma.js" type="text/javascript"></script>
         <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
    </head>

   
    <body style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #4998e8;">
       <header>
<div class="logotipo">
             
                 
    <img src="Imagenes/Pro-piscinas.png" width="1200" height="250"alt="">
		
		</div>
                    <input type="hidden" name="Correo" id="Correo" value="<%
                try {   
                    String correo= (String)session.getAttribute("correo");
                         out.print(correo);
                    } catch (Exception e) {
                    }
                   %>">
				<nav>
			<ul>
                            <li><a href="AdministradorMenuPrincipal.jsp">Pro-Piscinas</a></li>
                           <div class="btn-group navuldiv">
                                <button style="height: 40px;
    left: 322px;"type="button" class="btn btn-primary " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  ADMINISTRADOR PROPISCINAS S.A.S
                                 </button>
                                 
                            </div>
                       
                          
                            <div class="btn-group navuldiv" style="float: right;">
                                              <button style="height: 40px; "type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Administador
                                 </button>
                                    <div class="dropdown-menu">

                                       
                                        <a class="dropdown-item" href="Salir.jsp">Salir</a>
                                       
                                    </div>
                            </div>
                       
                                 
			</ul>
		</nav>
	</header>
	<section class="main">
		<section class="articles">
			<article>
                            <input class="form-control" style="
     width: 298px;
    position: absolute;"  onkeyup="javascript:this.value=this.value.toUpperCase();" type="text" id="txt_Nombre1">
                            <a id="btnAgregar" style="margin-left: 300px;color: white;"class="btn btn-primary">Agregar</a>
                            
                            
			<table  style="width: 100% ;font-size: 12px;"  id="tblProducto" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
           
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Estado</th>
            <th style="background-color: #007bff;color: #fff;">Editar</th>
         
            
            
            
         
           
        </tr>
    </thead>
    <tbody id="Container" class="Container">
        
    </tbody>
</table>
                        </article>
			
			
		</section>
            
		
	</section>
                  <div class="modal" id="modal">
           <div class="modal-dialog" role="document">
    <div class="modal-content">
       <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >Editar forma</h4>
                        <button type="button" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
        <input id="id" type="hidden">
        <div style="margin-top: 0px;   padding-top: 0px;" class="modal-body">
        <form>
   

            <label for="message-text" class="col-form-label">Estado:</label>
             <select name="cb_Estado" id="cb_Estado" class="form-control">
                                      <option value="A">ACTIVO</option>
                                      <option value="I">INACTIVO</option>
					</select>
     
             
         
        </form>
      </div>
      <div class="modal-footer">
          <button style="background-color: #007bff;color: #fff;" type="button" class="btn" id="btnEditar" class="btnEditar" >Actualizar</button>
                     
                        <button style="background-color: #007bff;color: #fff;" onclick="limpiarModal()" type="button" class="btn" data-dismiss="modal">Cerrar</button>
                       
      </div>
    </div>
  </div>
</div>
	<footer>
		<p>Pro-piscinas 2020</p>
	</footer>
    </body>
</html>
