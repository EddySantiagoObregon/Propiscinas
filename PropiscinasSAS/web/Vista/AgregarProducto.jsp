<%-- 
    Document   : AgregarProducto
    Created on : 17/06/2020, 03:27:12 PM
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
        <title>RegistrarEntradaProducto</title>
           <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="Js/jsAutoCompleteProducto.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/AgregarProducto.js" type="text/javascript"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
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
                            
                            <input autocomplete="off" style="display: inline-grid; width: 40%" type="text" id="txt_Buscar" class="form-control txt_Buscar" placeholder="BUSQUEDA POR CÓDIGO O NOMBRE DEL PRODUCTO">
                                <button style="margin-bottom: 5px;" class="btn btn-primary btnBuscar" id="btnBuscar">🔎</button>
                                <button style="margin-bottom: 5px;" class="btn btn-primary btnBuscar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/></button>
                         
                            
			<table style="width: 100% ;font-size: 12px;"  id="tblProducto" class="table table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Código</th>
            <th style="background-color: #007bff;color: #fff;">Referencia</th>
            <th style="background-color: #007bff;color: #fff;">Abreviatura</th>
            <th style="background-color: #007bff;color: #fff;">Forma</th>        
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Unidad de medida</th>
            <th style="background-color: #007bff;color: #fff;">Presentación</th>           
            <th style="background-color: #007bff;color: #fff;">Observacón</th>
            <th style="background-color: #007bff;color: #fff;">Grupo</th>
            <th style="background-color: #007bff;color: #fff;">Estado</th>
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
                                      <div  id="botones"  style=" height: 60px;width:1163px; overflow:scroll; position:relative; overflow-x:scroll;
     overflow-y:hidden;"class="btn-group btn-group-xs" 
                     role="group" arial-label="grupo">
                </div>
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
                                <option value="0">Seleccioné</option>
                                </select>
                        </td>
                    </tr>  
                             
                                            <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Cantidad nueva </font></td>
                        <td><input type="text"  onkeypress="return validarNumero(event)" maxlength="10" name="txt_Cantidad"  id="txt_Cantidad" class="form-control"  required>
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
                                <option value="0">Seleccioné</option>
                                </select>
                        </td>
                    </tr>  
                   
                    
                      <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Observación producto</font></td>
                            <td><textarea onkeyup="javascript:this.value=this.value.toUpperCase();" type="text" name="txt_Observacion" id="txt_Observacion" class="form-control" maxlength="150"  value="" required/></textarea></td>
                   
                    </tr>
                  
                      
                      <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Número de documento</font></td>
                            <td><input onkeyup="javascript:this.value=this.value.toUpperCase();" type="text"  maxlength="20"name="txt_NumeroDocumento" id="txt_NumeroDocumento" class="form-control"  value="" required/></input></td>
                   
                    </tr>    
                   
                     <tr style="height: 40px;">
                            <td class="negrita"><font color="black">Observación documento</font></td>
                            <td><textarea onkeyup="javascript:this.value=this.value.toUpperCase();" type="text" name="txt_ObservacionDocumento" id="txt_ObservacionDocumento" maxlength="45" class="form-control"  value="" required/></textarea></td>
                   
                    </tr>   
                       
                    </div>
                    <div class="modal-footer">
                        <button style="background-color: #007bff;color: #fff;" onclick="this.disabled=true" type="button" class="btn" id="btnAgregarCantidad" class="btnAgregarCantidad" >Agregar</button>
                     
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
