<!DOCTYPE html>
<html>
	<head>
		<title>Bienvenido a Free Bidding</title>
		<link rel = "stylesheet" href = "${resource(dir: 'css', file: 'index.css')}" type = "text/css">
	</head>
	<body>
		<div id = "contenedorIndex">
			<g:link controller="Publicacion" action="mostrarHome">
				<img id = "imgLogo" src = "${resource(dir: 'images', file: 'logo.png')}" />
				<span id = "spanFree">Free</span>
				<span id = "spanBidding">Bidding</span>
			</g:link>
		</div>
	</body>
</html>
