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
        <title>SCAJ - Manter Cliente</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Cliente - ${operacao}</h1>
            <form class="manterForm" action="ManterClienteController?acao=confirmar${operacao}" method="post" name="frmManterCliente" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">Cliente ID:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdCliente" value="${cliente.idCliente}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Número NIT:</label>
                    <input type="text" class="form-control" id="usr" name="txtCarteiraNit" value="${cliente.carteiraNit}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Profissão do cliente:</label>
                    <input type="text" class="form-control" id="usr" name="txtProfissao" value="${cliente.profissao}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome do Cliente:</label>
                    <select name="txtIdPessoa" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>>
                        <option value="0" <c:if test="${pessoa.idPessoa != null}"> selected </c:if>></option>
                        <c:forEach items="${pessoas}" var="pessoa">
                            <option value="${pessoa.idPessoa}" <c:if test="${pessoa.idPessoa == cliente.idPessoa.idPessoa}"> selected </c:if>>
                                ${pessoa.nome}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Fonte da indicação:</label>
                    <select name="txtIdFonteIndicacao" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${indicacao.idFonteIndicacao != null}"> selected</c:if>></option>
                        <c:forEach items="${indicacoes}" var="indicacao">
                            <option value="${indicacao.idFonteIndicacao}" <c:if test="${indicacao.idFonteIndicacao == cliente.idFonteIndicacao.idFonteIndicacao}"> selected</c:if>>
                                ${indicacao.nome}
                            </option>  
                        </c:forEach>        
                    </select>
                </div>                
                <div class="form-group">
                    <label for="usr">Estado civil:</label>
                    <select name="txtEstadoCivil" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>
                        <option value="null" <c:if test="${cliente.estadoCivil == 'null'}"> selected</c:if>>null</option>
                        <option value="Casado" <c:if test="${cliente.estadoCivil == 'Casado'}"> selected</c:if>>Casado</option>
                        <option value="Solteiro" <c:if test="${cliente.estadoCivil == 'Solteiro'}"> selected</c:if>>Solteiro</option>
                        <option value="Divorciado" <c:if test="${cliente.estadoCivil == 'Divorciado'}"> selected</c:if>>Divorciado</option>
                        <option value="Viuvo" <c:if test="${cliente.estadoCivil == 'Viuvo'}"> selected</c:if>>Viúvo</option>
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
                if (form.txtIdCliente.value === "") {
                    mensagem = mensagem + "Informe o Código do Cliente\n";
                }
                if (form.txtCarteiraNit.value === "") {
                    mensagem = mensagem + "Informe o Número do NIT\n";
                }
                if (form.txtProfissao.value === "") {
                    mensagem = mensagem + "Informe a Profissão\n";
                }
                if (form.txtEstadoCivil.value === "null") {
                    mensagem = mensagem + "Informe o Estado Civil do Cliente\n";
                }
                if (form.txtIdFonteIndicacao.value === "0") {
                    mensagem = mensagem + "Informe o Nome da Indicação\n";
                }
                if (form.txtIdPessoa.value === "0") {
                    mensagem = mensagem + "Informe o Nome do Cliente\n";
                }
                if (!campoNumerico(form.txtIdCliente.value)) {
                    mensagem = mensagem + "Código da Cliente deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCarteiraNit.value)) {
                    mensagem = mensagem + "Número do NIT deve ser numérico\n";
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
