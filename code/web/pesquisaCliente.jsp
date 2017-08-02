<%-- 
    Document   : pesquisaCliente
    Created on : 04/10/2016, 08:25:23
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.js" rel="stylesheet" type="text/js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <style>
            .window{
                color:black;
                display:none;
                width:300px;
                height:300px;
                position:absolute;
                left:0;
                top:0;
                background:#FFF;
                z-index:9900;
                padding:10px;
                border-radius:10px;
                height: auto;
            }

            #mascara{
                display:none;
                position:absolute;
                left:0;
                top:0;
                z-index:9000;
                background-color:#000;
            }

            .fechar{display:block; text-align:right;}
        </style>
        <script>
            $(document).ready(function() {
                $("a[rel=modal]").click(function(ev) {
                    ev.preventDefault();

                    var id = $(this).attr("href");

                    var alturaTela = $(document).height();
                    var larguraTela = $(window).width();

                    //colocando o fundo preto
                    $('#mascara').css({'width': larguraTela, 'height': alturaTela});
                    $('#mascara').fadeIn(1000);
                    $('#mascara').fadeTo("slow", 0.8);

                    var left = ($(window).width() / 2) - ($(id).width() / 2);
                    var top = ($(window).height() / 2) - ($(id).height() / 2);

                    $(id).css({'top': top, 'left': left});
                    $(id).show();
                });

                $("#mascara").click(function() {
                    $(this).hide();
                    $(".window").hide();
                });

                $('.fechar').click(function(ev) {
                    ev.preventDefault();
                    $("#mascara").hide();
                    $(".window").hide();
                });
            });
        </script>
        <title>SCAJ - Pesquisar Cliente</title>
    </head>
    <body>
        <div class="container">
            <h1>Pesquiar Cliente</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Cliente ID</th>
                        <th>Carteira NIT</th>
                        <th>Profissao</th>
                        <th>Estado Civil</th>
                        <th>Fonte de Indicação</th>
                        <th>Nome</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientes}" var="cliente">
                        <tr class="trHover">
                            <td><c:out value="${cliente.idCliente}"/></td>
                            <td><c:out value="${cliente.carteiraNit}"/></td>
                            <td><c:out value="${cliente.profissao}"/></td>
                            <td><c:out value="${cliente.estadoCivil}"/></td>
                            <td><c:out value="${cliente.idFonteIndicacao.nome}"/></td>
                            <td><c:out value="${cliente.idPessoa.nome}"/></td>
                            <td><a href="ManterClienteController?acao=prepararEditar&txtIdCliente=<c:out value="${cliente.idCliente}"/>"><i class="icon-edit" ></i>Editar</a>
                                <a href="ManterClienteController?acao=prepararExcluir&txtIdCliente=<c:out value="${cliente.idCliente}"/>"><i class="icon-remove" ></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>           
                </tbody>
            </table>
            <form action="ManterClienteController?acao=prepararIncluir" method="post">
                <button type="submit" name="btnIncluir" class="btn btn-default" value="Incluir">Incluir</button>
                <button class="btn btn-default" ><a href="index.jsp" >Voltar</a></button>
            </form>
            <form action="RelatorioClienteController?acao=doPost" method="post">
                <button type="button" name="btnRelatorio" class="btn btn-default" value="Relatorio"><a href="#janela1" rel="modal">Gerar relatorio</a></button>
                <div class="window" id="janela1">
                    <a href="#" class="fechar">Fechar</a>
                    <h4>Insira o estado civil</h4>
                    <input type="text" name="pEstadoCivil">
                    <br>
                    <h6>Selecione o código da indicação</h6>
                    <select name="pIdFonteIndicacao" class="selectpicker">
                        <option value="0">Selecione</option>
                        <c:forEach items="${indicacoes}" var="indicacao">
                            <option value="${indicacao.idFonteIndicacao}">
                                ${indicacao.nome}
                            </option>  
                        </c:forEach>        
                    </select>
                    <br>
                    <h4>Insira a profissão</h4>
                    <input type="text" name="pProfissao">
                    <input type="submit" value="Gerar" class="btn btn-default">
                </div>
            </form>

            
            <div id="mascara"></div>
            </div>       
        </div>
    </body>
</html>
