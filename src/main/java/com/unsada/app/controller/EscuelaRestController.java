package com.unsada.app.controller;






import java.io.FileOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.unsada.app.modelo.Escuela;
import com.unsada.app.service.EscuelaServiceApi;









@RestController
@RequestMapping(value = "/api/escuela/")
@CrossOrigin("*")
public class EscuelaRestController {
	
	@Autowired
	private EscuelaServiceApi  escuelaServiceApi ;   
	
	@Autowired
	ServletContext context;
	
	
	
	
	@GetMapping(value="/all")
	public Map<String, Object> list(){
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		try { 
			List<Escuela> empresaList; 
			empresaList = (List<Escuela>) escuelaServiceApi.findAll();
			response.put("message","Successful load");
			response.put("list",empresaList);
			response.put("success",true);
			return response;
			
		} catch (Exception e) {  
			response.put("message",e.getMessage()); 
			response.put("success ",false);
			return response;
		}
		
	}
	
	
	
	@GetMapping(value = "find/{id}" )
	public Map<String, Object> data(@PathVariable("id") Integer id){
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		try {   
			
			Optional<Escuela> empresa = escuelaServiceApi.findById(id);  
		 
			if (empresa.isPresent()) { 
				response.put("message","Successful load");
				response.put("data",empresa);
				response.put("success",true);
				return response;
			}
			else {
				response.put("message","Not found data");
				response.put("data",null);
				response.put("success",false);
				return response;
			}
			
		} catch (Exception e){ 
			response.put("message",""+e.getMessage()); 
			response.put("success",false);
			return response;
		}
	} 
	
	@GetMapping(value = "/findnombre/{id}")
	
		public Map<String, Object> findByNombre(@PathVariable String id) {
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		try {   
			
			Optional<Escuela> empresa = escuelaServiceApi.findByNombre(id);  
		 
			if (empresa.isPresent()) { 
				response.put("message","Successful load");
				response.put("data",empresa);
				response.put("success",true);
				return response;
			}
			else {
				response.put("message","Not found data");
				response.put("data",null);
				response.put("success",false);
				return response;
			}
			
		} catch (Exception e){ 
			response.put("message",""+e.getMessage()); 
			response.put("success",false);
			return response;
		}
	}
	
	@GetMapping(value = "/buscarlike/{id}")
	
		public Map<String, Object> findByNombreLike(@PathVariable String id) {
			String likeName = "%"+id+"%";
			HashMap<String,Object> response = new HashMap<String,Object>();
			
			
			 
				try { 
					List<Escuela> empresaList; 
					empresaList = (List<Escuela>) escuelaServiceApi.findByNombreLike(likeName);
					response.put("message","Successful load");
					response.put("list",empresaList);
					response.put("success",true);
					return response;
					
				} catch (Exception e) {  
					response.put("message",e.getMessage()); 
					response.put("success ",false);
					return response;
				}
		}
		
		
		
	

	
	
	@PostMapping(value="/create")
	public ResponseEntity<String> create(@RequestBody Escuela data){
		
		try {
			System. out. print("Proceso de guardar datos");
			escuelaServiceApi.save(data);
			return new ResponseEntity<>( "Save successful " , HttpStatus.OK);
		} 
		catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>( ""+e , HttpStatus.INTERNAL_SERVER_ERROR);
		}

 	}
	
	
	
	@PutMapping(value="/update/{id}")  
	public Map<String, Object> update(@PathVariable("id") Integer id,
			@RequestBody Escuela data ){
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		try {  
			data.setIdEscuela(id);
			escuelaServiceApi.save(data);
			response.put("message","Successful update"); 
			response.put("success",true);
			return response;
		} catch (Exception e) {
			response.put("message",e.getMessage()); 
			response.put("success",false);
			return response;
		}
		
	}

	
	
	@DeleteMapping(value="/delete/{id}")
	public Map<String, Object> update(@PathVariable("id") Integer id){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		try {  
			escuelaServiceApi.deleteById(id);;
			response.put("message","Successful delete"); 
			response.put("success", true);
			return response; 
		} catch (Exception e) {
			response.put("message",e.getMessage()); 
			response.put("success", false);
			return response;
		}
		
	}
	
	/*@PostMapping(value="imagen")
	public static BufferedImage decodeToImage(String imageString) {
		 
        BufferedImage image = null;
        byte[] imageByte;
        try {
            Base64Decoder decoder = new Base64Decoder();
            imageByte = decoder.decode(imageString);//decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
            System. out. print("Proceso de guardar imagen");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
	*/
	/*@PostMapping(value="imagen")
    public  String uploadImage2( @RequestBody String completeImageData)
    {
        try
        {	Integer id=5;
        	String pathfile=context.getContextPath()+"Imagenes\\sample"+id+".png";
        	String imageDataBytes = completeImageData.substring(completeImageData.indexOf(",")+1);
        	FileOutputStream imageOutFile = new FileOutputStream(pathfile);
        	 byte[] imageByteArray = Base64.getDecoder().decode(imageDataBytes);
        	 imageOutFile.write(imageByteArray);
            //This will decode the String which is encoded by using Base64 class
            //byte[] imageByte=Base64.decodeBase64(imageValue);

           //String directory=context.getRealPath("/")+"images/sample.jpg";

            //new FileOutputStream(directory).write(imageByte);
        	System.out.println(imageDataBytes);
            return "success ";
        }
        catch(Exception e)
        {
            return "error = "+e;
        }
        
        

    }
	*/
	

}
