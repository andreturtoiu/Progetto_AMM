<%-- 
    Document   : filterJason
    Created on : 31-mag-2017, 20.48.46
    Author     : Andreea
--%>
 
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="user" items="${listaAmici}">
        <json:object>
            <json:property name="nome" value="${user.nome}"/>
            <json:property name="cognome" value="${user.cognome}"/>
            <json:property name="id" value="${user.id}"/>
            <json:property name="email" value="${user.email}"/>
            <json:property name="password" value="${user.password}"/>
            <json:property name="urlFotoProfilo" value="${user.urlFotoProfilo}"/>
            <json:property name="fraseDescrizione" value="${user.fraseDescrizione}"/>
            <json:property name="dataNascita" value="${user.dataNascita}"/>
        </json:object>
    </c:forEach>
</json:array>

