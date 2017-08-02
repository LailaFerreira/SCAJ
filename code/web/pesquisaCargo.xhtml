<%-- 
    Document   : pesquisaCargos
    Created on : 04/10/2016, 13:03:23
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
          <style>
            .window{
                color:black;
                display:none;
                width:300px;
                height:auto;
                position:absolute;
                left:0;
                top:0;
                background:#FFF;
                z-index:9900;
                padding:10px;
                border-radius:10px;
            }

            #mascara{
                display:none;
                position:absolute;
                left:0;
                top:0;
                z-index:9000;
                background-color:#000;
                height: auto;
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
        
        <title>SCAJ - Pesquisar Cargos</title>
    </head>
    <body>
        <div class="container">
            <h1>Pesquisar Cargos</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID Cargo</th>
                        <th>Nome</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cargos}" var="cargo">
                        <tr class="trHover">
                            <td><c:out value="${cargo.idCargo}"/></td>
                            <td><c:out value="${cargo.nome}"/></td>
                            <td style="text-decoration: none !important"><a style="text-decoration: none !important" href="ManterCargoController?acao=prepararEditar&txtIdCargo=<c:out value="${cargo.idCargo}"/>"><i class="icon-edit" style="text-decoration: none !important"></i>Editar</a>
                            <a style="text-decoration: none !important" href="ManterCargoController?acao=prepararExcluir&txtIdCargo=<c:out value="${cargo.idCargo}"/>"><i class="icon-remove" style="text-decoration: none !important"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterCargoController?acao=prepararIncluir" method="post">
                <button type="submit" name="btnIncluir" class="btn btn-default" value="Incluir">Incluir</button>
                <button style="text-decoration: none !important" class="btn btn-default" ><a href="index.jsp" >Voltar</a></button>
            </form>
            <form action="RelatorioCargoController?acao=doPost" method="post">
                <button type="button" name="btnRelatorio" class="btn btn-default" value="Relatorio"><a href="#janela1" rel="modal">Gerar relatorio</a></button>
                <div class="window" id="janela1">
                    <a href="#" class="fechar">X Fechar</a>
                    <h6>Insira o código do cargo para consulta</h6>
                    <input type="text" name="pCargo">
                    <input type="submit" value="Gerar" class="btn btn-default">
                </div>
                <div id="mascara"></div>
            </form>
       
       
        
        </div>
    </body>
</html>
