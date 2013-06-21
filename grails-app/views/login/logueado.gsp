<html>
<head><title>BiddingIT</title></head>
<body>
</body>
	<g:link controller="Logout">Cerrar Sesion</g:link>
	<sec:ifLoggedIn>
		<h2>Bienvenido <sec:username/></h2>
	</sec:ifLoggedIn>
	
	
	<g:link controller="Login" action="administracion">ADMINISTRACION</g:link>

	<sec:access expression="hasRole('ROLE_USER')">
		You're a user
	</sec:access>
</html>