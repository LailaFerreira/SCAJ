<%-- 
    Document   : manterPessoa
    Created on : 20/10/2016, 01:56:01
--%>

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
        <title>SCAJ - Manter Pessoa</title>
    </head>
    <body>
        <div class="container">
            <h1>Manter Pessoa - ${operacao}</h1>
            <form class="manterForm" action="ManterPessoaController?acao=confirmar${operacao}" method="post" name="frmManterPessoa" onsubmit="return validarFormulario(this)">
               <div class="form-group">
                    <label for="usr">ID Pessoa:</label> 
                    <input type="text" class="form-control" id="usr" name="txtIdPessoa" value="${pessoa.idPessoa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">CPF:</label>
                  <input type="text" class="form-control" id="usr" name="txtCpf" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Nome:</label>
                  <input type="text" class="form-control" id="usr" name="txtNome" value="${pessoa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">RG:</label>
                  <input type="text" class="form-control" id="usr" name="txtRg" value="${pessoa.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Telefone Residencial:</label> 
                  <input class="form-control" id="usr" value="${pessoa.telefoneResidencial}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Email:</label>
                  <input type="text" class="form-control" id="usr" name="txtEmail" value="${pessoa.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Data Nascimento:</label> 
                  <input type="text" class="form-control" id="usr" name="txtDataNascimento" value="${pessoa.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Logradouro:</label> 
                  <input type="text" class="form-control" id="usr" name="txtLogradouro" value="${pessoa.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Numero Residencial:</label> 
                  <input type="text" class="form-control" id="usr" name="txtNumeroResidencial" value="${pessoa.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Complemento:</label> 
                  <input type="text" class="form-control" id="usr" name="txtComplemento" value="${pessoa.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Bairro:</label> 
                  <input type="text" class="form-control" id="usr" name="txtBairro" value="${pessoa.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">Cidade:</label> 
                  <input type="text" class="form-control" id="usr" name="txtCidade" value="${pessoa.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">UF:</label> 
                  <input type="text" class="form-control" id="usr" name="txtUf" value="${pessoa.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <div class="form-group">
                  <label for="usr">CEP:</label> 
                  <input type="text" class="form-control" id="usr" name="txtCep" value="${pessoa.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
               </div>
               <button type="submit" name="btnConfirmar" class="btn btn-default" value="Confirmar">Confirmar</button>
               <button type="reset" name="btnLimpar" class="btn btn-default" value="Limpar">Limpar</button>
               <button class="btn btn-default" ><a href="/index.jsp" >Voltar</a></button>         
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
                if (form.txtIdPessoa.value === "") {
                    mensagem = mensagem + "Informe o Código da Pessoa\n";
                }
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome da Pessoa\n";
                }
                if (form.txtCpf.value === "") {
                    mensagem = mensagem + "Informe o Cpf da Pessoa\n";
                }
                if (form.txtRg.value === "") {
                    mensagem = mensagem + "Informe o Rg da Pessoa\n";
                }
                if (form.txtTelefoneResidencial.value === "") {
                    mensagem = mensagem + "Informe o Telefone Residencial da Pessoa\n";
                }
                if (form.txtDataNascimento.value === "") {
                    mensagem = mensagem + "Informe a Data de Nascimento da Pessoa\n";
                }
                if (form.txtLogradouro.value === "") {
                    mensagem = mensagem + "Informe o Logradouro da Pessoa\n";
                }
                if (form.txtNumeroResidencial.value === "") {
                    mensagem = mensagem + "Informe o Número da Casa da Pessoa\n";
                }
                if (form.txtBairro.value === "") {
                    mensagem = mensagem + "Informe o Bairro da Pessoa\n";
                }
                if (form.txtCidade.value === "") {
                    mensagem = mensagem + "Informe a Cidade da Pessoa\n";
                }
                if (form.txtUf.value === "") {
                    mensagem = mensagem + "Informe a UF da Pessoa\n";
                }
                if (form.txtCep.value === "") {
                    mensagem = mensagem + "Informe o CEP da Pessoa\n";
                }
                if (!campoNumerico(form.txtIdPessoa.value)) {
                    mensagem = mensagem + "Código da Pessoa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCpf.value)) {
                    mensagem = mensagem + "CPF da Pessoa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtRg.value)) {
                    mensagem = mensagem + "RG da Pessoa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTelefoneResidencial.value)) {
                    mensagem = mensagem + "Telefone residencial da Pessoa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtNumeroResidencial.value)) {
                    mensagem = mensagem + "Numero Residencial da Pessoa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCep.value)) {
                    mensagem = mensagem + "CEP da Pessoa deve ser numérico\n";
                }
                if (form.txtUf.value.length !== 2) {
                    mensagem = mensagem + "O código da UF não pode possuir nem mais, nem menos que 2 caracteres\n";
                }
                if (form.txtCpf.value.length !== 11) {
                    mensagem = mensagem + "O CPF da Pessoa não pode possuir nem mais, nem menos que 11 caracteres\n";
                }
                if (form.txtCep.value.length !== 8) {
                    mensagem = mensagem + "O CEP da Pessoa não pode possuir nem mais, nem menos que 8 caracteres\n";
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
