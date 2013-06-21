package ar.com.bidding.services

import org.apache.commons.net.ftp.FTPClient
import org.springframework.web.multipart.MultipartFile



class FileUploadService {

    def String uploadFile(MultipartFile file,String name, String destinationDirectory) {
		if(!file.isEmpty()){
			file.transferTo(new File("${destinationDirectory}/${name}"))
			return "${destinationDirectory}/${name}"		
		}
		else{
			return null
		}
    }
	
	def subirFTP(String imagen) {
		
		FTPClient client = new FTPClient();
		FileInputStream fis = null;	
		client.connect("ftp.elserver.com");			
		if(client.login("Jorge.coredesignweb.com", "123456")){
			FileInputStream fi = new FileInputStream("C:/"+imagen); //Se abre un archivo de nuestra maquina local
			client.setFileType(client.BINARY_FILE_TYPE); //Se pone tipo binario para poder enviar archivos de cualquier tipo
			boolean res = client.storeFile("/wilson/"+imagen, fi ); //arch=nombre que va a tener el archivo
	  
			client.logout();
			client.disconnect();
		}
	}
				
			
}
