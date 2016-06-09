<%-- 
    Document   : index
    Created on : 13/05/2016, 21:31:44
    Author     : ADILSON
--%>


<%@page import="java.util.Date"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.ModelMovimentacao"%>
<%@page import="java.util.List"%>
<%@page import="ws.wsGestaodeGastos"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="content/css/bootstrap.min.css"/>
        <title>Controle de Gastos</title> 

    </head>
    <body  class="container">


        <header>
            <nav class="navbar navbar-full navbar-light bg-faded" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="index.jsp">Controle de Gastos</a>
                <ul class="nav navbar-nav" style="float:right;">
                    <li><a href="index.jsp">Página Inicial</a></li>
                    <li><a href="movimentacao.jsp">Nova Receita/Despesa</a></li>
                    <li><a href="categorias.jsp">Minhas Categorias</a></li>
                </ul>
            </nav>            
        </header>

        <div>
            <div class="row">
                <div role="main" class="col-md-8">
                    <form action="ServletMovimentacao">
                        <input type="hidden" name="index" value="movimentacao">
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
                                <%
                                    List<ModelMovimentacao> lista = new ArrayList<ModelMovimentacao>();
                                    ws.wsGestaodeGastos ws = new ws.wsGestaodeGastos();

                                    for (ws.ModelMovimentacao m2 : ws.obterMovimentacao()) {
                                        ModelMovimentacao m = new ModelMovimentacao();

                                        m.setDescricao(m2.getDescricao());
                                        m.setIdMovimentacao(m2.getIdMovimentacao());
                                        m.setTipo(m2.getValor() < 0 ? "Despesa" : "Receita");
                                        m.setValor(m2.getValor());
                                        m.setNomeCategoria(m2.getNomeCategoria());

                                        m.setData(toDate(m2.getData()));
                                        String data = "" + m2.getData().getDay() + "/" + m2.getData().getMonth() + "/" + m2.getData().getYear();
                                        m.setDataFormat(data);

                                        m.setValor(m2.getValor());

                                        lista.add(m);

                                    }

                                    for (ModelMovimentacao m : lista) {


                                %>
                                <tr>
                                    <td><% out.print(m.getValor() < 0 ? "Despesa" : "Receita"); %></td>
                                    <td><% out.print(m.getNomeCategoria()); %></td>
                                    <td><% out.print(m.getDescricao()); %></td>

                                    <td><% out.print(m.getDataFormat()); %></td>
                                    <td>R$ <% out.print(m.getValor()); %></td>
                                </tr>
                                <% }%>

                                <tr>
                                    <td><b>Saldo</b></td>
                                    <td><b>R$ <%= ws.obterSaldo() %> </b> </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>    


                            </tbody>
                        </table>
                    </form>
                </div>
                <aside role="complementary" class="col-md-4">

                </aside>
            </div>
        </div>
        <%! public static Date toDate(XMLGregorianCalendar calendar) {
                if (calendar == null) {
                    return null;
                }
                return calendar.toGregorianCalendar().getTime();
            }%>              
    </body>
</html>
