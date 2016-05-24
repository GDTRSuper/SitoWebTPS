<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if (session.getAttribute("utente") != null) {%>
<c:redirect url="./"/>                
<%}%>
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

<jsp:include page="menu.jsp"/>

<body>

    <div class="container">
        <div class="row" style='margin-top:50px'>
            <div class="col-lg-12">
                <form class="form-horizontal" action='./register' method="POST">

                    <div id="legend">
                        <legend class="">Register</legend>
                    </div>

                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="name">Nome</label>
                        <div class="controls">
                            <input type="text" id="username" name="nome" placeholder="Nome" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="surname">Cognome</label>
                        <div class="controls">
                            <input type="text" id="username" name="cognome" placeholder="Cognome" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="username">Username</label>
                        <div class="controls">
                            <input type="text" id="username" name="username" placeholder="Username" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="Password" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <%
                            if (request.getParameter("exists") != null && request.getParameter("exists").equals("true")) {
                                out.print("<h4 style='text-align:left;color:red'>L'username non è disponibile</h4>");
                            }
                            if (request.getParameter("fields") != null && request.getParameter("fields").equals("true")) {
                                out.print("<h4 style='text-align:left;color:red'>Devi riempire tutti i campi</h4>");
                            }

                        %>
                        <!-- Button -->
                        <div class="controls">
                             <br>
                            <button class="btn btn-success">Register</button>
                        </div>
                    </div>

                </form>

            </div>

        </div>
    </div>
        <script src="./res/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>



