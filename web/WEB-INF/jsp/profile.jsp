<%-- 
    Document   : profile
    Created on : 12-mar-2016, 11.29.15
    Author     : FSEVERI\depaula2995
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${utente.nome} - Profilo Utente</title>

    <!-- Bootstrap Core CSS -->
    <link href="./res/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./res/css/portfolio-item.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

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
                <a class="navbar-brand" href="#">Start Bootstrap</a>
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
                </ul>
                <%@include file="search-field.jsp" %>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Portfolio Item Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${utente.nome}
                    <small>@${utente.nickname}</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">           
            
            
            <div class="col-md-8">
                <img class="img-responsive" src="http://placehold.it/300x300" alt="">
            </div>
            
            <div class="col-md-4">
                   <h3>Categorie di interesse:</h3>
                <ul>
                    <c:forEach items="${categorie}" var="categoria">
                        <li>
                            <a href="./categoria?id=${categoria.id}">
                                
                                <c:out value="${categoria.nome}"></c:out>
                            
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                
            </div>

            <div class="col-md-8">
                <h3>Descrizione Profilo</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>

            </div>


        </div>
        <!-- /.row -->

        <!-- Informazioni utente -->
        <div>
            
        </div>
        <!-- /.row -->
           
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>
        <a href="./modify">Modifica informazioni<a>
    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="./res/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./res/js/bootstrap.min.js"></script>

</body>

</html>