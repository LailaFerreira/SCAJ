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
        <title>SCAJ - Manter Documento</title>
    </head>
    <body>                            
        <div class="container">
            <h1>Manter Documento - ${operacao}</h1>
            <form class="manterForm" action="ManterDocumentoController?acao=confirmar${operacao}" method="post" name="frmManterDocumento" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">ID Documento:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdDocumento" value="${documento.idDocumento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome do Documento:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomeDocumento" value="${documento.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Data da Entrega:</label>
                    <input type="text" class="form-control" id="usr" name="txtDataEntrega" value="${documento.dataEntrega}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Pendência:</label>
                    <select name="txtPendencia" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>
                        <option value="null" <c:if test="${documento.pendencia == 'null'}"> selected</c:if>>null</option>
                        <option value="Sim" <c:if test="${documento.pendencia == 'Sim'}"> selected</c:if>>Sim</option>
                        <option value="Nao" <c:if test="${documento.pendencia == 'Nao'}"> selected</c:if>>Não</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Nome do Cliente:</label>
                        <select name="txtIdCliente" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${cliente.idCliente != null}"> selected</c:if>></option>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.idCliente}" <c:if test="${cliente.idCliente == documento.idCliente.idCliente}"> selected</c:if>> 
                                    ${cliente.idPessoa.nome}
                                </option>
                            </c:forEach>
                        </select>
                </div>
                <div class="form-group">
                    <label for="usr">Processo:</label>
                        <select name="txtIdProcesso" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${processo.idProcesso != null}"> selected</c:if>></option>
                            <c:forEach items="${processos}" var="processo">
                                <option value="${processo.idProcesso}" <c:if test="${processo.idProcesso == documento.idProcesso.idProcesso}"> selected</c:if>> 
                                    ${processo.numeroProcesso}
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
                if (form.txtIdDocumento.value === "") {
                    mensagem = mensagem + "Informe o Código do Documento\n";
                }
                if (form.txtNomeDocumento.value === "") {
                    mensagem = mensagem + "Informe o Nome do Documento\n";
                }
                if (form.txtDataEntrega.value === "") {
                    mensagem = mensagem + "Informe a Data de Entrega do Documento\n";
                }
                if (form.txtPendencia.value === "null") {
                    mensagem = mensagem + "Informe a Pendência do Documento\n";
                }
                if (form.txtIdCliente.value === "0") {
                    mensagem = mensagem + "Informe o Nome do Cliente\n";
                }
                if (form.txtIdProcesso.value === "0") {
                    mensagem = mensagem + "Informe o Número do Processo\n";
                }
                if (!campoNumerico(form.txtIdDocumento.value)) {
                    mensagem = mensagem + "Código do Documento deve ser numérico\n";
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
