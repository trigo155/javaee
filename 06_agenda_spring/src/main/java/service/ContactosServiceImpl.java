package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Contacto;

@Service
public class ContactosServiceImpl implements ContactosService {
	
	// por medio de Spring inyectamos JdbcTemplate
	//(captura de excepciones, envía consultas a la BBDD, mapea resultados, cierra conexiones)
	@Autowired
	JdbcTemplate template;

	@Override
	public boolean agregar(String nombre, int edad, String email) {
		String sql="insert into new_table(nombre,edad,email) values(?,?,?)";
		if(template.update(sql, nombre, edad, email)==0) {
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean agregar(Contacto contacto) {
		return agregar(contacto.getNombre(), contacto.getEdad(), contacto.getEmail());	
	}

	@Override
	public Contacto buscar(String email) {
		String sql="select * from new_table where email=?";
		List<Contacto> new_table=template.query(sql, 
				(r,f)->new Contacto(r.getInt("idContacto"),
									r.getString("nombre"),
									r.getString("email"),
									r.getInt("edad")), email);
		return new_table.size()>0?new_table.get(0):null;
	}
		

	@Override
	public boolean eliminar(String email) {
		String sql="delete from new_table where email=?";
		return template.update(sql,email)>0;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String sql="select * from new_table";
		return template.query(sql, (r,f)->new Contacto(r.getInt("idContacto"),
														r.getString("nombre"),
														r.getString("email"),
														r.getInt("edad")));	
	}

}
