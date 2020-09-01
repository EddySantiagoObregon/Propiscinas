/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
movimientos =[];
$(function(){

               var parametros = {
               accion: "listarMovimiento"
              
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 
   
            
            var pag = 1;
            var totales = movimientos.length;
            var xPag = 3;
            var nPag = Math.ceil(totales / xPag);
            var offset = (pag - 1) * xPag;
            var hasta = pag * xPag;
            
            function mostrarLista(desde,hasta){
            
                var lista = '';
                for(var i = desde; i < hasta; i++){
                    var fila = ''; 
                    fila += "<tr>";
                    fila += "<td>"+movimientos[i].unaInfraestructura.descripcion+"</td>";
                    fila += "<td>"+movimientos[i].unaTransaccion.descripcion+"</td>";
                    fila += "<td>"+movimientos[i].unDetalleProducto.nombre+"</td>";
                    fila += "</tr>";
                    lista += fila;
                }
                $('#listado').html(lista);
            }
            
            function mostrarBotones(t){
                var botones = '';
                for(var i = 0; i < t; i++){
                    var cada = '';
                    cada = "<button type='button' "+
                        "class='btn btn-info'>"+(i+1)+
                        "</button>";
                    botones += cada;
                }
                
                $('#botones').append(botones);
            }
            
            function quitarActivo(){
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    $(losBotones[i]).removeClass('active');
                }
            }
            
            mostrarLista(offset,hasta);
            mostrarBotones(nPag);
            
            $( document ).ready(function(){
                // Activar el primer botón
                $('#botones button:first-child').addClass('active');
                
                // Poner oyentes a cada botón
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    losBotones[i].addEventListener('click',function(){
                        quitarActivo();
                        var indice = parseInt(this.textContent);
                        var o = (indice -1) * xPag;
                        var h = indice * xPag;
                        mostrarLista(o,h);
                        $(this).addClass('active');
                    });
                }
            });
                     }
    });
});
