<%-- 
    Document   : ListarCompraProveedor
    Created on : 11/08/2020, 08:55:08 AM
    Author     : PAULA
--%>
<%
  
 if (session.getAttribute("idUsuario")==null){
   response.sendRedirect("Salir.jsp");
 }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarCompraAProveedor</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
        <script src="Js/ListarProveedorProductoCompra.js" type="text/javascript"></script>
        <script src="Js/jsAutoCompleteProducto.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
   
    </head>
    <body style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #4998e8;">
       <header>
<div class="logotipo">
             
                    
            
                      <img src="Imagenes/Pro-piscinas.png" width="1200" height="300"alt="">
		
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
                                   
                                    <a class="dropdown-item" href="InactivarProducto.jsp">Inactivar producto</a>
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
                            <input class="btn btn-primary" id="fecha" type="date">
                              <input autocomplete="off" style="display: inline-grid; width: 572px; padding-top: 1px;" placeholder="BUSQUEDA POR  CÓDIGO DE PRODUCTO O NOMBRE " type="text" id="txt_Buscar" class="form-control txt_Buscar">
                         <select class="btn btn-primary" style="display: inline-grid; width: 280px;" name="cb_Proveedor" id="cb_Proveedor" class="form-control">
                                <option value="0">SELECCIONE PROVEEDOR</option>
                        </select>
                              <button style="" class="btn btn-primary btnBuscar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/>
                                </button>
                         <button style="" class="btn btn-primary btnBuscar" id="btn_Buscar" >🔎</button>
                                
                         
			<table  style="width: 99.5% ;font-size: 12.6px;"  id="tblMovimiento" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Nombre proveedor</th>
            <th style="background-color: #007bff;color: #fff;">Producto</th>
            <th style="background-color: #007bff;color: #fff;">Fecha </th>
            <th style="background-color: #007bff;color: #fff;">Precio compra</th>         
            <th style="background-color: #007bff;color: #fff;">Número de documento</th>
        
        </tr>
    </thead>
    <tbody id="Container" class="Container">
        
    </tbody>
</table>
                         
                                    <div  id="botones"  style=" height: 60px;width:1163px; overflow:scroll; position:relative; overflow-x:scroll;
     overflow-y:hidden;"class="btn-group btn-group-xs" 
                     role="group" arial-label="grupo">
                </div>
                        </article>
			
		</section>
            
		
	</section>
        
	<footer>
		<p>PRO-PISCINAS DEL HUILA S.A.S</p>
	</footer>
    </body>
</html>
