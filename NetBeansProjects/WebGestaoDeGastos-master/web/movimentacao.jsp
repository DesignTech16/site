<%-- 
    Document   : movimentacao
    Created on : 13/05/2016, 21:38:37
    Author     : ADILSON
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Movimentacao"%>
<%@page import="model.Categoria"%>
<%@page import="model.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="content/css/bootstrap.min.css"/>
        <title>Controle de Gastos</title>
        <script type="text/javascript" src="content/js/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" src="content/js/controle.js"></script>

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

        <div class="row">
            <div role="main" class="col-md-8">

                <form action="SvMovimentacao" method="POST"  class="form-horizontal">
                    <h3>Nova Movimentação</h3>
                    <hr>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tipo:</label>
                        <div class="col-sm-10">
                            <div class="btn-group btn-group-justified" data-toggle="buttons">
                                <label class="btn btn-default">
                                    <input type="radio" value="receita" required="required" name="tipo">Receita
                                </label>
                                <label class="btn btn-default">
                                    <input type="radio" value="despesa" required="required" name="tipo">Despesa
                                </label>
                               
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">Descrição:</label>
                        <div class="col-sm-10">
                            <input type="text" name="descricao"class="form-control" />
                            
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Valor:</label>
                        <div class="col-sm-10">
                            <input type="number"name="valor" class="form-control" />
                           


                            
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Data:</label>
                        <div class="col-sm-10">
                            <input type="date" name="data" class="form-control" />
                            
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Categoria:</label>
                        <div class="col-sm-10">

                            <select id="repeticao" name="categoria" class="form-control" required="required">

                                <option value="" disabled selected hidden>Selecione uma opção</option>

                                <%

                                    Controller controller = new Controller();
                                    for (Categoria c : controller.ListarCategorias()) {%>

                                <option value="<%=c.getNome()%>"><% out.print(c.getNome());%></option>
                                <% }%>
                                
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Repetição:</label>
                        <div class="col-sm-10">
                            <select id="repeticao" name="repeticao" class="form-control" required="required">
                                <option value="eventual" selected="selected">Movimentação eventual</option>
                                <option value="fixa">Movimentação fixa</option>
                                
                            </select>
                        </div>
                    </div>
                    <!--
                                        <div id="prazo" class="form-group" style="display: none;">
                                            <label class="col-sm-2 control-label">Prazo:</label>
                                            <div class="col-sm-10" style="padding-left: 40px;">
                                                <div class="radio">
                                                    <input type="radio" name="termino"> Indeterminado
                                                </div>
                                                <div class="radio">
                                                    <input type="radio" name="termino"> Após <input type="text" size="2" maxlength="2"> ocorrências
                                                </div>
                                                <div class="radio">
                                                    <input type="radio" name="termino"> Em <input type="date">
                                                </div>
                                            </div>
                                        </div>
                    -->
                    <hr>
                    <div style="float:right;">
                        <input type="submit" value="Salvar" class="btn btn-primary" />
                        <input type="reset" value="Limpar" class="btn btn-danger">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
