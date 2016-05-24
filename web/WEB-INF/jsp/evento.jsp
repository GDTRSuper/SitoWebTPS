<%-- 
    Document   : evento
    Created on : 8-mar-2016, 9.43.53
    Author     : FSEVERI\trovo2987
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="it">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Evento</title>

        <!-- Bootstrap Core CSS -->
        <link href="./res/css/bootstrap.min.css" rel="stylesheet">
        <script src="./res/js/jquery.js"></script>
        <!-- Custom CSS -->
        <link href="./res/css/evento.css" rel="stylesheet">
        
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

                <div class="col-md-12">

                    <div class="row">

                        <div class="col-md-12">
                            <div class="thumbnail">
                                <img src="${evento.getImmagine()}" style="height: 400px" alt="${evento.getTitolo()}">
                                <div class="evento">
                                    <h3 class="pull-right">${evento.creatore.nickname}</h3>
                                    <h3><a href="">${evento.titolo}</a></h3>
                                    <h5>Categoria: ${evento.categoria.nome}</h5>
                                    <p>Descrizione: ${evento.descrizione}<br/><br/>Si terrà a ${evento.luogo} il ${evento.data}<br/> </p>
                                    <p>Artisti partecipanti: 
                                        <c:forEach items="${evento.artistiCollection}" var="artista">
                                           ${artista.nomeArte}
                                        </c:forEach>
                                    </p>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">${evento.getNumCommenti()} Commenti</p>
                                    <p>Rating   
                                    <c:forEach begin="1" end="${evento.getMedia()}">
                                    <span class="glyphicon glyphicon-star"></span> </c:forEach>
                                    <c:forEach begin="${evento.getMedia()}" end="4">
                                    <span  class="half glyphicon glyphicon-star-empty"></span> </c:forEach>
                                    </p>
                                </div>

                            </div>
                            
                            <!-- Leave a comment -->
                            <div class="well">
                                <h4>Leave a Comment:</h4>
                                <form role="form" action="./aggiungiCommento" method="POST">
                                    <div class="form-group">
                                        <textarea class="form-control" rows="3" name="nuovoCommento"></textarea>
                                        <br/>
                                        <p class="rating">
                                            <label>Inserisci il numero di stelle: </label>
                                            <span id="star1" class="ratings_star glyphicon glyphicon-star" data-rating="1"></span>
                                            <span id="star2" class="ratings_star glyphicon glyphicon-star-empty" data-rating="2"></span>
                                            <span id="star3" class="ratings_star glyphicon glyphicon-star-empty" data-rating="3"></span>
                                            <span id="star4" class="ratings_star glyphicon glyphicon-star-empty" data-rating="4"></span>
                                            <span id="star5" class="ratings_star glyphicon glyphicon-star-empty" data-rating="5"></span>
                                        </p>
                                        <input type="hidden" id="rating" name="rating" value="1">
                                        <input type="hidden" id="evento" name="evento" value="${evento.id}">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </form>
                            </div>

                            <hr>

                            <!-- Posted Comments -->

                            <!-- Comment -->
                            <c:forEach items="${evento.commentiCollection}" var="commento">
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                                    </a>
                                    <div class="media-body">
                                        <a href="./user?nick=${commento.utente.nickname}">
                                        <h4 class="media-heading">${commento.utente.nickname}
                                        </a>
                                            <small class="ratings">
                                                <c:forEach begin="1" end="${commento.voto}">
                                                    <span class="glyphicon glyphicon-star"></span> </c:forEach>
                                                <c:forEach begin="${commento.voto}" end="4">
                                                    <span  class="half glyphicon glyphicon-star-empty"></span> 
                                                </c:forEach>
                                            </small>
                                        </h4>
                                        ${commento.testo}
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div class="container">
            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; GDTRSuper</p>
                    </div>
                </div>
            </footer>
        </div>
<!-- /.container -->

<!-- jQuery -->
<script src="./res/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="./res/js/bootstrap.min.js"></script>
        <script src="./res/js/rating-comment.js"></script>
</body>
</html>
