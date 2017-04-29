<%-- 
    Document   : sidebar
    Created on : 29-apr-2017, 16.37.11
    Author     : Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div id="sideBar">
            <div id="user">                
                <h3>Utenti</h3>
                <ul>
                    <li>
                        <img alt="Foto" src="img/bunny.jpg">
                        <a href="Bacheca?user=0">Bugs Bunny</a>
                    </li>
                    <li>
                        <img alt="Foto" src="img/images.jpg">
                        <a href="Bacheca?user=1">Deadpool</a>
                    </li>
                    <li>
                        <img alt="Foto" src="img/images1.jpg">
                        <a href="Bacheca?user=2">Jerry</a>
                    </li>
                </ul>      
            </div>

            <div id="group">
                <h3>Gruppi</h3>
                <ul>
                    <li><img alt="Foto" src="img/cn.png">CartoonNetwork</li>
                    <li><img alt="Foto" src="img/marvel.jpg">Marvel</li>
                </ul>
            </div>       
</div>
