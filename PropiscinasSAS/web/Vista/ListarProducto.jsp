<%-- 
    Document   : ListarProducto
    Created on : 23/06/2020, 04:52:15 PM
    Author     : PAULA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarProducto</title>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="Js/jsAutoCompleteProducto.js" type="text/javascript"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
        <script src="Js/ListarProducto.js" type="text/javascript"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        <script src="Js/Pagination.js" type="text/javascript"></script>
         <script src="Js/ListarAtributos.js" type="text/javascript"></script>
        
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
                                <button style="margin-bottom: 5px;" class="btn btn-primary btnListar" id="btnListar"><img width="18" height="18" src="Imagenes/actualizar.png"/></button>
                                <a style="margin-bottom: 5px; padding-top: 2px;padding-bottom: 4px;" class="btn btn-primary btnListar" href="ImprimirEtiquetasCodigoBarras.jsp"><img width="40" height="30" src="Imagenes/cod.png"/>Generar etiquetas de codigo de barras</a>
                         
                            
			<table  style="width: 100% ;font-size: 12px;"  id="tblProducto" class="table  table-striped" align="center">
    <thead>
        <tr class="bg-info text-white" >
            <th style="background-color: #007bff;color: #fff;">Codigo</th>
            <th style="background-color: #007bff;color: #fff;">Referencia</th>
            <th style="background-color: #007bff;color: #fff;">Nombre</th>
            <th style="background-color: #007bff;color: #fff;">Abreviatura</th>         
            <th style="background-color: #007bff;color: #fff;">Grupo</th>
            <th style="background-color: #007bff;color: #fff;">Presentación</th>
            <th style="background-color: #007bff;color: #fff;">Forma</th>           
            <th style="background-color: #007bff;color: #fff;">UnidadMedida</th>
            <th style="background-color: #007bff;color: #fff;">Detalle observación</th>
            <th style="background-color: #007bff;color: #fff;">Detalle Estado</th>
            <th style="background-color: #007bff;color: #fff;">Opción</th>
         
            
            
            
         
           
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
    <div class="modal-content">
       <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >Editar producto</h4>
                        <button type="button" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
        <div style="margin-top: 0px;   padding-top: 0px;" class="modal-body">
        <form>
            <div style="height: 60px;" class="form-group">
            <label for="recipient-name" class="col-form-label">Codigo:</label>
            <input readonly="readonly" onkeyup="javascript:this.value=this.value.toUpperCase();" type="text" name="txt_Codigo"  id="txt_Codigo" class="form-control" autocomplete="off" required>
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Referencia:</label>
            <input  onkeyup="javascript:this.value=this.value.toUpperCase();" type="text" name="txt_Referencia"  id="txt_Referencia" class="form-control" autocomplete="off" required>
             <div class="requerimientos" id="msjReferencia" style="text-align: center"></div>                       
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Nombre del producto:</label>
           <input style="padding-right: 31px; margin-right: 9px; " onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_Nombre"  id="txt_Nombre" autocomplete="off" class="form-control"  required>
            <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>  
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Abreviatura:</label>
          <input onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_Abreviatura"  id="txt_Abreviatura" class="form-control"  required>
          </div>
          
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Grupo:</label>
          <select name="cb_Grupo" id="cb_Grupo" class="form-control">
                                <option value="0">Seleccione</option>
					</select> 
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Presentación:</label>
          <select name="cb_Presentacion" id="cb_Presentacion" class="form-control">
                                       <option value="0">Seleccione</option>
					</select> 
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Forma:</label>
          <select name="cb_Forma" id="cb_Forma" class="form-control">
                                <option value="0">Seleccione</option>
					</select> 
          </div>
             <div style="height: 60px;" class="form-group">    
            <label for="message-text" class="col-form-label">Unidad Medida:</label>
          <select name="cb_UnidadMedida" id="cb_UnidadMedida" class="form-control">
                                      <option value="0">Seleccione</option>
					</select> 
          </div>
          <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Cantidad de medida</label>
          <input  type="number" name="txt_cantidadUnidad" id="txt_cantidadUnidad" class="form-control"   required>
                        <div class="requerimientos"  id="msjCantidad" style="text-align: center"></div>
                       </div>
         <div style="height: 60px;" class="form-group">
            <label for="message-text" class="col-form-label">Observación detalle</label>
          <textarea onkeyup="javascript:this.value=this.value.toUpperCase();"  type="text" name="txt_DetalleObservacion" id="txt_DetalleObservacion" class="form-control"  value="" required/></textarea>
                    <div class="requerimientos"  id="msjtxt_DetalleObservacion" style="text-align: center"></div>   
                    </div>
        </form>
      </div>
      <div class="modal-footer">
          <button style="background-color: #007bff;color: #fff;" type="button" class="btn" id="btnEditar" class="btnEditar" >Actualizar</button>
                     
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
