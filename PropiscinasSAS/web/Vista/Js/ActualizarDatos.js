/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    $("#btnActualizarDatos").click(function(){
        ActualizarDatos();
    });
    $("#btnActualizarContrasena").click(function(){
       
    });
});
function ActualizarDatos(){
    var parametros={
           accion: 'ActualizarDatos',
           identificacion:$("#txt_Identificacionnn").val(),
           nombre: $("#txt_Nombreee").val(),
           telefono:$("#txt_Telefonooo").val(),
           correo:$("#txt_Correooo").val(),
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
                            alert("Actualizado correctamente");
                            var correo = $("#txt_Correooo").val();
                            var correoBusqueda =$("#Correo").val();
                             var nombre=$("#txt_Nombreee").val();
                              $("#perfilNombre").html(" ");
                            $("#perfilNombre").html(nombre);
                            if(correo!==correoBusqueda){
                                 location.href="Salir.jsp";
                            }
                           
                    }else{
                            alert("Problemas al actualizar");
                    }
                    
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
