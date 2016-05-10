<%-- 
    Document   : ModificaInformazioni
    Created on : 7-mag-2016, 12.00.42
    Author     : FSEVERI\reccanello2998
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./res/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form class="form-horizontal">
                        <fieldset>
                            <legend>Modify personal information</legend>
                            <div class="form-group">
                                <label  class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="${utente.email}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-lg-2 control-label">Nome</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="inputName" placeholder="${utente.nome}">

                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-lg-2 control-label">Cognome</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="inputSurname" placeholder="${utente.cognome}">    
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5 col-lg-offset-2">
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>

                <div class="col-lg-6">
                    <form class="form-horizontal" method="POST" action="./controllaPassword">
                        <fieldset>
                            <legend>Modify account password</legend>
                            <p style="text-align:centre ">${risposta}</p>
                            <div class="form-group">
                                <label  class="col-lg-3 control-label">Old Password</label>
                                <div class="col-lg-9">
                                    <input type="password" name="oldPsw" class="form-control" id="inputOldPassword">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-lg-3 control-label">New Password</label>
                                <div class="col-lg-9">
                                    <input type="password" name="newPsw" class="form-control" id="inputNewPassword">

                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-lg-3  control-label">Repeat Password</label>
                                <div class="col-lg-9">
                                    <input type="password" name="repeatPsw" class="form-control" id="repeatNewPassword">    
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5 col-lg-offset-3">
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div> 
        </div>
    </body>
</html>
