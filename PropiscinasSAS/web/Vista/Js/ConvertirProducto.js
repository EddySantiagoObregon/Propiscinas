/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    var correo = $("#Correo").val();
    listarInfraestructura();
    listarProductoConvertir();
    
    $("#btnConvertir").click(function(){
        convertirPro(correo);
    });
    $("#cb_ProductoConvertir").change(function(){
       var numero = $("#cb_ProductoConvertir").val();
        if(numero>0){ 
        $("#txt_Convertir").empty();
          
            text = $("#cb_ProductoConvertir option:selected").text();

           
      $("#txt_Convertir").val("7 BOTELLAS DE "+text+" DE 500 MILILITROS");
        }else{
            $("#txt_Convertir").val(" ");
        }
    });
    
});

function listarProductoConvertir()
{
    var parametros=
            {
                accion:"listarProductoConvetirCb"
            };
            $.ajax({
               url: '../ControllerProductoConvertir' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var ProductosConvetir = resultado;
                   $.each(ProductosConvetir,function(i,productoConventir)
                   {
                       
                       $('#cb_ProductoConvertir').append(
                         $('<option>',{
                            
                            value: productoConventir.idProductoConvertir,
                            text: productoConventir.nombre
                        })
                      );
                   });
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
}

    
//Esta funcion lo que hace es listar todas las infraestructuras
function listarInfraestructura()
{
    var parametros=
            {
                accion:"ListarInfraestructura"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var infraestructuras = resultado;
                   $.each(infraestructuras,function(i,infraestructura)
                   {
                       
                       $('#cb_Infraestructura').append(
                         $('<option>',{
                            
                            value: infraestructura.idInfraestructura,
                            text: infraestructura.descripcion
                        })
                      );
                   });
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
    }
function convertirPro(correo)
{
    var numeroDocumentoo=$("#txt_NumeroDocumento").val();
    var observacionDocumentoo=$("#txt_observacionDocumento").val();
    if(numeroDocumentoo!==""&&observacionDocumentoo!==""){
         
        var parametros=
            {
                accion: "CovertirProducto",
                txt_Correo:correo,
                cb_ProductoConvertir:$("#cb_ProductoConvertir").val(),
                cb_Infraestructura:$("#cb_Infraestructura").val(),
                numeroDocumento:$("#txt_NumeroDocumento").val(),
                observacionDocumento:$("#txt_observacionDocumento").val()
                
                
         
            };
            $.ajax({
                url: '../ControllerProductoConvertir',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      alert("LA CANTIDAD DEL PRODUCTO SE CONVIRTIO");
                      
                } else{
                    alert("NO HAY CANTIDAD DE ESTE PRODUCTO EN ESTA INGRAESTURA PARA PODER CONVERTIRSE!");
                }
                    
 
                },
                error:function(ex)
                {
                     alert("ESTE PRODUCTO NO HAY EN BODEGA");
                    console.log(ex);
                }
            });
        }else{
            alert("TODOS LOS CAMPOS SON REQUERIDOS");
        }
}
