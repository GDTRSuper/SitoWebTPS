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
                <% if (session.getAttribute("utente") != null && !session.getAttribute("utente").toString().equals("")) {

                        out.println("<li><a href='./logout'>Logout</a></li>");
                    } else {%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                    <ul id="login-dp" class="dropdown-menu">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form" role="form" method="post" accept-charset="UTF-8" id="login-nav">
                                        <div class="form-group">
                                            <label class="sr-only">Username</label>
                                            <input type="text" class="form-control" name="username" id="user" placeholder="Username" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only">Password</label>
                                            <input type="password" class="form-control" name="password" placeholder="Password" id="pass" required>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block" id="loginButton">Log in</button>
                                        </div>
                                        <div style="text-align:center"> <br> <b>Oppure</b><div>
                                                <a href="./register" class="text-center new-account"><h4>Crea un account</h4> </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
                <% }
                %>
            </ul>
            <%@include file="search-field.jsp" %>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <script>
        $('document').ready(function () {
            $('loginButton').click(function () {
                
                var username = $("input#user").value();
                var password = $("input#pass").value();
                
                $.ajax({
                    method: "POST",
                    url: "./checklogin",
                    data: {username: username, location: password}
                })
                        .done(function (msg) {
                            alert("Data Saved: " + msg);
                        });
            });
        });


    </script>
    <!-- /.container -->
</nav>