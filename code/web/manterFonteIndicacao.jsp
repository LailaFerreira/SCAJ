<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.js" rel="stylesheet" type="text/js">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <title>SCAJ - Manter Fonte de Indicação</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Fonte de Indicação - ${operacao}</h1>
            <form class="manterForm" action="ManterFonteIndicacaoController?acao=confirmar${operacao}" method="post" name="frmManterFonteIndicacao" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">ID da Fonte de Indicação:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdFonteIndicacao" value="${fonteIndicacao.idFonteIndicacao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome da Fonte de Indicação:</label>
                    <input type="text" class="form-control" id="usr"  name="txtNomeIndicacao" value="${fonteIndicacao.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <button type="submit" name="btnConfirmar" class="btn btn-default" value="Confirmar">Confirmar</button>
                <button type="reset" name="btnLimpar" class="btn btn-default" value="Limpar">Limpar</button>
                <button class="btn btn-default" ><a href="index.jsp" >Voltar</a></button> 
            </form>     
        </div>          
        <SCRIPT language="JavaScript">
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var numero = true;
                var caracter;
                for (i = 0; i < valor.length && numero === true; i++)
                {
                    caracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(caracter) === -1)
                    {
                        numero = false;
                    }
                }
                return numero;
            }

            function validarFormulario(form) {
                var mensagem = "";
                if (form.txtIdFonteIndicacao.value === "") {
                    mensagem = mensagem + "Informe o Código da Indicacao\n";
                }
                if (form.txtNomeIndicacao.value === "") {
                    mensagem = mensagem + "Informe o Nome da Indicacao\n";
                }
                if (!campoNumerico(form.txtIdFonteIndicacao.value)) {
                    mensagem = mensagem + "Código da Indicacao deve ser numérico\n";
                }
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </SCRIPT>                        
    </body>
</html>
