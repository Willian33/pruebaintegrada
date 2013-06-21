
<%@ page import="ar.com.bidding.SubCategoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subCategoria.label', default: 'SubCategoria')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-subCategoria" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-subCategoria" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list subCategoria">
			
				<g:if test="${subCategoriaInstance?.id_Categoria}">
				<li class="fieldcontain">
					<span id="id_Categoria-label" class="property-label"><g:message code="subCategoria.id_Categoria.label" default="Id Categoria" /></span>
					
						<span class="property-value" aria-labelledby="id_Categoria-label"><g:fieldValue bean="${subCategoriaInstance}" field="id_Categoria"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${subCategoriaInstance?.subcategoria}">
				<li class="fieldcontain">
					<span id="subcategoria-label" class="property-label"><g:message code="subCategoria.subcategoria.label" default="Subcategoria" /></span>
					
						<span class="property-value" aria-labelledby="subcategoria-label"><g:fieldValue bean="${subCategoriaInstance}" field="subcategoria"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${subCategoriaInstance?.id}" />
					<g:link class="edit" action="edit" id="${subCategoriaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
