<%-- 
    Document   : ImprimirEtiquetasCodigoBarras
    Created on : 5/08/2020, 10:27:24 AM
    Author     : PAULA
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ImprimirCodigoBarras</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="bootstrap.bundle.min.js / bootstrap.bundle.js"></script>
        <link href="Css/AgregarProducto.css" rel="stylesheet" type="text/css"/>
        <script src="Js/GenerarCodigosBarra.js" type="text/javascript"></script>
        <script src="Js/MenuPrincipal.js" type="text/javascript"></script>
         <script src="Js/jsAutocomplete.js" type="text/javascript"></script>
    </head>
   
    <body>
       <header>

             
                    
            
              
		
	</header>
                   <script>
                       $(function(){
                          $('#modal').modal({backdrop: 'static', keyboard: false});
                          $("#modal").modal(); 
                       });
                       </script>
                   
                       <div class="modal" id="modal" style="">
           <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 702px;
    height: 697px;
    right: 98px;
    margin-top: 43px;">
       <div style="color: white; background-color: #007bff; "class="modal-header  text-white">
                        <h4 class="modal-title" >GENERAR CODIGOS DE BARRAS</h4>
                        
                    </div>
        <div style="margin-top: 0px;   padding-top: 0px;" class="modal-body">
        <form>
            <a style="margin-bottom: 30px;
    padding-top: 2px;
    padding-bottom: 4px;
    margin-left: 143px;
    margin-top: 44px;" class="btn btn-primary btnListar" id="btnGenerarTodos"><img width="55" height="30" src="Imagenes/cod.png"/>Generar todos los de codigos de barras</a>
          
    <a style="    background-color: white;
    color: #d2d2d2;
    margin-top: 1px;
    border-bottom-width: 30px;
    margin-bottom: 55px;">_____________________________________________________________________________________________________</a>
          <div style="height: 60px;" class="form-group">
              <label for="message-text" class="col-form-label" style="margin-left: 190px;
    margin-top: 39px;">Generar codigos de barra por grupo:</label>
          <select style="width: 360px;
    margin-left: 140px;     
  
    border-color: #d2d2d2;" name="cb_Grupo" id="cb_Grupo" class="btn">
                                <option value="0">Seleccione</option>
					</select> 
          </div>
            <a id="btnGenerCodigoBarrasPorGrupo" style="    margin-top: 49px;
    margin-left: 286px;
    color: white;"class="btn btn-primary">Generar</a>
      <a style="    background-color: white;
    color: #d2d2d2;
    margin-top: 1px;
    border-bottom-width: 30px;
    margin-bottom: 55px;">_____________________________________________________________________________________________________</a>
    <br>
   
    
    <a style="margin-left: 143px;"><h6 style="margin-left: 194px;">Codigo de barra independiente</h6></a>
    <a style="margin-left: 143px;">Ingrese el código para generar el código de barras</a>
    <br>
    <input style="    width: 362px;
           margin-left: 140px; margin-bottom: 2px;"type="number" placeholder="INGRESE CODIGO" id="txt_Codigo" class="form-control">
     <input style="    width: 362px;
           margin-left: 140px;"type="number" placeholder="CANTIDAD QUE IMPRIMIRA" id="txt_Cantidad" class="form-control">
      <a id="btnGenerCodigoBarrasIndenpendiente" style="    margin-top: 9px;
    margin-left: 286px;
    color: white;"class="btn btn-primary">Generar</a>
        </form>
      </div>
       
      <div class="modal-footer">
         
                     
                        <a style="background-color: #007bff;color: #fff;" class="btn btn-primary" href="ListarProducto.jsp" type="button" >Regresar</a>
                       
      </div>
    </div>
  </div>
</div>
	
    </body>
</html>
