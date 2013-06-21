<%@ page import="ar.com.bidding.Publicacion" %>



<div class="fieldcontain ${hasErrors(bean: publicacionInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="publicacion.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<!--<g:select id="autor" name="autor.id" optionValue="username" from="${ar.com.bidding.Usuario.list()}" optionKey="id" required="" value="${publicacionInstance?.autor?.username}" class="many-to-one"/>-->
	<sec:loggedInUserInfo field="username"/>

</div>

<div class="fieldcontain ${hasErrors(bean: publicacionInstance, field: 'nombre', 'error')}">
	<label for="nombre">
		<g:message code="publicacion.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${publicacionInstance?.nombre}"/>
				
</div>

<div class="fieldcontain ${hasErrors(bean: publicacionInstance, field: 'descripcion', 'error')}">
	<label for="descripcion">
		<g:message code="publicacion.texto.label" default="Descripcion" />
		
	</label>
	<g:textArea name="descripcion" value="${publicacionInstance?.descripcion}"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: publicacionInstance, field: 'precio', 'error')}">
	<label for="precio">
		<g:message code="publicacion.precio.label" default="Precio Unitario" />
		
	</label>
	<g:textField name="precio" value="${publicacionInstance?.precio}"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: publicacionInstance, field: 'stock', 'error')}">
	<label for="stock">
		<g:message code="publicacion.stock.label" default="Stock disponible" />
		
	</label>
	<g:textField name="stock" value="${publicacionInstance?.stock}"/>
	
</div>










