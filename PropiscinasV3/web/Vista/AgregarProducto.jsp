<%-- 
    Document   : AgregarProducto
    Created on : 17/06/2020, 03:27:12 PM
    Author     : PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarProducto</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/AgregarProducto.js" type="text/javascript"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        
    </head>
    <body>
    <header>
<div class="logotipo">
             
                    <a style="background-color: #007bff; position: fixed; font-family: sans-serif; border-radius: 10px;    left: 660px; color: white;  border-bottom: 40px;  padding-bottom: 10px;   padding-top: 10px;  padding-right: 10px; padding-left: 10px;" id="sNombre"></a>
                      
            
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
                            <button id="btnSalir" style="height: 40px;margin-left: 544px;"type="button" class="btn btn-primary">
                                 Salir
                                 </button>
				
                                 
			</ul>
		</nav>
	</header>
	<section class="main">
		<section class="articles">
			<article>
                            
                            <input autocomplete="off" style="display: inline-grid; width: 40%" type="text" id="txt_Buscar" class="form-control txt_Buscar">
                                <button style="margin-bottom: 5px;" class="btn btn-primary btnBuscar" id="btnBuscar">🔎</button>
                                <button style="margin-bottom: 5px;" class="btn btn-primary btnBuscar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/></button>
                         
                            
			<table style="width: 100% ;font-size: 12px;"  id="tblProducto" class="table table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Codigo</th>
            <th style="background-color: #007bff;color: #fff;">Referencia</th>
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Abreviatura</th>        
            <th style="background-color: #007bff;color: #fff;">Grupo</th>
            <th style="background-color: #007bff;color: #fff;">Presentacion</th>
            <th style="background-color: #007bff;color: #fff;">Forma</th>           
            <th style="background-color: #007bff;color: #fff;">UnidadMedida</th>
            <th style="background-color: #007bff;color: #fff;">Detalle observación</th>
            <th style="background-color: #007bff;color: #fff;">Detalle Estado</th>
            <th style="background-color: #007bff;color: #fff;">Opción</th>
         
            
            
            
         
           
        </tr>
    </thead>
    <tbody id="Container" class="Container">
        
    </tbody>
    <script>
     function validarNumero(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla===8) return true; 
    patron =/[0-9]/;
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
 }   
    </script>
</table>
                        </article>
			
		
		</section>
            
		
	</section>
        <div class="modal" id="modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >Agregar cantidad al producto <a id="sNombree"></a></h4>
                        <button type="button" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <div class="modal-body">
                      
                            <thead>
                                
                            </thead>
                          <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Infraestructura</font></td>
                        <td><select name="cb_Infraestructura" id="cb_Infraestructura" class="form-control">
                                <option value="0">Seleccione</option>
                                </select>
                        </td>
                    </tr>  
                             
                                            <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Cantidad nueva </font></td>
                         <td><input type="number" name="txt_Cantidad"  id="txt_Cantidad" class="form-control"  required>
                         <div id="msjCantidad" style="text-align: center"></div>                       
                      </td>
                    </tr>
                    
                    <input  type="hidden" id="idProducto">
                    <input  type="hidden" id="sIdUnidad">
                        <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Cantidad Existente</font></td>
                        <td><input readonly="readonly"  id="txt_CantidadExistente"class="form-control">
                                
                        </td>
                    </tr>
                       <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Unidad Medida </font></td>
                       <td><input readonly="readonly" name="sUnidad" id="sUnidad" class="form-control">
                              
                        </td>
                    </tr>
                      </tr>
                       <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Valor de compra </font></td>
                       <td><input  name="txt_ValorCompra" id="txt_ValorCompra"  maxlength="45" class="form-control">
                              
                        </td>
                    </tr>
                     <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Proveedor</font></td>
                        <td><select name="cb_Proveedor" id="cb_Proveedor" class="form-control">
                                <option value="0">Seleccione</option>
                                </select>
                        </td>
                    </tr>  
                   
                    
                      <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Observación producto</font></td>
                        <td><textarea type="text" name="txt_Observacion" id="txt_Observacion" class="form-control"  value="" required/></textarea></td>
                   
                    </tr>
                  
                      
                      <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Numero de documento</font></td>
                        <td><input type="number" name="txt_NumeroDocumento" id="txt_NumeroDocumento" class="form-control"  value="" required/></input></td>
                   
                    </tr>    
                   
                     <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Observacion documento</font></td>
                        <td><input type="text" name="txt_ObservacionDocumento" id="txt_ObservacionDocumento" class="form-control"  value="" required/></input></td>
                   
                    </tr>   
                       
                    </div>
                    <div class="modal-footer">
                        <button style="background-color: #007bff;color: #fff;" type="button" class="btn" id="btnAgregarCantidad" class="btnAgregarCantidad" >Agregar</button>
                     
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
