<%-- 
    Document   : search
    Created on : 15-mar-2016, 8.43.46
    Author     : FSEVERI\depaula2995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-sm-3 col-md-3 pull-right">
    <form class="navbar-form" role="search" action="./search" method="GET">
        <div class="input-group">
            <div id="remote">
                <input class="typeahead" type="text" placeholder="Cerca" name="srch-term" id="query">
            </div>
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>
</div>