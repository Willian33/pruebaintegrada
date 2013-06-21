class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		//Redirecciona a usuarioLogueado despues de loguearse correctamente
		"/logueado"(controller: 'Login', action: 'usuarioLogueado')

	}
}
