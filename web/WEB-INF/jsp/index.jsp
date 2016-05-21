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

        <!-- Custom CSS -->  <!-- jQuery -->
        <script src="./res/js/jquery.js"></script>
        <link href="./res/css/shop-homepage.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

<%@include file="menu.jsp" %>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./">Home Page</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">About</a>
                        </li>
                        <li>
                            <a href="#">Services</a>
                        </li>
                        <li>
                            <a href="#">Contact</a>
                        </li>
                        <li>
                            <a href="./user?nick=bruno">Profile</a>
                        </li>
                    </ul>
                    <%@include file="search-field.jsp" %>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

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
                                        <div class="item <c:if test="${evento.id == 1}">active</c:if> ">
                                            <img class="slide-image" width="800" height="300" src="${evento.immagine}" alt="">
                                        </div>
                                    </c:forEach>


                                </div>


                                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>

                    </div>


                    <div class="row">
                        <c:forEach items="${ultimiEventi}" var="evento">
                            <div class="col-sm-4 col-lg-4 col-md-4">
                                <div class="thumbnail">
                                    <img src="${evento.getImmagine()}" alt="">
                                    <div class="caption">
                                        <h4 class="pull-right">${evento.creatore.nome}</h4>
                                        <h4><a href="./evento?id=${evento.id}">${fn:substring(evento.titolo, 0, 20)}</a></h4>
                                        <h5>${evento.categoria.nome}</h5>
                                        <p>${evento.descrizione}</p>
                                    </div>
                                    <div class="ratings">

                                        <p class="pull-right"> ${evento.getNumCommenti()} commenti</p>
                                        <p>
                                            <c:forEach begin="1" end="${evento.getMedia()}">
                                                <span class="glyphicon glyphicon-star"></span> </c:forEach>
                                            <c:forEach begin="${evento.getMedia()}" end="4">
                                                <span  class="half glyphicon glyphicon-star-empty"></span> </c:forEach>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                        </c:forEach>



                    </div>

                </div>

            </div>

        </div>
        <!-- /.container -->
        <c:forEach items="${artisti}" var="artista">
            ${artista.nome} ${artista.cognome}
        </c:forEach>
        <div class="container">

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Your Website 2014</p>
                    </div>
                </div>
            </footer>

        </div>
        <!-- /.container -->

        <!-- Bootstrap Core JavaScript -->
        <script src="./res/js/bootstrap.min.js"></script>

    </body>
</html>
