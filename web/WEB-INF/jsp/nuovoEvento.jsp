
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- Custom CSS -->
        <link href="./res/css/evento.css" rel="stylesheet">


    </head>

    <body>

        <jsp:include page="menu.jsp"/>

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form class="form-horizontal" method="get" action="./aggiungiEvento">
                        <fieldset>
                            <legend>Nuovo Evento</legend>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Titolo</label>
                                <div class="col-lg-10">
                                    <input type="text" name="titolo" class="form-control" id="inputTitle" placeholder="Titolo evento..." required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Data</label>
                                <div class="col-lg-10">
                                    <input type="date" name="data" class="form-control" id="inputData" placeholder="Data evento..." required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Luogo</label>
                                <div class="col-lg-10">
                                    <input type="text" name="luogo" class="form-control" id="inputLuogo" placeholder="Luogo evento..." required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Immagine</label>
                                <div class="col-lg-10">
                                    <input type="link" name="immagine" class="form-control" id="inputImmagine" placeholder="Inserisci il link all'immagine dell'evento..." required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Descrizione</label>
                                <div class="col-lg-10">
                                    <textarea name="descrizione" class="form-control" rows="3" id="textArea" required></textarea>
                                    <span class="help-block">Inserisci la descirzione dell'evento.</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="select" class="col-lg-2 control-label">Selects</label>
                                <div class="col-lg-10">
                                    <select name="categoria" class="form-control" id="select">
                                        <c:forEach items="${categorie}" var="categoria">
                                            <option  value="${categoria.id}">${categoria.nome}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Artisti</label>
                                <div class="col-lg-10">
                                    <select name="artisti" multiple="" class="form-control">
                                        <c:forEach items="${artisti}" var="artista">
                                            <option  value="${artista.id}">${artista.nomeArte}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="reset" class="btn btn-default">Cancella</button>
                                    <button type="submit" class="btn btn-primary">Invia</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
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
