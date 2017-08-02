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
        <title>SCAJ - Manter Funcionário</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Funcionário - ${operacao}</h1>
            <form class="manterForm" action="ManterFuncionarioAdvogadoController?acao=confirmar${operacao}" method="post" name="frmManterFuncionario" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">Advogado ID:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdFuncionarioAdvogado" value="${funcionarioAdvogado.idFuncionarioAdvogado}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Carteira OAB:</label>
                    <input type="text" class="form-control" id="usr" name="txtCarteiraOAB" value="${funcionarioAdvogado.carteiraOAB}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome do Advogado:</label>
                        <select name="txtIdPessoa" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${pessoa.idPessoa != null}"> selected</c:if>></option>
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.idPessoa}" <c:if test="${pessoa.idPessoa == funcionarioAdvogado.idPessoa.idPessoa}"> selected</c:if>> 
                                    ${pessoa.nome}
                                </option>
                            </c:forEach>
                        </select>
                </div>
                <div class="form-group">
                    <label for="usr">Cargo:</label>
                        <select name="txtIdCargo" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${cargo.idCargo!= null}"> selected</c:if>></option>
                            <c:forEach items="${cargos}" var="cargo">
                                <option value="${cargo.idCargo}" <c:if test="${cargo.idCargo == funcionarioAdvogado.idCargo.idCargo}"> selected</c:if>>
                                    ${cargo.nome}
                                </option>  
                            </c:forEach>
                        </select>
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
                if (form.txtIdFuncionarioAdvogado.value === "") {
                    mensagem = mensagem + "Informe o Código do Advogado\n";
                }
                if (form.txtCarteiraOAB.value === "") {
                    mensagem = mensagem + "Informe o Número da Carteira da OAB\n";
                }
                if (form.txtIdPessoa.value === "0") {
                    mensagem = mensagem + "Informe o Nome do Advogado\n";
                }
                if (form.txtIdCargo.value === "0") {
                    mensagem = mensagem + "Informe o Cargo do Advogado\n";
                }
                if (!campoNumerico(form.txtIdFuncionarioAdvogado.value)) {
                    mensagem = mensagem + "Código do Advogado deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCarteiraOAB.value)) {
                    mensagem = mensagem + "O Número da Carteira da OAB deve ser numérico\n";
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
