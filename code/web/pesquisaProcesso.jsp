<%-- 
    Document   : pesquisaProcesso
    Created on : 04/10/2016, 14:01:51
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.js" rel="stylesheet" type="text/js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <title>SCAJ - Pesquisar Processos</title>
        <style>
            .window{
                color:black;
                display:none;
                width:300px;
                height:642px;
                position:absolute;
                left:0;
                top:0;
                background:#FFF;
                z-index:9900;
                padding:10px;
                border-radius:10px;
            }

            #mascara{
                height: 1000px;
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
            $(document).ready(function(){
            $("a[rel=modal]").click( function(ev){
                ev.preventDefault();

                var id = $(this).attr("href");

                var alturaTela = $(document).height();
                var larguraTela = $(window).width();

                //colocando o fundo preto
                $('#mascara').css({'width':larguraTela,'height':alturaTela});
                $('#mascara').fadeIn(1000); 
                $('#mascara').fadeTo("slow",0.8);

                var left = ($(window).width() /2) - ( $(id).width() / 2 );
                var top = ($(window).height() / 2) - ( $(id).height() / 2 );

                $(id).css({'top':top,'left':left});
                $(id).show();   
            });

            $("#mascara").click( function(){
                $(this).hide();
                $(".window").hide();
            });

            $('.fechar').click(function(ev){
                ev.preventDefault();
                $("#mascara").hide();
                $(".window").hide();
            });
        });
        </script>
        
    </head>
    <body>
        <div class="container">
            <h1>Pesquisar Processos</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID Processo</th>
                        <th>Numero do Processo</th>
                        <th>Data de entrada</th>
                        <th>Situacao</th>
                        <th>Nome do Cliente</th>
                        <th>Nome do Advogado Responsavel</th>
                        <th>Comarca</th>
                        <th>Instancia</th>
                        <th>Vara</th>
                        <th>Natureza</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${processos}" var="processo">
                        <tr class="trHover">
                            <td><c:out value="${processo.idProcesso}"/></td>
                            <td><c:out value="${processo.numeroProcesso}"/></td>
                            <td><c:out value="${processo.dataEntrada}"/></td>
                            <td><c:out value="${processo.situacao}"/></td>
                            <td><c:out value="${processo.idCliente.idPessoa.nome}"/></td>
                            <td><c:out value="${processo.idFuncionarioAdvogado.idPessoa.nome}"/></td>
                            <td><c:out value="${processo.idComarca.nome}"/></td>
                            <td><c:out value="${processo.idInstancia.nome}"/></td>
                            <td><c:out value="${processo.idVara.nome}"/></td>
                            <td><c:out value="${processo.idNatureza.nome}"/></td>
                            <td><a href="ManterProcessoController?acao=prepararEditar&txtIdProcesso=<c:out value="${processo.idProcesso}"/>"><i class="icon-edit" ></i>Editar</a>
                            <a href="ManterProcessoController?acao=prepararExcluir&txtIdProcesso=<c:out value="${processo.idProcesso}"/>"><i class="icon-remove" ></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterProcessoController?acao=prepararIncluir" method="post">
                <button type="submit" name="btnIncluir" class="btn btn-default" value="Incluir">Incluir</button>
                <button class="btn btn-default" ><a href="index.jsp" >Voltar</a></button>
            </form>
            
            <form action="RelatorioProcessoController?acao=doPost" method="post">
                <button type="submit" name="btnRelatorio" class="btn btn-default" value="Relatorio">Gerar relatorio</button>
            </form>
        </div>
                
            
        
    </body>
</html>