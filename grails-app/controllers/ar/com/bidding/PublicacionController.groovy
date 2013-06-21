package ar.com.bidding

import org.springframework.dao.DataIntegrityViolationException

import ar.com.bidding.services.FileUploadService




class PublicacionController {
	def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  
	def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [publicacionInstanceList: Publicacion.list(params), publicacionInstanceTotal: Publicacion.count()]
    }

    def create() {
		
        [publicacionInstance: new Publicacion(params)]
    }

	
	
	
	
    def save() {
		def fileUploadService = new FileUploadService()
        def publicacionInstance = new Publicacion(params)
		
		publicacionInstance.autor=springSecurityService.getCurrentUser()
		def  avatarImage = request.getFile("myfile").getOriginalFilename()
		if (avatarImage != "") {
			publicacionInstance.imagen = avatarImage
			fileUploadService.subirFTP(avatarImage)
		}
 
        if (!publicacionInstance.save(flush: true)) {
            render(view: "create", model: [publicacionInstance: publicacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacionInstance.id])
        redirect(action: "show", id: publicacionInstance.id)
    }
	

    def show(Long id) {
        def publicacionInstance = Publicacion.get(id)
        if (!publicacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "list")
            return
        }

        [publicacionInstance: publicacionInstance]
    }

    def edit(Long id) {
        def publicacionInstance = Publicacion.get(id)
        if (!publicacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "list")
            return
        }

        [publicacionInstance: publicacionInstance]
    }

    def update(Long id, Long version) {
        def publicacionInstance = Publicacion.get(id)
        if (!publicacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (publicacionInstance.version > version) {
                publicacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'publicacion.label', default: 'Publicacion')] as Object[],
                          "Ups! Otro usuario ha modificado esta publicación mientras la editabas")
                render(view: "edit", model: [publicacionInstance: publicacionInstance])
                return
            }
        }

        publicacionInstance.properties = params

        if (!publicacionInstance.save(flush: true)) {
            render(view: "edit", model: [publicacionInstance: publicacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacionInstance.id])
        redirect(action: "show", id: publicacionInstance.id)
    }

    def delete(Long id) {
        def publicacionInstance = Publicacion.get(id)
        if (!publicacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "list")
            return
        }

        try {
            publicacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def mostrarTodas(){
		def publicacionesTodas = Publicacion.getAll()
		render (view:'publicaciones_todas',model:[todas:publicacionesTodas])
	}
		
		
	def mostrarUna(int id){
		def publicacionUna = Publicacion.findById(id)
		render(view:'publicacion_mostrarUna',model:[una:publicacionUna])
	}
	
	def mostrarHome() {
		render(view:"home")
	}
}
