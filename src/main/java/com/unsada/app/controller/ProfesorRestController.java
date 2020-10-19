package com.unsada.app.controller;


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

import com.unsada.app.modelo.Profesor;

import com.unsada.app.service.ProfesorServiceApi;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = "/api/profesor")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProfesorRestController {
	@Autowired
	private ProfesorServiceApi profesorServiceApi;
	
	@Autowired
	ServletContext context;
	
	/*@PostMapping(value="imagen/{id}" , produces = MediaType.TEXT_PLAIN_VALUE)
    public  String uploadImage2( @RequestBody String completeImageData,@PathVariable("id")Integer id )
    {
				
        try
        {	
        	System.out.println(completeImageData);
        	String pathfile=context.getContextPath()+"sample"+id+".png";
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

	@GetMapping(value = "/pdfReport/{id}", produces = "application/pdf")
	public ResponseEntity<byte[]> report(@PathVariable("id") Integer id) throws SQLException {
		Optional<Profesor> abono = abonoServiceApi.findById(id);
		Map<String, Object> params = new HashMap<>();
		byte[] bytes = null;
		InputStream jasperStream = this.getClass().getResourceAsStream("/static/Abono.jasper");
		JasperReport jasperReport = null;
		File fichero = new File("sample"+id+".png");
		System.out.println(fichero);
		System.out.println(fichero.getAbsolutePath());
		try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

			jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			
			//Llenado informe
			params.put("idjasper", id);
			
			params.put("marca", abono.get().getMarca());
			params.put("modelo", abono.get().getModelo());
			params.put("potencia", abono.get().getPotencia());
			params.put("motorMarca", abono.get().getMotorMarca());
			params.put("motorModelo", abono.get().getMotorModelo());
			params.put("motorNumero", abono.get().getMotorNumero());
			params.put("fechaAnterior", abono.get().getFechaAnterior());
			params.put("fechaActual", abono.get().getFechaActual());
			params.put("horometroActual", abono.get().getHorometroActual());
			params.put("horometroAnterior", abono.get().getHorometroAnterior());
			
			params.put("cabinaPintura", abono.get().getCabinaPintura());
			params.put("cabinaAcustica", abono.get().getCabinaAcustica());
			params.put("cabinaCerradura", abono.get().getCabinaCerradura());
			params.put("enfriamientoManguera", abono.get().getEnfriamientoManguera());
			params.put("enfriamientoPerdida", abono.get().getEnfriamientoPerdidas());
			params.put("enfriamientoNivel", abono.get().getEnfriamientoNivel());
			params.put("bateriaCantidad", abono.get().getBateriaCantidad());
			params.put("bateriaAcido", abono.get().getBateriaAcido());
			params.put("bateriaConexion", abono.get().getBateriaConexion());
			params.put("bateriaMarca", abono.get().getBateriaMarca());
			params.put("bateriaEstado", abono.get().getBateriaEstado());
			params.put("bateriaBornes", abono.get().getBateriaBornes());
			params.put("tensionParado", abono.get().getTensionParado());
			params.put("tensionMarcha", abono.get().getTensionMarcha());
			params.put("tensionArranque", abono.get().getTensionArranque());
			params.put("fechaInstalacion", abono.get().getFechaInstalacion());
			params.put("perdidaCombustible", abono.get().getPerdidaCombustible());
			params.put("perdidaAceite", abono.get().getPerdidaAceite());
			params.put("perdidaAgua", abono.get().getPerdidaAgua());
			params.put("estadoMangueras", abono.get().getEstadoMangueras());
			params.put("estadoRodantes", abono.get().getEstadoRodantes());
			params.put("estadoFiltroAire", abono.get().getEstadoFiltroAire());
			params.put("nivelAceite", abono.get().getNivelAceite());
			params.put("nivelCombustible", abono.get().getNivelCombustible());
			params.put("presionAceite", abono.get().getPresionAceite());
			params.put("tensionRs", abono.get().getTensionRs());
			params.put("tensionSt", abono.get().getTensionSt());
			params.put("tensionRt", abono.get().getTensionRt());
			params.put("tensionRn", abono.get().getTensionRn());
			params.put("tensionSn", abono.get().getTensionSn());
			params.put("tensionTn", abono.get().getTensionTn());
			params.put("autMan", abono.get().getAutMan());
			params.put("observaciones", abono.get().getObservaciones());
			params.put("idEmpresa", abono.get().getIdEmpresa().getIdEmpresa());
			params.put("nombreE", abono.get().getIdEmpresa().getNombre());
			params.put("contactoE", abono.get().getIdEmpresa().getContacto());
			params.put("telefonoE", abono.get().getIdEmpresa().getTelefono());
			params.put("calleE", abono.get().getIdEmpresa().getCalle());
			params.put("numeroE", abono.get().getIdEmpresa().getNumero());
			params.put("localidadE", abono.get().getIdEmpresa().getLocalidad());
			params.put("provinciaE", abono.get().getIdEmpresa().getProvincia());
			params.put("tecnicoNombre", abono.get().getIdTecnico().getNombre());
			params.put("tecnicoApellido", abono.get().getIdTecnico().getApellido());
			params.put("firma",fichero.getAbsolutePath());
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
			bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (JRException | IOException e) {
			e.printStackTrace();

		}
		return ResponseEntity.ok().header("Content-Type", "application/pdf;charset=UTF-8")
				.header("Content-Disposition", "inline; filename=\"reporte" + id + ".pdf\"").body(bytes);
	}
*/
	@GetMapping(value = "/all")
	public Map<String, Object> list() {

		HashMap<String, Object> response = new HashMap<String, Object>();

		try {
			List<Profesor> abonoList;
			abonoList = (List<Profesor>) profesorServiceApi.findAll();
			response.put("message", "Successful load");
			response.put("list", abonoList);
			response.put("success", true);
			return response;

		} catch (Exception e) {
			response.put("message", e.getMessage());
			response.put("success ", false);
			return response;
		}

	}

	@GetMapping(value = "/find/{id}")
	public Map<String, Object> data(@PathVariable("id") Integer id) {
		HashMap<String, Object> response = new HashMap<String, Object>();

		try {

			Optional<Profesor> abono = profesorServiceApi.findById(id);

			if (abono.isPresent()) {
				response.put("message", "Successful load");
				response.put("data", abono);
				response.put("success", true);
				return response;
			} else {
				response.put("message", "Not found data");
				response.put("data", null);
				response.put("success", false);
				return response;
			}

		} catch (Exception e) {
			response.put("message", "" + e.getMessage());
			response.put("success", false);
			return response;
		}
	}
	
	@GetMapping(value = "/ultimo")
	public Map<String, Object> data() {
		HashMap<String, Object> response = new HashMap<String, Object>();

		try {

			Optional<Profesor> abono = profesorServiceApi.findUltimo();

			if (abono.isPresent()) {
				response.put("message", "Successful load");
				response.put("data", abono);
				response.put("success", true);
				return response;
			} else {
				response.put("message", "Not found data");
				response.put("data", null);
				response.put("success", false);
				return response;
			}

		} catch (Exception e) {
			response.put("message", "" + e.getMessage());
			response.put("success", false);
			return response;
		}
	}
	@PostMapping(value = "/create")
	public ResponseEntity<String> create(@RequestBody Profesor data) {

		try {
			System.out.print("Proceso de guardar datos");
			profesorServiceApi.save(data);
			return new ResponseEntity<>("Save successful ", HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>("" + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(value = "/update/{id}")

	public Map<String, Object> update(@PathVariable("id") Integer id, @RequestBody Profesor data) {

		HashMap<String, Object> response = new HashMap<String, Object>();

		try {
			data.setId(id);
			profesorServiceApi.save(data);
			response.put("message", "Successful update");
			response.put("success", true);
			return response;
		} catch (Exception e) {
			response.put("message", e.getMessage());
			response.put("success", false);
			return response;
		}

	}

	@DeleteMapping(value = "/delete/{id}")

	public Map<String, Object> update(@PathVariable("id") Integer id) {

		HashMap<String, Object> response = new HashMap<String, Object>();

		try {
			profesorServiceApi.deleteById(id);
			;
			response.put("message", "Successful delete");
			response.put("success", true);
			return response;
		} catch (Exception e) {
			response.put("message", e.getMessage());
			response.put("success", false);
			return response;
		}

	}

}
