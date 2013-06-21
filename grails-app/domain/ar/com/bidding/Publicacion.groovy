package ar.com.bidding

class Publicacion {
	
	String nombre
	String descripcion
	Double precio
	String stock
	Usuario autor
	String imagen
	
	Date fechaPublicacion = new Date()
	Date fechaCaducidad = new Date()

    static constraints = {
		
    }
}
