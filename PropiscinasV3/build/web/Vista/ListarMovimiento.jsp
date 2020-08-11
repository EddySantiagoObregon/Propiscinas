<%-- 
    Document   : ListarMovimiento
    Created on : 8/07/2020, 10:18:18 AM
    Author     : PAULA
--%>

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/ListarMovimiento.css" rel="stylesheet" type="text/css"/>
        <script src="Js/ListarMovimiento.js" type="text/javascript"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
    </head>
    <body>
     
       <header>
<div class="logotipo">
             
                    <a style="background-color: #007bff; position: fixed; font-family: sans-serif; border-radius: 10px;    left: 650px; color: white;  border-bottom: 40px;  padding-bottom: 10px;   padding-top: 10px;  padding-right: 10px; padding-left: 10px;" id="sNombre"></a>
                      
            
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
                            <button id="btnSalir" style="height: 40px;margin-left: 660px;;"type="button" class="btn btn-primary">
                                 Salir
                                 </button>
				
                                 
			</ul>
		</nav>
	</header>
	<section class="main">
		<section class="articles">
			<article>
                            <input class="btn btn-primary" id="fecha" type="date">
                            <input autocomplete="off" style="display: inline-grid; width: 610px; padding-top: 1px;" placeholder="BUSQUEDA POR NUMERO DE DOCUMENTO O CODIGO DE PRODUCTO" type="text" id="txt_Buscar" class="form-control txt_Buscar">
                                
                         <select class="btn btn-primary" style="display: inline-grid; width: 320px;" name="cb_TipoDocumento" id="cb_TipoDocumento" class="form-control">
                                <option value="0">TODOS LOS TIPOS DE DOCUMENTOS</option>
                        </select>
                         <button style="" class="btn btn-primary btnBuscar" id="btn_Buscar" >🔎</button>
                                <button style="" class="btn btn-primary btnBuscar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/>
                                </button>   
			<table  style="width: 98% ;font-size: 12.6px;"  id="tblMovimiento" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Infraestructura</th>
            <th style="background-color: #007bff;color: #fff;">Transaccion</th>
            <th style="background-color: #007bff;color: #fff;">Nombre Producto</th>         
            <th style="background-color: #007bff;color: #fff;">Caracteristicas</th>
            <th style="background-color: #007bff;color: #fff;">Grupo</th>
            <th style="background-color: #007bff;color: #fff;">Fecha registro</th>
            <th style="background-color: #007bff;color: #fff;">Cantidad</th>           
            <th style="background-color: #007bff;color: #fff;">Numero documento</th>
            <th style="background-color: #007bff;color: #fff;">Tipo documento</th>
            <th style="background-color: #007bff;color: #fff;">Observacion documento</th>
            <th style="background-color: #007bff;color: #fff;">Despacho</th>
            <th style="background-color: #007bff;color: #fff;">Obvservacion movimiento</th>
            <th style="background-color: #007bff;color: #fff;">Usuario</th>
         
            
            
            
         
           
        </tr>
    </thead>
    <tbody id="Container" class="Container">
        
    </tbody>
</table>
                        </article>
			
			
		</section>
            
		
	</section>
        
	<footer>
		<p>Pro-piscinas 2020</p>
	</footer>
    </body>
</html>
