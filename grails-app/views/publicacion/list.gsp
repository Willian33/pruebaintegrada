
<%@ page import="ar.com.bidding.Publicacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'publicacion.label', default: 'Publicacion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-publicacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-publicacion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="publicacion.autor.label" default="Autor" /></th>
					
						<g:sortableColumn property="texto" title="${message(code: 'publicacion.texto.label', default: 'Texto')}" />
						
						
						
						<th><g:message code="Fecha de Publicación" default="Fecha de Publicación" /></th>
						
						
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${publicacionInstanceList}" status="i" var="publicacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					
					
					
					
						<td><g:link action="show" id="${publicacionInstance.id}">${fieldValue(bean: publicacionInstance, field: "autor.username")}</g:link></td>
					
						<td>${fieldValue(bean: publicacionInstance, field: "descripcion")}</td>
						
						
						
						
						
						<td>${fieldValue(bean: publicacionInstance, field: "fechaPublicacion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${publicacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
