<%-- 
    Document   : MenuPrincipal
    Created on : 24/08/2020, 10:56:21 AM
    Author     : PAULA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
 if (session.getAttribute("idUsuario")!="900127905"){
   response.sendRedirect("Salir.jsp");
 }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MenuPrincipal</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"></script>
        <script src="Js/Graficos.js" type="text/javascript"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/AgregarProductoNuevo.css" rel="stylesheet" type="text/css"/>
         <link rel="icon" href="../Imagenes/logopropi.png" src=""/>
        
    </head >
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
	<section style="    height: 373px;"class="main">
            <section style="    height: 373px;" class="articles">
                    
                <article style="    margin-top: 5px;;
">
			
		
			
			
                            
                    <div  class="card-deck"  >
    <div location.href="Administrador" style="   -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">

      <div class="card-block">
        <h4 class="card-title">Usuarios</h4>
        <p class="card-text">Visualiza los usuarios creados,  editar el correo electronico e identificación de un usuario.</p>
        <center>
        <a style="    margin-bottom: 12px;" href="AdministradorUsuario.jsp" class="btn btn-primary">Clic aquí</a>
        </center>
      </div>
    </div>
    <div style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      
      <div class="card-block">
        <h4 class="card-title">Grupo</h4>
        <p class="card-text">Vizualida los grupos creados y desactiva o activa el grupo</p>
       <center>
           <a href="AdministradorGrupo.jsp" class="btn btn-primary">Clic aquí</a>
        </center>
      </div>
    </div>
    <div style=" -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      
      <div class="card-block">
        <h4 class="card-title">Presentación</h4>
        <p class="card-text">Visualiza las presentaciones creadas y desactiva o activa la presentación</p>
        <center>
        <a href="AdministradorPresentacion.jsp" class="btn btn-primary">Clic aquí</a>
        </center>
      </div>
    </div>
                              
                                                   <div class="card-deck" style="
    margin-top: 20px;
    margin-left: -5;
    margin-left: -10;
    margin-left: -10;
    margin-left: 0px;
    width: 1194px;
" >
    <div style="   -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;;" class="card">

      <div class="card-block">
        <h4 class="card-title">Unidad de Medida</h4>
        <p class="card-text">Visualiza las unidades de medida creadas y desactiva o activa unidades de medidas.</p>
       <center>
           <a  style="    margin-bottom: 12px;"href="AdministradorUnidadMedida.jsp" class="btn btn-primary">Clic aquí</a>
        </center>
      </div>
    </div>
    <div style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      
      <div class="card-block">
        <h4 class="card-title">Forma</h4>
        <p class="card-text">Vizualiza las formas creadas y desactiva o activa las formas</p>
        <center>
        <a href="AdministradorForma.jsp" class="btn btn-primary">Clic aquí</a>
        </center>
      </div>
    </div>
    <div style=" -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      
      <div class="card-block">
        <h4 class="card-title">Administrador</h4>
        <p class="card-text">Gmail->Propiscinasdelhuila2020@gmail.com</p>
       
      </div>
    </div>
</div>
                            
</article>

                    

			
		</section>
			
            
            
        
	</section>
	<footer>
		<p>PRO-PISCINAS DEL HUILA S.A.S</p>
	</footer>
    </body>
</html>
