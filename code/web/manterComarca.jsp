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
        <title>SCAJ - Manter Comarca</title>
    </head>
    <body> 
        <div class="container">
            <h1>Manter Comarca - ${operacao}</h1>
            <form class="manterForm" action="ManterComarcaController?acao=confirmar${operacao}" method="post" name="frmManterComarca" onsubmit="return validarFormulario(this)">
            <div class="form-group">
                <label for="usr">Id Comarca:</label>
                <input type="text" class="form-control" id="usr" name="txtIdComarca" value="${comarca.idComarca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
            </div>
            <div class="form-group">
                <label for="usr">Nome da Comarca:</label>
                <input type="text" class="form-control" id="usr"  name="txtNomeComarca" value="${comarca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
            <div class="form-group">
                <label for="usr">UF:</label>
                <input type="text" class="form-control" id="usr"  name="txtUf" value="${comarca.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtIdComarca.value === "") {
                    mensagem = mensagem + "Informe o Código da Comarca\n";
                }
                if (form.txtNomeComarca.value === "") {
                    mensagem = mensagem + "Informe o Nome da Comarca\n";
                }
                if (form.txtUf.value === "") {
                    mensagem = mensagem + "Informe a UF da Comarca\n";
                }
                if (!campoNumerico(form.txtIdComarca.value)) {
                    mensagem = mensagem + "Código da Comarca deve ser numérico\n";
                }
                if (campoNumerico(form.txtUf.value)) {
                    mensagem = mensagem + "A UF deve conter apenas caracteres alfabéticos\n";
                }
                if (form.txtUf.value.length !== 2) {
                    mensagem = mensagem + "O código da UF não pode possuir mais que dois caracteres\n";
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
