<%-- 
    Document   : index
    Created on : 13/05/2016, 21:31:44
    Author     : ADILSON
--%>

<%@page import="ws.wsCategoria"%>
<%@page import="model.Movimentacao"%>
<%@page import="model.Controller"%>
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
                                <th>Descrição</th>
                                <th>Data</th>
                                <th>Valor (R$)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% model.Controller c = new model.Controller();
                                for (model.Movimentacao m : c.ListarMovimentos() ) { %>
                            <tr>
                                <td><% out.print(m.getTipo()); %></td>
                                <td><% out.print(m.getNomeCategoria()); %></td>
                                <td><% out.print(m.getDescricao()); %></td>
                                <td><% out.print(m.getDataFormat()); %></td>
                                <td>R$ <% out.print(m.getValor()); %></td>
                            </tr>
                            <% } %>
                            <% wsCategoria ws = new wsCategoria();%>
                            <tr>
                                <td><b>Saldo</b></td>
                                <td><b>R$ <%=ws.obterSaldo()%><b> </td>
                                            <td></td>
                                            <td></td>
                                            </tr>    


                                            </tbody>
                                            </table>

                                            </div>
                                            <aside role="complementary" class="col-md-4">

                                            </aside>
                                            </div>
                                            </div>
                                            </body>
                                            </html>
