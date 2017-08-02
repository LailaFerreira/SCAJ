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
        <title>SCAJ - Manter Processo</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Processo - ${operacao}</h1>
            <form class="manterForm" action="ManterProcessoController?acao=confirmar${operacao}" method="post" name="frmManterProcesso" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">ID Processo:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdProcesso" value="${processo.idProcesso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Número Processo:</label>
                    <input type="text" class="form-control" id="usr" name="txtNumeroProcesso" value="${processo.numeroProcesso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
					 <div class="form-group">
                    <label for="usr">Data de entrada:</label>
                    <input type="text" class="form-control" id="usr" name="txtDataEntrada" value="${processo.dataEntrada}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Situação:</label>
                    <select name="txtSituacao" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>
                        <option value="null" <c:if test="${processo.situacao == 'null'}"> selected</c:if>>null</option>
                        <option value="Sim" <c:if test="${processo.situacao == 'Aberto'}"> selected</c:if>>Aberto</option>
			<option value="Nao" <c:if test="${processo.situacao == 'Fechado'}"> selected</c:if>>Fechado</option>
                    </select>
                </div>		 
                <div class="form-group">
                    <label for="usr">Nome do Cliente:</label>
                    <select name="txtIdCliente" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${cliente.idCliente != null}"> selected</c:if>></option>
                        <c:forEach items="${clientes}" var="cliente">
                            <option value="${cliente.idCliente}" <c:if test="${cliente.idCliente == processo.idCliente.idCliente}"> selected</c:if>>  
                                ${cliente.idPessoa.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Comarca:</label>
                    <select name="txtIdComarca" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${comarca.idComarca != null}"> selected</c:if>></option>
                        <c:forEach items="${comarcas}" var="comarca">
                            <option value="${comarca.idComarca}" <c:if test="${comarca.idComarca == processo.idComarca.idComarca}"> selected</c:if>>
                                ${comarca.nome}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
		<div class="form-group">
                    <label for="usr">Nome do Advogado Responsável:</label>
                    <select name="txtIdAdvogado" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${advogado.idFuncionarioAdvogado != null}"> selected</c:if>></option>
                        <c:forEach items="${advogados}" var="advogado">
                            <option value="${advogado.idFuncionarioAdvogado}" <c:if test="${advogado.idFuncionarioAdvogado == processo.idFuncionarioAdvogado.idFuncionarioAdvogado}"> selected</c:if>> 
                                ${advogado.idPessoa.nome}
                            </option>
                        </c:forEach>                                   
                    </select>
                </div>
		<div class="form-group">
                    <label for="usr">Instância:</label>
                    <select name="txtIdInstancia" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${instancia.idInstancia != null}"> selected</c:if>></option>
                        <c:forEach items="${instancias}" var="instancia">
                            <option value="${instancia.idInstancia}" <c:if test="${instancia.idInstancia == processo.idInstancia.idInstancia}"> selected</c:if>>
                                ${instancia.nome}
                            </option>  
                        </c:forEach>                                 
                    </select>
                </div>
		<div class="form-group">
                    <label for="usr">Natureza:</label>
                    <select name="txtIdNatureza" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${natureza.idNatureza != null}"> selected</c:if>></option>
                        <c:forEach items="${naturezas}" var="natureza">
                            <option value="${natureza.idNatureza}" <c:if test="${natureza.idNatureza == processo.idNatureza.idNatureza}"> selected</c:if>>
                                ${natureza.nome}
                            </option>  
                        </c:forEach>      
                    </select>
                </div>
		<div class="form-group">
                    <label for="usr">Vara:</label>
                    <select name="txtIdVara" class="selectpicker" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${vara.idVara != null}"> selected</c:if>></option>
                        <c:forEach items="${varas}" var="vara">
                            <option value="${vara.idVara}" <c:if test="${vara.idVara == processo.idVara.idVara}"> selected</c:if>>
                                ${vara.nome}
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
                if (form.txtIdProcesso.value === "") {
                    mensagem = mensagem + "Informe o Código do Processo\n";
                }
                if (form.txtNumeroProcesso.value === "") {
                    mensagem = mensagem + "Informe o Número do Processo\n";
                }
                if (form.txtDataEntrada.value === "") {
                    mensagem = mensagem + "Informe a Data de Abertura do Processo\n";
                }
                if (form.txtSituacao.value === "null") {
                    mensagem = mensagem + "Informe a Situação do Processo\n";
                }
                if (form.txtIdCliente.value === "0") {
                    mensagem = mensagem + "Informe o Nome do Cliente\n";
                }
                if (form.txtIdComarca.value === "0") {
                    mensagem = mensagem + "Informe o nome da Comarca\n";
                }
                if (form.txtIdAdvogado.value === "0") {
                    mensagem = mensagem + "Informe o Nome do Advogado Responsável\n";
                }
                if (form.txtIdInstancia.value === "0") {
                    mensagem = mensagem + "Informe em qual Instância o Processo está\n";
                }
                if (form.txtIdNatureza.value === "0") {
                    mensagem = mensagem + "Informe a Natureza do Processo\n";
                }
                if (form.txtIdVara.value === "0") {
                    mensagem = mensagem + "Informe em qual Vara o Processo está\n";
                }
                if (!campoNumerico(form.txtIdProcesso.value)) {
                    mensagem = mensagem + "Código do Processo deve ser numérico\n";
                }
                if (!campoNumerico(form.txtNumeroProcesso.value)) {
                    mensagem = mensagem + "Número do Processo deve ser numérico\n";
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
