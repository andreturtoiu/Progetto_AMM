/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Creo utente
function createElementUser(usr){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",usr.urlFotoProfilo);
    
    var link = $("<a>")
            .attr("href", "bacheca.html?user="+usr.id)
            .html(usr.nome + " " + usr.cognome);
  
    var userData = $("<div>")
             .attr("class","userData")
             .append(img)
             .append(link);

    return $("<li>")
            .append(userData);
}

function createElementGroup(grp){
    var img = $("<img>")
            .attr("alt","Foto")
            .attr("src",grp.urlFotoProfilo);
    var link = $("<a>")
        .attr("href", "bacheca.html?group="+grp.id)
        .html(grp.nome);

    return $("<li>")
         .append(img)
         .append(link);
}


function stateSuccessUser(data){
    //Funzione successo utente
    var title = $("<h3>")
                .html("Amici"); 
    var userList = $("#user");
    
    var lista = $("<ul>");
    $(userList).empty();
    $(userList).append(title);
    
    if(data[0].vuota === "true")
        $(userList)
            .append($("<p>")
            .html("User not found"));
   else
        for(var instance in data){
            $(lista).append(createElementUser(data[instance]));
    }
    $(userList).append(lista);
}


function stateSuccessGroup(data){

    //Successo gruppo
    var title = $("<h3>")
            .html("Gruppi"); 
    var groupList = $("#group");
    
    var listaGruppi = $("<ul>");
    $(groupList).empty();
    $(groupList).append(title);
    if(data[0].vuotaGruppi === "true")
        $(groupList)
            .append($("<p>")
            .html("Group not found"));
    else
        for(var instance in data){
            $(listaGruppi).append(createElementGroup(data[instance]));
        }
    $(groupList).append(listaGruppi);   
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchFriends").keyup(function(){
        
        var wanted = $("#searchFriends")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                cmd:"search",
                nomeAmico: wanted 
            },
            dataType:"json",
            success: function(data, state){
                stateSuccessUser(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
       
        $.ajax({
            url: "filterGruppi.json",
            data:{
                cmd:"search",
                nomeAmico: wanted
            },
            dataType:"json",
            success: function(data, state){
                stateSuccessGroup(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });

    });
    

});




