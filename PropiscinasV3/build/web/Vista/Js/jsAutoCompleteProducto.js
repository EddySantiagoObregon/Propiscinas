/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


      $(function (){   
                  
                    var availableTags= new Array();
                    $("#txt_Buscar").bind("keydown",function(event){
                        var data ={nombre:$("#txt_Buscar").val()};
                        var url="../AutocompletarProducto";
                        $.getJSON(url,data,function (res,est,jqXHR){   
                            availableTags.length=0;
                            $.each(res,function (i,item){
                                availableTags[i]=item;
                            });                            
                        });
                    });
                    
                    $("#txt_Buscar").autocomplete({
                        source:availableTags,
                        minLength:1
                        
                    });
                });
                
