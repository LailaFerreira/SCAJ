
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
        <title>SCAJ - Manter Vara</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Vara - ${operacao}</h1>
            <form class="manterForm" action="ManterVaraController?acao=confirmar${operacao}" method="post" name="frmManterVara" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">ID Vara:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdVara" value="${vara.idVara}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome Vara: </label>
                    <input type="text" class="form-control" id="usr" name="txtNomeVara" value="${vara.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtIdVara.value === "") {
                    mensagem = mensagem + "Informe o Código da Vara\n";
                }
                if (form.txtNomeVara.value === "") {
                    mensagem = mensagem + "Informe o Nome da Vara\n";
                }
                if (!campoNumerico(form.txtIdVara.value)) {
                    mensagem = mensagem + "Código da Vara deve ser numérico\n";
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
