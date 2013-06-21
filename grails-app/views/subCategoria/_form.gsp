<%@ page import="ar.com.bidding.SubCategoria" %>



<div class="fieldcontain ${hasErrors(bean: subCategoriaInstance, field: 'id_Categoria', 'error')} required">
	<label for="id_Categoria">
		<g:message code="subCategoria.id_Categoria.label" default="Id Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="id_Categoria" type="number" value="${subCategoriaInstance.id_Categoria}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: subCategoriaInstance, field: 'subcategoria', 'error')} ">
	<label for="subcategoria">
		<g:message code="subCategoria.subcategoria.label" default="Subcategoria" />
		
	</label>
	<g:textField name="subcategoria" value="${subCategoriaInstance?.subcategoria}"/>
</div>

