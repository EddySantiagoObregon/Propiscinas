/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function(){
  
    $("#btnEditarContrasena").click(function(){
        alert("HOLA");
       EditarContrasena();
    });
});
function EditarContrasena(){
    var parametros={
           accion: 'EditarContrasena',
           contrasenaNueva:$("#password").val(),
           contrasenaAntigua: $("#passwordd").val(),
           correoDeBusqueda:$("#Correo").val()
    };
     $.ajax({
                url: '../ControllerUsuario',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                        
                            alert("Contraseña actualizada correctamente");
                            $("#passwordd").val("");
                            $("#password").val("");
                           
                    }else{
                            alert("Problemas al actualizar la contraseña");
                    }
                    
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
