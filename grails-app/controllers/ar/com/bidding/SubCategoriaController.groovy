package ar.com.bidding

import org.springframework.dao.DataIntegrityViolationException

class SubCategoriaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [subCategoriaInstanceList: SubCategoria.list(params), subCategoriaInstanceTotal: SubCategoria.count()]
    }

    def create() {
        [subCategoriaInstance: new SubCategoria(params)]
    }

    def save() {
        def subCategoriaInstance = new SubCategoria(params)
        if (!subCategoriaInstance.save(flush: true)) {
            render(view: "create", model: [subCategoriaInstance: subCategoriaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), subCategoriaInstance.id])
        redirect(action: "show", id: subCategoriaInstance.id)
    }

    def show(Long id) {
        def subCategoriaInstance = SubCategoria.get(id)
        if (!subCategoriaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "list")
            return
        }

        [subCategoriaInstance: subCategoriaInstance]
    }

    def edit(Long id) {
        def subCategoriaInstance = SubCategoria.get(id)
        if (!subCategoriaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "list")
            return
        }

        [subCategoriaInstance: subCategoriaInstance]
    }

    def update(Long id, Long version) {
        def subCategoriaInstance = SubCategoria.get(id)
        if (!subCategoriaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (subCategoriaInstance.version > version) {
                subCategoriaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'subCategoria.label', default: 'SubCategoria')] as Object[],
                          "Another user has updated this SubCategoria while you were editing")
                render(view: "edit", model: [subCategoriaInstance: subCategoriaInstance])
                return
            }
        }

        subCategoriaInstance.properties = params

        if (!subCategoriaInstance.save(flush: true)) {
            render(view: "edit", model: [subCategoriaInstance: subCategoriaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), subCategoriaInstance.id])
        redirect(action: "show", id: subCategoriaInstance.id)
    }

    def delete(Long id) {
        def subCategoriaInstance = SubCategoria.get(id)
        if (!subCategoriaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "list")
            return
        }

        try {
            subCategoriaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def mostrarCategoriaEspecifica() {
		
	}
}
