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
        <script>
            function excluir() {
                var s = <%=request.getAttribute("excluido")%>;
                var r = <%=request.getAttribute("excluir")%>;

                if (r == 1) {
                    alert(s);
                }
            }
        </script>
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

                <form action="SvCategoria" method="POST"  class="form-horizontal">
                    <hr>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nova:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" required="required"  name="novacategoria" placeholder="Insira uma nova categoria">                     
                        </div>

                    </div>
                    <div style="float:right;">
                        <input type="submit" value="Salvar" class="btn btn-primary" />


                    </div>
                </form>
                <form  action="SvCategoria" method="POST"  class="form-horizontal">

                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-10">


                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Excluir: </label>

                        <div class="col-sm-10">
                            <select id="repeticao" name="excluircategoria" class="form-control" required="required">

                                <option value="" disabled selected hidden>Selecione uma opção</option>

                                <%

                                    Controller controllerr = new Controller();
                                    for (Categoria c : controllerr.ListarCategorias()) {%>

                                <option value="<%=c.getNome()%>"><% out.print(c.getNome());%></option>
                                <% }%>

                            </select>

                        </div>
                    </div>


                    <div style="float:right;">
                        <input type="submit" value="Excluir" class="btn btn-danger">
                    </div>

                </form>

                <form action="SvCategoria" method="POST"  class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-10">


                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Editar:</label>
                        <div class="col-sm-10">

                            <select id="repeticao" name="editarcategoria" class="form-control" required="required">

                                <option value="" disabled selected hidden>Selecione uma opção</option>

                                <%

                                    Controller controller = new Controller();
                                    for (Categoria c : controller.ListarCategorias()) {%>

                                <option  value="<%=c.getNome()%>"><% out.print(c.getNome());%></option>
                                <%  }%>

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-10">
                            <input id="repeticao" type="text" name="categoriaeditada" placeholder="Edite aqui a categoria" class="form-control">
                        </div>

                    </div>
                    <div style="float:right;">
                        <input type="submit" value="Salvar" class="btn btn-primary" />

                    </div>
                </form>
            </div>
        </div>

        <hr>
        
       <!-- <div class="alert alert-success">
            <h5>${excluir}</h5>
        </div>
        <div class="alert alert-success">
            <h6>${cadastrar}</h6>
        </div>
        <div class="alert alert-success">
            <h6>${editar}</h6>
        </div> -->
    </body>
</html>