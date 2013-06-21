<html>
	<head>
		<title></title>
		</head>
	<body>
		<div id="publicaciones">
			<g:each in="${todas}">
				<table border="1">
				<tr><td>${it.imagen}</td>
				<td><g:link action="mostrarUna" id="${it.id}">${it.texto}</g:link></td>
				<td>${it.nombre}</td>
				<td>${it.autor.username}</td></tr><br>
				</table>
			</g:each>
		</div>
	</body>
</html>