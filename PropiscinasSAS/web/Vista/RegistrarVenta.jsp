<%-- 
    Document   : RegistrarVenta
    Created on : 24/06/2020, 09:58:48 AM
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
        <title>Registrar venta</title>
         <script src="Js/jquery.dataTables.min.js" type="text/javascript"></script>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
         <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
         <script src="Js/jsAutoCompleteProducto.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/AgregarVenta.css" rel="stylesheet" type="text/css"/>
        <script src="Js/RegistrarVenta.js" type="text/javascript"></script>
         <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
          <link rel="icon" href="Imagenes/logopropi.png" src=""/>
    </head>
    <script type="text/javascript">
   
    function showContent() {
        element = document.getElementById("content");
        
        if (check.checked) {
            element.style.display='block';
        }
        else {
            element.style.display='none';
        }
    }
</script>
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
                            <center>
                                <div id="formulario">
                                    
                               
                                                   <form id="frmAgregar" >
   
        <div  style="width: 80%; border: 0 !important; color:  #472055; margin-left: 50px; align-content: center; display: table;"  align="center" >
           
            <thead >
                        
                            <tr>
                                <th  colspan="2" style="text-align: center; margin-left: 10px"> Registrar venta</th>
                            </tr>
                        </thead>
                     
                   
                        <input type="hidden" name="accion" id="accion" value="Agregar">
                        <script>
                            function validarNumero(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla===8) return true; 
    patron =/[0-9]/;
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
 }
                            </script>
                    
                    <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Ingrese codigo  </font><br><font color="black">de barras:</font> </td>
                        <td><input style="border-left-width: 0px; 
  
    height: 40px;
    ;" onkeyup="buscarProducto()" maxlength="20" type="text" name="txt_Buscar"  id="txt_Buscar" class="form-control"  required>
                         <div id="msjNombre" style="text-align: center"></div>                       
                      </td>
                    </tr>
               
                  
            </div>
                                                                                             
            <div style="width: 80%; border: 0 !important; color:  #472055; margin-left: 50px;  align-content: center; display: table;"  align="center" >
                <br>
                
                <thead>
                        
                            <tr>
                                <th  colspan="2" style="text-align: center; margin-left: 10px">Producto</th>
                            </tr>
                        </thead>
                        
                 

                    <tr class="contenedor-columna"  style="height: 40px;">
                       <td class="negrita"><font color="black">Nombre </font></td>
                       <td><input style="height: 24.5px;" readonly="readonly"   type="text" name="txt_Nombre" id="txt_Nombre" class="form-control"  value="" required></td>
                    </tr>
                    <tr  style=" height: 40px;">
                       <td class="negrita"><font color="black">Forma </font></td>
                       <td><input style="height: 24.5px;" readonly="readonly"  type="text" name="txt_forma" id="txt_forma" class="form-control"  value="" required></td>
                    </tr>
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Unidad de medida </font></td>
                       <td><input style="height: 24.5px;" readonly="readonly"  type="text" name="txt_UnidadMedida" id="txt_UnidadMedida" class="form-control"  value="" required></td>
                    </tr>
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Grupo </font></td>
                       <td><input style="height: 24.5px;" readonly="readonly"  type="text" name="txt_Grupo" id="txt_Grupo" class="form-control"  value="" required></td>
                    </tr>
                 
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Presentación </font></td>
                       <td><input style="height: 24.5px;" readonly="readonly"  type="text" name="txt_Presentacion" id="txt_Presentacion" class="form-control"  value="" required></td>
                    </tr>
                    
                    
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Cantidad vendida</font></td>
                       <td><input style="height: 24.5px;" type="text" onkeypress="return validarNumero(event)" name="txt_CantidadVendidaa" id="txt_CantidadVendidaa" class="form-control"  value="" required></textarea></td>
                    </tr>
                      <td class="negrita"><font color="black">Valor de venta</font></td>
                       <td><input style="height: 24.5px;" type="text" name="txt_Valor" id="txt_Valor" class="form-control"  value="" required></textarea></td>
                    </tr>
                    
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Numero de factura</font></td>
                       <td><input style="height: 24.5px;" type="text" onkeypress="return validarNumero(event)" maxlength="9" name="txt_NumeroFactura" id="txt_NumeroFactura" class="form-control"  value="" required></textarea></td>
                    </tr>
                     <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Tipo de documento </font></td>
                        <td><select name="cb_TipoDocumento" id="cb_TipoDocumento" class="form-control">
                                <option value="0">Seleccione</option>
                        </td>
                    </tr>
                    
                    <tr  style="height: 10px;">
                        <td colspan="2"  style="text-align: center; margin-left: 10px">
                            <input style="margin: 20px;" id="btnAgregar" type="button" value="Agregar Venta" name="btnAgregar" class="btn btn-primary">
                          
                        
                        </td>
                    </tr>
                            
                     
                    
               
            </div>

                               </div>                         
                        </center>

        </form>
                      <div id="mensaje" style="text-align: center; color: black;">
             <%
                    String mensaje = request.getParameter("mensaje");
                    if (mensaje!=null){
                        out.print(request.getParameter("mensaje"));
                    }
             %>
        </div>
        
                            
                        </article>
			
			<article>
			 
                            
			<table   style="    width:1150px; 
    font-size: 19.7px;
display: none;"  id="tblMovimiento" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Codigo</th>
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Fecha venta</th>
            <th style="background-color: #007bff;color: #fff;">Cantidad</th>         
            <th style="background-color: #007bff;color: #fff;">Tipo de documento</th>
            <th style="background-color: #007bff;color: #fff;">N° de documento</th>
           
         
            
            
            
         
           
        </tr>
    </thead>
    <tbody id="Container" class="Container">
        
    </tbody>
</table></article>
		</section>
		
	</section>
	<footer>
		<p>Pro-piscinas 2020</p>
	</footer>
    </body>
</html>