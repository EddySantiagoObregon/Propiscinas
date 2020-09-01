<%-- 
    Document   : IniciarSesion
    Created on : 8/07/2020, 03:28:08 PM
    Author     : PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
if (session.getAttribute("idUsuario")!=null){
   response.sendRedirect("MenuPrincipal.jsp");
}else{
   session.invalidate();
}

%>



<html lang="en">

<head>
    <title>Iniciar Sesión</title>
    <!-- meta tags -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="keywords" content="Art Sign Up Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, 
		Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
    />
    <!-- /meta tags -->
    <!-- custom style sheet -->
    <link href="web/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- /custom style sheet -->
    <!-- fontawesome css -->

    <link href="web/css/fontawesome-all.css" rel="stylesheet" type="text/css"/>
    
    <!-- /fontawesome css -->
    <!-- google fonts-->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- /google fonts-->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <script src="Js/IniciarSesion.js" type="text/javascript"></script>
        <script src="Js/RecuperarContraseña.js" type="text/javascript"></script>
         <link rel="icon" href="Imagenes/logopropi.png" src=""/>
</head>
<script>
      function mostrarContrasena(){
      var tipo = document.getElementById("txtPassword");
       var ojo = document.getElementById("imgOjo");
      
      if(tipo.type === "password"){
          tipo.type = "text";
           ojo.style.display='none';
      }else{
          tipo.type = "password";
          ojo.style.display='block';
      }
  }
</script>

<body>
    <h1>Pro-Piscinas del Huila S.A.S</h1>
    <div class=" w3l-login-form">
        <h2 style="color:#007bff !important;">Inicia Sesión</h2>
       <form name="frmIniciarSesion" id="frmIniciarSesion" method="POST" action="../ControllerUsuario">
  <input type="hidden" name="accion" id="accion" value="IniciarSesion">
            <div class=" w3l-form-group">
                <label>Usuario:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
                    <input type="text"  id="txtLogin" name="txtLogin"  autocomplete="off" placeholder="Usuario" required="required" />
                </div>
            </div>
            <div class=" w3l-form-group">
                <label>Contraseña:</label>   <img  style=" position: absolute;
    width: 29px;
    height: 30px;
    margin-left: 357px;
    margin-top: 16px;
    cursor: pointer; z-index: 2; background-color: white;" id="imgOjo" onclick="mostrarContrasena()" src="Imagenes/ojoCerrado.png" width="300" height="300" alt=""/>
                <img  style=" position: absolute;
    width: 29px;
    height: 30px;
    margin-left: 357px;
    margin-top: 16px;
    cursor: pointer; " onclick="mostrarContrasena()" src="Imagenes/ojoAbierto.png" width="300" height="300" alt=""/>
                <div class="group">
                    <i class="fas fa-unlock"></i>
                    
                    <input id="txtPassword" name="txtPassword" autocomplete="off" type="password"  placeholder="Contraseña" required="required" />
                </div>
            </div>
              <div style="text-align: center;" class="mensaje1">
        <%
            try {
                      
                    String valor=request.getParameter("valor");
                    
                   if(valor!=null){
                        out.print("Usuario o contraseña incorrecto");
                   }
            
                } catch (Exception e) {
                    
                }
        %>
        </div>
            
            <div class="forgot">
                <a href="#" id="btnRecuperar">¿Se te olvidó tu contraseña?</a>
               
            </div>
        <button type="submit" name="btnIniciarSesion" id="btnIniciarSesion" >Iniciar sesión</button>
        </form>
        <p class="w3l-register-p">¿No tienes una cuenta?<a href="#" id="btnAbrirRegistrar" class="register">  Registrarse</a></p>
    </div>
    <footer>
        <p class="copyright-agileinfo"> &copy; 2020 Pro-Piscinas del Huila S.A.S | Hecho por   <a style="color: #12325e;">Eddy Santiago Obregon</a></p>
    </footer>
<div class="modal" id="modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >Registrarse</h4>
                        <button type="button"  style="height: 32px;width: 82px;" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <div class="modal-body">
                      
                            <thead>
                                
                            </thead>
                            <form>
                                            <tr style="height: 40px;">
                        <td class="negrita"><font color="black">Nit de la empresa</font></td>
                         <td><input  style="outline: auto; outline-color: dodgerblue;" required type="number" name="txt_Nit"  id="txt_Nit" class="form-control"  required>
                         <div class="requerimientos"  id="msjNit" style="text-align: center"></div>
                      </td>
                    </tr>
                        <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Identificacion:</font></td>
                        <td><input style="outline: auto;outline-color: dodgerblue;" required class="form-control"type="number" id="txt_Identificacion">
                          <div class="requerimientos"  id="msjIdentificacion" style="text-align: center"></div>         
                        </td>
                    </t  <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Nombre:</font></td>
                        <td><input  style="outline: auto;outline-color: dodgerblue;" required type="text"  id="txt_Nombre"class="form-control">
                           <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>      
                        </td>
                    </tr>
                    
                        <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Telefono</font></td>
                        <td><input  style="outline: auto;outline-color: dodgerblue;" required type="number"   id="txt_Tel"class="form-control">
                            <div class="requerimientos"  id="msjTelefono" style="text-align: center"></div>     
                        </td>
                    </tr>
                       <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Correo</font></td>
                       <td><input   style="outline: auto;outline-color: dodgerblue;" required type="email" id="txt_Correo" class="form-control">
                           <div class="requerimientos"  id="msjCorreo" style="text-align: center"></div>    
                        </td>
                  
                      </form>
                       
                    </div>
                    <div class="modal-footer">
                        <button style="background-color: #007bff;color: #fff;" type="button" class="btn" id="btnRegistrar" class="btnRegistrar" >Registrar</button>
                     
                        <button style="background-color: #007bff;color: #fff;" onclick="limpiarModal()" type="button" class="btn" data-dismiss="modal">Cerrar</button>
                       
                    </div>
                </div>
            </div>
         
        </div>
          <div class="modal w-100" id="modalRecuperClave">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4  class="modal-title" >Recuperar contraseña</h4>
                        <button type="button"  style="height: 32px;width: 82px;" onclick="limpiarModal()" class="text-white close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <div class="modal-body">
                      
                            <thead>
                                
                            </thead>
                            <form>
                                         
                    
                        <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Identificacion:</font></td>
                        <td><input style="outline: auto;outline-color: dodgerblue;" name="txtIdentificacion" id="txtIdentificacion" required class="form-control"type="number" id="txt_Identificacion">
                          <div class="requerimientos"  id="msjIdentificacion" style="text-align: center"></div>         
                        </td>
                    </t  <tr style="height: 40px;">
                       <td class="negrita"><font color="black">Ingrese su correo electronico:</font></td>
                        <td><input  style="outline: auto;outline-color: dodgerblue;" required type="text"  itype="email" name="txtCorreo" id="txtCorreo" class="form-control">
                           <div class="requerimientos"  id="msjNombre" style="text-align: center"></div>      
                        </td>
                    </tr>
               
                      </form>
                       
                    </div>
                    <div class="modal-footer">
                        <button style="background-color: #007bff;color: #fff;" type="button" class="btn"  id="btnRecuperarClaveModal" class="btnRegistrar" >Recuperar contraseña</button>
                     
                        <button style="background-color: #007bff;color: #fff;" onclick="limpiarModalRecuperar()" type="button" class="btn" data-dismiss="modal">Cerrar</button>
                       
                    </div>
                </div>
            </div>
                                              

            </div>
</body>

</html>