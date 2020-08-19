<%-- 
    Document   : MiPerfil
    Created on : 18/08/2020, 03:16:27 PM
    Author     : PAULA
--%>



<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
 if (session.getAttribute("idUsuario")==null){
   response.sendRedirect("IniciarSesion.jsp");
 }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarMovimiento</title>
           <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="Js/jsAutoCompleteProducto.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/ListarMovimiento.css" rel="stylesheet" type="text/css"/>
        <script src="Js/ListarMovimiento.js" type="text/javascript"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        <script src="Js/ActualizarDatos.js" type="text/javascript"></script>
        <script src="Js/EditarContrasena.js" type="text/javascript"></script>
        
    </head>
    <body style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #4998e8;">
        <script>
              function mostrarContrasena(){
      var tipo = document.getElementById("password");
      if(tipo.type === "password"){
          tipo.type = "text";
      }else{
          tipo.type = "password";
      }
  }
    function mostrarContrasenaa(){
      var tipo = document.getElementById("passwordd");
      if(tipo.type === "password"){
          tipo.type = "text";
      }else{
          tipo.type = "password";
      }
  }
        </script>
       <header>
<div class="logotipo">
             
                    
            
                      <img src="Imagenes/Pro-piscinas.png" width="1300" height="300"alt="">
		
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
                            <li><a href="MenuPrincipal.jsp">Pro-Piscinas</a></li>
                           <div class="btn-group navuldiv">
                                <button style="height: 40px;"type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Producto
                                 </button>
                                 <div class="dropdown-menu">
                                    <a class="dropdown-item" href="RegistrarProductoNuevo.jsp">Registrar producto nuevo</a>
                                   
                                    <a class="dropdown-item" href="ListarProducto.jsp">Listar productos</a>
                                   
                                    <a class="dropdown-item" href="EliminarProducto.jsp">Eliminar producto</a>
                                 </div>
                            </div>
                            <div class="btn-group navuldiv">
                                 <button style="height: 40px;"type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                 Venta
                                 </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="RegistrarVenta.jsp">Registrar venta</a>
                                        <a class="dropdown-item" href="ListarVenta.jsp">Listar venta</a>
                                        <a class="dropdown-item" href="ListarInventarioVenta.jsp">Listar inventario venta</a>
                                        <a class="dropdown-item" href="DevolucionVenta.jsp">Devolución de venta</a>
                                    </div>
                            </div>
                               <div class="btn-group navuldiv">
                                 <button style="height: 40px;"type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Inventario
                                 </button>
                                    <div class="dropdown-menu">
                                     <a class="dropdown-item" href="AgregarProducto.jsp">Registrar entrada del producto</a>
                                     <a class="dropdown-item" href="CambioDeProductosEnInfraestructura.jsp">Movimiento de productos</a>
                                     <a class="dropdown-item" href="ConvertirProducto.jsp">Convertir productos</a>
                                     <a class="dropdown-item" href="ListarInventario.jsp">Listar inventario datos historicos</a>
                                     <a class="dropdown-item" href="ListarInventarioCantidadActulizada.jsp">Listar inventario cantidad actualizada</a>
                                    </div>
                            </div>
                                                           <div class="btn-group navuldiv">
                                 <button style="height: 40px;"type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Movimiento
                                 </button>
                                    <div class="dropdown-menu">
                                    
                                        <a class="dropdown-item" href="ListarMovimiento.jsp">Listar movimiento</a>
            
                                    </div>
                            </div>
                            
                                                           <div class="btn-group navuldiv">
                                 <button style="height: 40px;"type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Proveedores
                                 </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="RegistrarProveedor.jsp">Registrar </a>
                                        <a class="dropdown-item" href="AgregarProveedorProducto.jsp">Agregar proveedor producto</a>
                                        <a class="dropdown-item" href="ListarProveedor.jsp">Listar Proveedor</a>
                                        <a class="dropdown-item" href="ListarCompraProveedor.jsp">Listar compra a proveedores</a>
                                    </div>
                            </div>
                                                           <div class="btn-group navuldiv" style="float: right;">
                              <button style="height: 40px; "type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               <a id="perfilNombre"></a>
                                 </button>
                                 <div class="dropdown-menu">
                                 <a class="dropdown-item" href="MiPerfil.jsp">Editar perfil </a>
                                 <a class="dropdown-item" href="Salir.jsp">Salir</a>
                                 </div>
                            </div>
				
				
                                 
			</ul>
		</nav>
	</header>
	<section class="main">
		<section class="articles">
			<article style="">
                                                            <center>

                            <div style=" background-color: #007bff;
                                 width: 806px; padding-top: 30px; border-radius: 20px;  -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);"> <div style=" background-color: #007bff;
    margin-left: 40px;
    margin-right: 40px;">
                          <form>
  <div class="form-group">
      <label for="" style="    text-align: left;
             margin-right: 629px; color: #ffffff;">Identificacion</label>
    <input type="number" class="form-control" id="txt_Identificacionnn" aria-describedby="emailHelp" >
  </div>
  <div class="form-group">
    <label for="" style="    text-align: left;
    margin-right: 667px; color: #ffffff;">Nombre</label>
    <input type="text" class="form-control" id="txt_Nombreee">
  </div>
       <div class="form-group">
    <label for="" style="    text-align: left;
    margin-right: 667px; color: #ffffff;">Telefono</label>
    <input type="number" class="form-control" id="txt_Telefonooo">
  </div>
       <div class="form-group">
    <label for="" style="    text-align: left;
    margin-right: 670px;color: #ffffff;">Correo</label>
    <input type="email" class="form-control" id="txt_Correooo">
  </div>
       
  <div class="form-group form-check">
    
  </div>
                        
      
       <details id="detalle" close>
          

           <summary style="color: #ffffff;">Actualizar contraseña</summary>
<div class="form-row" style="color: #ffffff;"> Contraseña nueva
    <div class="col">
        <input  class="form-control" type="password" name="password" id="password" style="width: 608px;">
</div>
    <div class="col">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" onclick="mostrarContrasena()" style="left: 25px;
    top: 5px; ">
        <label class="form-check-label"  style="margin-right: 0px;margin-left: 23px;margin-top: 3px;">
            <img src="Imagenes/ojo.png" width="25" height="25" alt=""/></label>
    
  
</div>
    <div class="form-row"style="color: #ffffff;" > Contraseña antigua
    <div class="col">
        <input  class="form-control" type="password" name="password" id="passwordd" style="width: 608px;margin-left: 6px;">
</div>
    <div class="col">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" onclick="mostrarContrasenaa()" style="left: 25px;
    top: 5px;">
        <label class="form-check-label" style="    margin-right: 0px;
    margin-left: 23px;
    margin-top: 3px;">   <img  src="Imagenes/ojo.png" width="25" height="25" alt=""/></label>
    
  
</div>
        <a style="margin-left: 283px;
    margin-top: 6px;
    color: black;
    background-color:  aliceblue;
    cursor: pointer;
    border-color: #444;" id="btnEditarContrasena" class="btn" >Actualizar contraseña</a>
    </details>
                              
</div>
    <br>
    <br>
    <a id="btnActualizarDatos" style="background-color: aliceblue; cursor: pointer;border-color: #444;"class="btn">Actualizar</a>
   
    <br>
     <br>
  </div>
 
 
    </center>

                        </article>
			
			
		</section>
            
		
	</section>
        
	<footer>
		<p style="    text-shadow:
2px 2px 0 #AAA,
      6px 6px 2px #777,
      12px 12px 8px #444 ;">Pro-piscinas 2020</p>
	</footer>
    </body>
</html>
