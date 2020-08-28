/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var unmed="";
$(function ()
{


   
   $('#btnAgregarProveedor').click(function(){ 
 
        AgregarProveedor();
      
   }); 
});


function AgregarProveedor(){
         
        var parametros=
            {
                accion: "AgregarProveedor",
                txt_Nit: $("#txt_Nit").val(),
                txt_Nombre:$("#txt_Nombre").val(),
                txt_Telefono:$("#txt_Telefono").val(),
                txt_Correo:$("#txt_Correo").val()
                
         
            };
            $.ajax({
                url: '../ControllerProveedor',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                      alert("SE REGISTRO CORRECTAMENTE");
                  limpiarModal();
                } else{
                    alert("NIT O IDENTIFICACIÓN YA EXISTEN");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}

function limpiarModal(){
    
      $("#txt_Nit").val("");
      $("#txt_Nombre").val("");
      $("#txt_Telefono").val("");
       $("#txt_Correo").val("");
       
}