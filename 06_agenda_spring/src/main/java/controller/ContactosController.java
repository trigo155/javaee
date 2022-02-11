package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.ContactosService;

@Controller
public class ContactosController {
	@Autowired
	ContactosService service;
	
	@PostMapping("altaContacto")
	public String agregarNuevo(@RequestParam("nombre") String nombre, 
								@RequestParam("edad") int edad,
								@RequestParam("email") String email
							   
							   ) {
		if(!service.agregar(nombre, edad, email)) {
			return "altaContacto";
		}else{
			return "creado";
		}
		
		
	}
	
	@GetMapping("eliminarContacto")
	public String eliminar(@RequestParam("email") String email) {
		service.eliminar(email);
		return "forward:/recuperarContactos";
	}
	
	@GetMapping("recuperarContactos")
	public String recuperar(HttpServletRequest request) {
		List<Contacto> contactos=service.recuperarContactos();
		if(contactos.size()>0) {
			request.setAttribute("new_table", contactos);
			return "listado";
		}else {
			return "sincontactos";
		}
	}
	

}
