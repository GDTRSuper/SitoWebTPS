<%@page import="it.severi.gdtrsuper.db.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sito TPS</title>

        <!-- Bootstrap Core CSS -->
        <link href="./res/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./res/css/typeAhead.css" rel="stylesheet">
        <link href="./res/css/shop-homepage.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

<jsp:include page="menu.jsp" />
        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <p class="lead">Shop Name</p>
                    <div class="list-group">
                        <c:forEach items="${cats}" var="cat">

                            <a href="./categoria?id=${cat.id}" class="list-group-item">${cat.getNome()}</a>
                        </c:forEach>
                    </div>
                </div>

                <div class="col-md-9">

                    <div class="row carousel-holder">

                        <div class="col-md-12">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <c:forEach items="${ultimiEventi}" var="evento">
                                        <li data-target="#carousel-example-generic" data-slide-to="0" class="<c:if test="${evento.id == 1}">active</c:if>"></li>

                                    </c:forEach>



                                </ol>
                                <div class="carousel-inner">
                                    <c:forEach items="${ultimiEventi}" var="evento">
                                        <div class="item<c:if test="${evento.id == 1}"> active</c:if>" style="height: 350px">
                                            <img class="slide-image"  src="${evento.immagine}" style="height: inherit" alt="${evento.titolo}">
                                            <img class="slide-image" width="800" height="300" src="${evento.immagine}" alt="">
