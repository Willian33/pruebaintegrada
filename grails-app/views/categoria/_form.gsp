<%@ page import="ar.com.bidding.Categoria" %>



<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'categoria', 'error')} ">
	<label for="categoria">
		<g:message code="categoria.categoria.label" default="Categoria" />
		
	</label>
	<g:textField name="categoria" value="${categoriaInstance?.categoria}"/>
</div>

