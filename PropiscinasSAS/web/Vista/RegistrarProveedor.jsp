<%-- 
    Document   : RegistrarProveedor
    Created on : 8/08/2020, 08:48:43 AM
    Author     : PAULA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RegistrarProveedor</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/RegistrarProveedor.js" type="text/javascript"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
                <section class="main" style="background-color: white;">
			<section class="full-box dashboard-contentPage">
		<!-- Content page -->
		<div class="container-fluid">
			<div class="page-header">
			  <h1 style="margin-left: 330px;color:#007bff ;     font-size: 170%;" class="text-titles"><i style="margin-left: 92px;    " class="zmdi zmdi-book zmdi-hc-fw"></i>  <small >REGISTRAR NUEVO PROVEEDOR</small></h1>
			</div>
			
		</div>
		
		<!-- Panel nuevo cliente-->
		<div class="container-fluid">
			<div class="panel panel-info">
                            <a style="    font-size: 1.5rem;
    color: #007bff !important;
    margin-left: 15px;">Información basica</a>
				<div class="panel-body">
                   <form id="frmCliente"   >
                                         
                                       
						<fieldset>
							
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-sm-6">
								    	<div class="form-group label-floating">
										  	<label class="control-label">Nro. Identificación o nit*</label>
                              <input id="txt_Nit" name="NrIdentificacion" pattern="[a-zA-Z0-9-]{1,15}" class="form-control" type="text" name="codigo-reg" required="" maxlength="15">
										</div>
				    				</div>
									<div class="col-xs-12 col-sm-6">
								    	<div class="form-group label-floating">
										  	<label class="control-label">Nombre  </label>
										  	<input id="txt_Nombre" onkeyup="javascript:this.value=this.value.toUpperCase();" name="txt_Nombre"  pattern="[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,45}" class="form-control" type="text" name="titulo-reg" required="" maxlength="45">
										</div>
				    				</div>
				    			
				    				
				    				
				    				
								</div>
							</div>
						</fieldset>
						<br>
						<fieldset>
                  </form>                             
							<legend style="color: #007bff !important;"><i class="zmdi zmdi-smartphone-android"></i> &nbsp; Telefonos</legend>
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<div class="form-group label-floating">
										  	<label class="control-label" >Nro. Telefonico</label>
										    	<input id="txt_Telefono"  name="txt_Nombre"  pattern="[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,45}" class="form-control" type="text" name="titulo-reg" required="" maxlength="45">
										
										</div>
				    				</div>
								
				    			
                                                                    <br>
                                                                    
								</div>
                                                          
							</div>
						
						</fieldset>
						
						<fieldset>
                                         <div class="col-xs-12 col-sm-8">           
                                        
										
                                 
                              

                                         </div>
						</fieldset>
                                                
						<p class="text-center" style="margin-top: 20px;">
                         <button type="button" class="btn btn-primary" id="btnAgregarProveedor"><i class="zmdi zmdi-floppy"></i>Registrar proveedor</button>
					    </p>
					    <br>
					 <p class="text-center" style="margin-top: 20px;">
						<div id="mensaje">
                        
						</div>
				  </p>
				</div>
			</div>
		</div>
	</section>
            
		
	</section>
     
	<footer>
		<p>Pro-piscinas 2020</p>
	</footer>
    </body>
</html>
