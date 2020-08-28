<%-- 
    Document   : DevolucionVenta
    Created on : 22/07/2020, 10:16:17 AM
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
        <title>Devolución venta</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/ListarMovimiento.css" rel="stylesheet" type="text/css"/>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        <script src="Js/DevolucionVenta.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
    </head>
    <body style="-webkit-box-shadow: 2px 2px 5px #999;
  -moz-box-shadow: 2px 2px 5px #4998e8;">
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
                              <input autocomplete="off" style="display: inline-grid; width: 572px; padding-top: 1px;" placeholder="BUSQUEDA POR NUMERO DE DOCUMENTO O CODIGO DE PRODUCTO" type="text" id="txt_Buscar" class="form-control txt_Buscar">
                                
                         <select class="btn btn-primary" style="display: inline-grid; width: 320px;" name="cb_TipoDocumento" id="cb_TipoDocumento" class="form-control">
                                <option value="0">TODOS LOS TIPOS DE DOCUMENTOS</option>
                        </select>
                         <button style="" class="btn btn-primary btnBuscar" id="btnBuscar" >🔎</button>
                                <button style="" class="btn btn-primary btnBuscar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/>
                                </button>
			<table  style="width: 95% ;font-size: 12.6px;"  id="tblMovimiento" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Codigo</th>
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Fecha venta</th>
            <th style="background-color: #007bff;color: #fff;">Cantidad</th>         
            <th style="background-color: #007bff;color: #fff;">Tipo de documento</th>
            <th style="background-color: #007bff;color: #fff;">N° de documento</th>
            <th style="background-color: #007bff;color: #fff;">Estado</th>
            <th style="background-color: #007bff;color: #fff;">Opciones</th>
            
            
           
         
            
            
            
         
           
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
    <div style="height: 764px;"class="modal-content">
       <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >Devolución de venta</h4>
                        <button type="button" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
            <form>
            
        <div style="margin-top: 0px;   padding-top: 0px;" class="modal-body">
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Numero de documento:</label>
            <input  readonly="readonly"type="text" name="txt_numeroDocumento"  id="txt_numeroDocumento" class="form-control"  required>
          </div>
        <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Tipo de documento:</label>
            <input readonly="readonly"  type="text" name="txt_tipoDocumento"  id="txt_tipoDocumento" class="form-control"  required>
          </div>
            <div style="height: 60px;" class="form-group">
            <label for="recipient-name" class="col-form-label">Codigo:</label>
            <input readonly="readonly" type="text" name="txt_Codigo"  id="txt_Codigo" class="form-control" autocomplete="off" required>
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Nombre:</label>
            <input readonly="readonly" onkeyup="javascript:this.value=this.value.toUpperCase();" type="text"  name="txt_Nombre"  id="txt_Nombre" class="form-control" autocomplete="off" required>
             <div class="requerimientos" id="msjReferencia" style="text-align: center"></div>                       
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Fecha compra:</label>
            <input readonly="readonly" style="padding-right: 31px; margin-right: 9px; " onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_Fecha"  id="txt_Fecha" autocomplete="off" class="form-control"  required>
            <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>  
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Cantidad vendida:</label>
            <input  readonly="readonly" onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="5" type="number" name="txt_cantidadVenta"  id="txt_cantidadVenta" class="form-control"  required>
          </div>
             <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Cantidad de vuelta:</label>
            <input  onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="5" type="text" name="txt_cantidadDevuelta"  id="txt_cantidadDevuelta" class="form-control"  required>
          </div>
             <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Observación de devolución:</label>
            <textarea  onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="45" type="text" name="txt_ObservacionDocumento"  id="txt_ObservacionDocumento" class="form-control"  required></textarea>
          </div>
          </div>
               <div style="position: absolute;
    top: 698px;
    left: 242px;" >
          <button style="background-color: #007bff;
    color: #fff;
    margin-top: 13px;" type="button" class="btn" id="btnEditar" class="btnEditar" >Hacer devolución</button>
                     
                        <button style="background-color: #007bff;color: #fff;margin-top: 12px;" onclick="limpiarModal()" type="button" class="btn" data-dismiss="modal">Cerrar</button>
                       
      </div>
        
        </form>
      </div>
          
    </div>
  </div>
</div>
	<footer>
		<p>Pro-piscinas 2020</p>
	</footer>
    </body>
</html>
