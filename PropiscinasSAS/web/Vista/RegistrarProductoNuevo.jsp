<%-- 
    Document   : RegistrarProductoNuevo
    Created on : 12/06/2020, 08:22:19 AM
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
        <title>Registrar producto</title>
    
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/RegistrarProducto.js" type="text/javascript"></script>
        <link href="Css/AgregarProductoNuevo.css" rel="stylesheet" type="text/css"/>
        <script src="Js/ListarAtributos.js" type="text/javascript"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
    </head>
    <script type="text/javascript">
   
    function showContent() {
        $("#msjContent").html(" ");
        element = document.getElementById("content");
          
        if (check.checked) {
            element.style.display='block';
           
        }
        else {
            element.style.display='none';
         
        }
    }
     function validarNumero(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla===8) return true; 
    patron =/[0-9]/;
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
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
                            <center>
                            <div id="formulario">
                                                   <form id="frmAgregar" >
   
        <table style="width: 80%; border: 0 !important; color:  #472055; margin-left: 50px;"  align="center" >
           
            <thead >
                        
                            <tr>
                                <th  colspan="2" style="text-align: center; margin-left: 10px"> Registrar producto</th>
                            </tr>
                        </thead>
                        <tbody>
                   
                       
                   <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Usar codigo de  </font><br><font color="black">barras existente</font> <input style="
  position: absolute;
    right: 1174.89;
    margin-right: 50px;
    margin-left: 40px;
    width: 20px;
    height: 20px;
    bottom: 358px;
    top: 358px;
    margin-top: 30px;
   "
   type="checkbox" name="check" id="check" class="check" value="SI"  onchange="javascript:showContent()" onclick="borrarCod()"></td>
                   
                        <td>
                            
                           
                            <input id="content" onkeypress="return validarNumero(event)" style="display: none;" maxlength="13" minlength="13" type="text" name="content"  class="form-control"  >
                            <div  class="requerimientos"  id="msjContent" style="text-align: center"></div>                       
                     
                        </td>
                        
            
                    </tr>  
                    <input type="hidden" id="referencia">
                    <input type="hidden" id="fecha">
                    <input type="hidden" id="cancod">
                    <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Referencia</font></td>
                        <td><input  onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="20" type="text" name="txt_Referencia"  id="txt_Referencia" class="form-control" autocomplete="off" required>
                         <div class="requerimientos" id="msjReferencia" style="text-align: center"></div>                       
                      </td>
                    </tr>
               
                    <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Nombre del producto</font></td>
                        <td><input maxlength="50" style="padding-right: 31px; margin-right: 9px; " onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_Nombre"  id="txt_Nombre" autocomplete="off" class="form-control"  required>
                         <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>                       
                      </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Abreviatrura </font></td>
                         <td><input onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="5"  type="text" name="txt_Abreviatura"  id="txt_Abreviatura" class="form-control"  required>
                         <div  class="requerimientos" id="msjAbreviatura" style="text-align: center"></div>                       
                      </td>
                    </tr>

                    </tbody>
            </table>
                                                                                             
            <table style="width: 80%; border: 0 !important; color:  #472055; margin-left: 50px;"  align="center" >
                <br>
                
                <thead>
                        
                            <tr>
                                <th  colspan="2" style="text-align: center; margin-left: 10px"> Detalle del producto</th>
                            </tr>
                        </thead>
                        
                        <tbody>

                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Grupo </font></td>
                        <td><select name="cb_Grupo" id="cb_Grupo" class="form-control">
                                <option value="0">Seleccioné</option>
                        </td>
                    </tr>
                    
                     <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Presentación: </font></td>
                        <td><select name="cb_Presentacion" id="cb_Presentacion" class="form-control">
                                <option value="0">Seleccioné</option>
                        </td>
                    </tr>
                                        <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Forma </font></td>
                        <td><select name="cb_Forma" id="cb_Forma" class="form-control">
                                <option value="0">Seleccioné</option>
                        </td>
                    </tr>
                     
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Unidad Medida </font></td>
                        <td><select name="cb_UnidadMedida" id="cb_UnidadMedida" class="form-control">
                                <option value="0">Seleccioné</option>
                        </td>
                    </tr>

                    <tr  style="height: 40px;">
                        <td class="negrita"><font color="black">Cantidad de</font><br><font color="black">medida</font> </td>
                        <td><input  type="number" name="txt_cantidadUnidad" id="txt_cantidadUnidad" class="form-control"   required>
                        <div class="requerimientos"  id="msjCantidad" style="text-align: center"></div>
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                          <td class="negrita"><font color="black">Observación detalle</font></td>
                          <td><textarea onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_DetalleObservacion" maxlength="500" id="txt_DetalleObservacion" class="form-control"  value="" required/></textarea>
                    <div class="requerimientos"  id="msjtxt_DetalleObservacion" style="text-align: center"></div>   
                    </td>
                    
                    </tr>
                   
                 
                    <td><input  type="hidden" name="txt_cancod" id="txt_cancod" class="form-control"   required>
                      
                     
                    
                    
                    <tr  style="height: 10px;">
                        <td colspan="2"  style="text-align: center; margin-left: 10px">
                         <input style="margin: 20px;" id="btnAgregar" onclick="this.disabled=true"  type="button" value="Registrar" name="btnAgregar" class="btn btn-primary">
                          
                        
                        </td>
                    </tr>
                   
                </tbody>
            </table>
                      

        </form>      <div id="mensaje" style="text-align: center; color: black;">
             <%
                    String mensaje = request.getParameter("mensaje");
                    if (mensaje!=null){
                        out.print(request.getParameter("mensaje"));
                    }
             %>
        </div> 
                            </div>
                                  </center>
                            <br>
                                                        <div name="repetir" class="repetir alert alert-primary" role="alert" id="repetir" style="  width: 402px; padding-left: 0px;   padding-right: 0px;   margin-left: 379px; border-radius: 0px; display: none;" type="text"   >
                                                            Si no salio la impresión correctamente dar<a style="color:#007bff; cursor: pointer;"  id="Click" onclick="repetirCodigo();"> Click aquí <svg class="bi bi-download" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M.5 8a.5.5 0 0 1 .5.5V12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V8.5a.5.5 0 0 1 1 0V12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V8.5A.5.5 0 0 1 .5 8z"/>
  <path fill-rule="evenodd" d="M5 7.5a.5.5 0 0 1 .707 0L8 9.793 10.293 7.5a.5.5 0 1 1 .707.707l-2.646 2.647a.5.5 0 0 1-.708 0L5 8.207A.5.5 0 0 1 5 7.5z"/>
  <path fill-rule="evenodd" d="M8 1a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-1 0v-8A.5.5 0 0 1 8 1z"/>
