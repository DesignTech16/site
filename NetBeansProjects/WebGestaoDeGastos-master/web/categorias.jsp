<%-- 
    Document   : categorias
5
    Created on : 13/05/2016, 23:52:52
    Author     : ADILSON
--%>

<%@page import="model.Controller"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="content/css/bootstrap.min.css"/>
        <title>Controle de Gastos</title> 
    </head>
    <body class="container">
        
        <header>
            <nav class="navbar navbar-full navbar-light bg-faded" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="index.jsp">Controle de Gastos</a>
                <ul class="nav navbar-nav" style="float:right;">
                    <li><a href="index.jsp">Página Inicial</a></li>
                    <li><a href="movimentacao.jsp">Nova Movimentação</a></li>
                    <li><a href="categorias.jsp">Minhas Categorias</a></li>
                </ul>
            </nav>
        </header>
        
        <div class="col-md-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                    <%
                        
                        Controller controller = new Controller();
                        for(Categoria c : controller.ListarCategorias())
                    { %>
                    <tr>
                        <td><% out.print(c.getNome()); %></td>
                        <td><a href="#">Excluir</a></td>
                    </tr>
                    <% } %>
            </table>
        </div>
    </body>
</html>