<%-- 
    Document   : index
    Created on : 13/05/2016, 21:31:44
    Author     : ADILSON
--%>

<%@page import="Entidade.Movimentacao"%>
<%@page import="Entidade.Controller"%>
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
        
        <div>
            <div class="row">
                <div role="main" class="col-md-8">
                    
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Tipo</th>
                                <th>Categoria</th>
                                <th>Data</th>
                                <th>Valor (R$)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Movimentacao m : Controller.ListarMovimentos()){ %>
                            <tr>
                                <td><% out.print(m.getTipo()); %></td>
                                <td><% out.print(m.categoria.getNome()); %></td>
                                <td><% out.print(m.getData()); %></td>
                                <td>R$ <% out.print(m.getValor()); %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                        
                </div>
                <aside role="complementary" class="col-md-4">

                </aside>
            </div>
        </div>
    </body>
</html>
