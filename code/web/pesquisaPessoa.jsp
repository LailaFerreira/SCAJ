<%-- 
    Document   : pesquisaPessoa
    Created on : 20/10/2016, 01:56:25
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
        <title>SCAJ - Pesquisar Pessoas</title>
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
            <h1>Pesquisar Pessoas</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>CPF</th>
                        <th>Nome</th>
                        <th>RG</th>
                        <th>Telefone Residencial</th>
                        <th>Email</th>
                        <th>Data de Nascimento</th>
                        <th>Logradouro</th>
                        <th>Numero Residencial</th>
                        <th>Complemento</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>UF</th>
                        <th>CEP</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pessoas}" var="pessoa">
                        <tr class="trHover">
                            <td><c:out value="${pessoa.idPessoa}"/></td>
                            <td><c:out value="${pessoa.cpf}"/></td>
                            <td><c:out value="${pessoa.nome}"/></td>
                            <td><c:out value="${pessoa.rg}"/></td>
                            <td><c:out value="${pessoa.telefoneResidencial}"/></td>
                            <td><c:out value="${pessoa.email}"/></td>
                            <td><c:out value="${pessoa.dataNascimento}"/></td>
                            <td><c:out value="${pessoa.logradouro}"/></td>
                            <td><c:out value="${pessoa.numero}"/></td>
                            <td><c:out value="${pessoa.complemento}"/></td>
                            <td><c:out value="${pessoa.bairro}"/></td>
                            <td><c:out value="${pessoa.cidade}"/></td>
                            <td><c:out value="${pessoa.uf}"/></td>
                            <td><c:out value="${pessoa.cep}"/></td>
                            <td><a href="ManterPessoaController?acao=prepararEditar&txtIdPessoa=<c:out value="${pessoa.idPessoa}"/>"><i class="icon-edit" ></i>Editar</a>
                            <a href="ManterPessoaController?acao=prepararExcluir&txtIdPessoa=<c:out value="${pessoa.idPessoa}"/>"><i class="icon-remove" ></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterPessoaController?acao=prepararIncluir" method="post">
                <button type="submit" name="btnIncluir" class="btn btn-default" value="Incluir">Incluir</button>
                <button class="btn btn-default" ><a href="index.jsp" >Voltar</a></button>
            </form>
            
        </div>
    </body>
</html>