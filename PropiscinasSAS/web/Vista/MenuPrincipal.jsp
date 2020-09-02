<%-- 
    Document   : MenuPrincipal
    Created on : 9/06/2020, 05:44:38 PM
    Author     : PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
 if (session.getAttribute("idUsuario")==null){
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
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
         <link href="Css/Canva.css" rel="stylesheet" type="text/css"/>
         <script src="Js/Canva.js" type="text/javascript"></script>
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
                                        <a class="dropdown-item" href="ListarProductoDeProveedor.jsp">Listar producto de proveedor</a>
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
                    
                    <article>
			   <article>
                             <details id="detalle" close>
                                 

                                 <summary ><a style="color:#23186b;font-size: 30.5px !important;">Producto más vendido hoy</a></summary>
                                 <center>
                                 <div style="width: 700px;   position: sticky;">
                                <canvas style="    width: 735px;height: 682px; "  id="myChar" ></canvas>
    </div>
                                     </center>
                    </details>
                            
                            
                
                       
                        </article>
			<article>
                             <details id="detalle" close>
                                 

                                 <summary ><a style="color:#23186b;font-size: 30.5px !important;">Producto más vendido </a></summary>
                                 <center>
                                 <div style="width: 700px;
    position: sticky;">
                                <canvas style="    
    width: 735px;
    height: 682px; "  id="myChart" ></canvas>
    </div>
                                     </center>
                    </details>
                            
                        </article>
                     
                          <article>
                             <details id="detalle" close>
                                 

                                 <summary ><a style="color:#23186b;font-size: 30.5px !important;">Producto menos vendido </a></summary>
                                 <center>
                                 <div style="width: 700px;  position: sticky;">
                                <canvas style="    width: 735px;height: 682px; "  id="myCha" ></canvas>
    </div>
                                     </center>
                    </details>
                            
                            
                
                       
                        </article>
                        <article>
                            
                            <div class="card-deck"  >
    <div style="   -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;;" class="card">
      <img class="card-img-top" src="Imagenes/Pro-piscinas.png" alt="Card image cap">
      <div class="card-block">
        <h4 class="card-title">SALA DE VENTAS</h4>
        <p class="card-text">Todos los productos vendidos se descontara del inventario de la sala de ventas</p>
       
      </div>
    </div>
    <div style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      <img class="card-img-top" src="Imagenes/Pro-piscinas.png" alt="Card image cap">
      <div class="card-block">
        <h4 class="card-title">BODEGA 1</h4>
        <p class="card-text">Se referencia bodega 1 a la bodega ubicada en el barrio Caracolí</p>
      
      </div>
    </div>
    <div style=" -webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #999;
  filter: shadow(color=#999999, direction=135, strength=2);cursor: pointer;" class="card">
      <img class="card-img-top" src="Imagenes/Pro-piscinas.png" alt="Card image cap">
      <div class="card-block">
        <h4 class="card-title">BODEGA 2</h4>
        <p class="card-text">Se referencia bodega 2 a la bodega ubicada en las bodegas de Palermo</p>
       
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