</svg></a>
                                                        </div>
                            <br>
               
                            
                        </article>
			
		</section>
		
	</section>
        <div role="dialog" tabindex="-1" class="modal fade" id="modal-avisolegal" style="max-width:600px;margin-right:auto;margin-left:auto;right: 0px;">
                 <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header" style="background-color: #007bff;color: #fff;"> <!– CABECERA –>
                
                        <h4 class="text-center modal-title" style="color:#fff; ">Registrando producto</h4>
                        
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    
                    </div>
                    <div class="modal-body"> <!– CUERPO DEL MENSAJE –>
                        <center>
                            <form id="frmAgregarPro">
                        <table>
                        
                            <input type="hidden" name="accion" id="accion" class="accion"  value="agregar2">
                            <input type="hidden" name="_cb_Grupo" id="_cb_Grupo" class="_cb_Grupo"  >
                            <input type="hidden" name="_cb_UnidadMedida" id="_cb_UnidadMedida" class="_cb_UnidadMedida"  >
                            <input type="hidden" name="_cb_Presentacion" id="_cb_Presentacion" class="_cb_Presentacion"  >
                            <input type="hidden" name="_cb_Forma" id="_cb_Forma" class="_cb_Forma" >
                            <input type="hidden" name="_cod_barra" id="_cod_barra" class="_cod_barra" value="0" >
                            <input type="hidden" name="_referencia" id="_referencia" class="_referencia"  >
                            <input type="hidden" name="_txt_Producto_Convertir" id="_txt_Producto_Convertir" class="_txt_Producto_Convertir"  >
                             <input type="hidden" name="_txt_Producto_Convertir_Cantidad" id="_txt_Producto_Convertir_Cantidad" class="_txt_Producto_Convertir_Cantidad"  >
                            
                     <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Referencia </font></td>
                       <td><input   onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="20"  type="text" name="_txt_Referencia" id="_txt_Referencia" class="form-control"  value="" required>
                       <div class="requerimientos"  id="msj_txt_Referencia" style="text-align: center"></div>
                       </td>
                    </tr>
                            <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Nombre </font></td>
                       <td><input readonly="readonly"   type="text" name="_txt_Nombre"  id="_txt_Nombre" class="form-control"  value="" required>
                        </td>
                    </tr>
                   
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Abreviatura </font></td>
                       <td><input onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="5"    type="text" name="_txt_Abreviatura" id="_txt_Abreviatura" class="form-control"  value="" required>
                       <div class="requerimientos"  id="msj_txt_Abreviatura" style="text-align: center"></div>
                       </td>
                    </tr>
               
                    
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Grupo </font></td>
                       <td><input readonly="readonly"  type="text" name="_txt_Grupo" id="_txt_Grupo" class="form-control"  value="" required>
                       </td>
                    </tr>
                 
             
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Presentacion: </font></td>
                        <td><input readonly="readonly" name="_txt_Presentacion" id="_txt_Presentacion" class="form-control">
                         
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Forma </font></td>
                       <td><input readonly="readonly"  type="text" name="_txt_forma" id="_txt_forma" class="form-control"  value="" required></td>
                    </tr>
                    
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Unidad de medida </font></td>
                       <td><input readonly="readonly"  type="text" name="_txt_UnidadMedida" id="_txt_UnidadMedida" class="form-control"  value="" required></td>
                    </tr>
                    <input type="hidden" id="numero" name="numero" class="numero">
                      <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Cantidad de medida </font></td>
                       <td><input readonly="readonly"  type="text" name="_txt_cantidadUnidad" id="_txt_cantidadUnidad" class="form-control"   required></td>
                    </tr>
                    <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Observación detalle </font></td>
                       <td><textarea  onkeyup="javascript:this.value=this.value.toUpperCase();"  maxlength="500" type="text" name="_txt_DetalleObservacion" id="_txt_DetalleObservacion" class="form-control"  value="" required></textarea>
                       <div class="requerimientos"  id="msj_txt_DetalleObservacion" style="text-align: center"></div>
                       </td>
                    </tr>
                    
                    <tr  style="height: 10px;">
                        <td colspan="2"  style="text-align: center; margin-left: 10px">
                            <input style="margin: 20px;" id="btnRegistrarProo" onclick="this.disabled=true" type="button" value="Registrar Producto" name="btnRegistrarProo" class="btn btn-primary">
                          
                        
                        </td>
                    </tr>
                    </table>
                                </form>
                            </center>
                    </div>
                    <div class="modal-footer"> <!– PIE –>
                  
                    </div>
                  </div>
                 </div>
        </div>
	<footer>
		<p>PRO-PISCINAS DEL HUILA S.A.S</p>
	</footer>
    </body>
</html>