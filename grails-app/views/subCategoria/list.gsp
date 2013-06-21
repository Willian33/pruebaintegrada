
<%@ page import="ar.com.bidding.SubCategoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subCategoria.label', default: 'SubCategoria')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-subCategoria" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-subCategoria" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="id_Categoria" title="${message(code: 'subCategoria.id_Categoria.label', default: 'Id Categoria')}" />
					
						<g:sortableColumn property="subcategoria" title="${message(code: 'subCategoria.subcategoria.label', default: 'Subcategoria')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${subCategoriaInstanceList}" status="i" var="subCategoriaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${subCategoriaInstance.id}">${fieldValue(bean: subCategoriaInstance, field: "id_Categoria")}</g:link></td>
					
						<td>${fieldValue(bean: subCategoriaInstance, field: "subcategoria")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${subCategoriaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
