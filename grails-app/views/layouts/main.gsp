<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><g:layoutTitle default="Free Bidding - Una nueva forma de comerciar"/></title>
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
	</head>
	<body>
		<div id = "contenedorEncabezado">
			<img id = "imgIsologo" src = "${resource(dir: 'images', file: 'isologo.png')}" alt = "Free Bidding" title = "Free Bidding - Una nueva forma de comerciar"  />
			<div id = "contenedorBuscar">
				<g:textField name="buscar" id = "gtxtBuscar"/>
				<div id = "btnBuscar" ></div>
			</div>
			<div id = "contenedorAcciones">
				<g:link href = "#">Reg&iacute;strate</g:link>
				<g:link href = "#">Ingresa</g:link>
				<g:link href = "#">Vende</g:link>
			</div>
		</div>
		
		<g:layoutBody/>
	</body>
</html>
