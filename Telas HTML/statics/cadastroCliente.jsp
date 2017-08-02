<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de cliente</title>
	<meta charset="UTF-8"/>
</head>
<body>
<div>
	<p style=" margin-left: 10px">Bem vindo ao cadastro de cliente, [usuario].</p>
	 <form>
	 	<p style="text-decoration: underline">Dados pessoais:</p>
		 		<p>Nome: <input type="text" name="name"></p>
		 		<p>RG: <input type="text" name="name"></p>
		 		<p>NIT: <input type="text" name="name"></p>
		 		<p>E-mail: <input type="text" name="name"></p>
		 		<p>CPF: <input type="text" name="name"></p>
		 		<p>Indicação: <input type="text" name="name"></p>
		 		<p>Telefone celular: <input type="text" name="name"></p>
		 		<p>Telefone comercial: <input type="text" name="name"></p>
  				<p>Telefone residencial: <input type="text" name="password"></p>
  				<p>Profissão: <input type="text" name="password"></p><br>
  				<p>Data de nascimento: <input type="text" name="password"></p>
  				<p>Estado civil: 
  				<select>
  					<option value="outro2"> </option>
 					<option value="rg">Solteiro</option>
  					<option value="CPF">Casado</option>
  					<option value="outro">Divorciado</option>
				</select></p>
		<p style="text-decoration: underline">Endereço</p>

				<p>Logradouro: <input type="text" name="name"></p>
		 		<p>Número: <input type="text" name="name"></p>
		 		<p>Bairro: <input type="text" name="name"></p>
		 		<p>Complemento: <input type="text" name="name"></p>
		 		<p>Cidade: <input type="text" name="name"></p>
		 		<p>CEP: <input type="text" name="name"></p>
		 		<p>UF: <select>
  					<option value="outro2"> </option>
 					<option value="rg">UFA</option>
  					<option value="CPF">UFB</option>
  					<option value="outro">UFC rs</option>
				</select></p><br>
				<form action="statics/principal.html">
				    <input type="submit" value="Cadastrar">
				</form>
		<a href="principal.html"><p>Voltar para menu</p></a>
		</form> 		
</div>
</body>
</html>