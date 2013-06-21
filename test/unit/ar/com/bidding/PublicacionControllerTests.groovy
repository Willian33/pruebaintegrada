package ar.com.bidding



import org.junit.*
import grails.test.mixin.*

@TestFor(PublicacionController)
@Mock(Publicacion)
class PublicacionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/publicacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.publicacionInstanceList.size() == 0
        assert model.publicacionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.publicacionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.publicacionInstance != null
        assert view == '/publicacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/publicacion/show/1'
        assert controller.flash.message != null
        assert Publicacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/publicacion/list'

        populateValidParams(params)
        def publicacion = new Publicacion(params)

        assert publicacion.save() != null

        params.id = publicacion.id

        def model = controller.show()

        assert model.publicacionInstance == publicacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/publicacion/list'

        populateValidParams(params)
        def publicacion = new Publicacion(params)

        assert publicacion.save() != null

        params.id = publicacion.id

        def model = controller.edit()

        assert model.publicacionInstance == publicacion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/publicacion/list'

        response.reset()

        populateValidParams(params)
        def publicacion = new Publicacion(params)

        assert publicacion.save() != null

        // test invalid parameters in update
        params.id = publicacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/publicacion/edit"
        assert model.publicacionInstance != null

        publicacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/publicacion/show/$publicacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        publicacion.clearErrors()

        populateValidParams(params)
        params.id = publicacion.id
        params.version = -1
        controller.update()

        assert view == "/publicacion/edit"
        assert model.publicacionInstance != null
        assert model.publicacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/publicacion/list'

        response.reset()

        populateValidParams(params)
        def publicacion = new Publicacion(params)

        assert publicacion.save() != null
        assert Publicacion.count() == 1

        params.id = publicacion.id

        controller.delete()

        assert Publicacion.count() == 0
        assert Publicacion.get(publicacion.id) == null
        assert response.redirectedUrl == '/publicacion/list'
    }
}
