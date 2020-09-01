<%-- 
    Document   : AdministradorUsuario
    Created on : 24/08/2020, 02:33:13 PM
    Author     : PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>ListarUsarioDesdeAdmininstrador</title>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
         <link rel="stylesheet" href="/resources/demos/style.css">
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
         <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
         <script src="Js/AdministadorUsuario.js" type="text/javascript"></script>
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
                            
                    
                            
                            
			<table  style="width: 100% ;font-size: 12px;"  id="tblProducto" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Identificación</th>
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Correo</th>
            <th style="background-color: #007bff;color: #fff;">Telefono</th>         
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
                        <h4 class="modal-title" >Editar usuario</h4>
                        <button type="button" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
        <input id="idUsuario" type="hidden">
        <div style="margin-top: 0px;   padding-top: 0px;" class="modal-body">
        <form>
            <div style="height: 60px;" class="form-group">
            <label for="recipient-name" class="col-form-label">Identificacion:</label>
            <input  type="text" name="txt_Identificacion"  id="txt_Identificacion" class="form-control" autocomplete="off" maxlength="11" required>
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Nombre:</label>
            <input   type="text" name="txt_Nombre"  id="txt_Nombre" class="form-control" autocomplete="off" maxlength="100" required>
             <div class="requerimientos" id="msjReferencia" style="text-align: center"></div>                       
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Telefono:</label>
           <input style="padding-right: 31px; margin-right: 9px; " onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_Telefono"  id="txt_Telefono" autocomplete="off" class="form-control" maxlength="30" required>
            <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>  
          </div>
            <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Correo:</label>
           <input style="padding-right: 31px; margin-right: 9px; "   type="text" name="txt_Correo"  id="txt_Correo" autocomplete="off" class="form-control" maxlength="45" required>
            <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>  
          </div>
             
         
        </form>
      </div>
      <div class="modal-footer">
          <button style="background-color: #007bff;color: #fff;" type="button" class="btn" id="btnEditarUsuario" class="btnEditarUsuario" >Actualizar</button>
                     
                        <button style="background-color: #007bff;color: #fff;" onclick="limpiarModal()" type="button" class="btn" data-dismiss="modal">Cerrar</button>
                       
      </div>
    </div>
  </div>
</div>
	<footer>
		<p>PRO-PISCINAS DEL HUILA S.A.S</p>
	</footer>
    </body>
</html>
