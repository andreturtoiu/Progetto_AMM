<%-- 
    Document   : filterJasonGroups
    Created on : 15-lug-2017, 18.22.21
    Author     : Andreea
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="group" items="${listaGruppi}">
        <json:object>
            <json:property name="nome" value="${group.nome}"/>
            <json:property name="id" value="${group.id}"/>
            <json:property name="urlFotoProfilo" value="${group.urlImmagine}"/>
        </json:object>
    </c:forEach>
</json:array>

