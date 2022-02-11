package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	boolean agregar(String nombre, int edad, String email);

	boolean agregar(Contacto contacto);

	Contacto buscar(String email);

	boolean eliminar(String email);

	List<Contacto> recuperarContactos();

}