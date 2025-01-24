package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.modelo.Comercial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;


//Anotación lombok para logging (traza) de la aplicación
@Slf4j
@Repository
//Utilizo lombok para generar el constructor
@AllArgsConstructor
public class ComercialDAOImpl implements ComercialDAO {

	//JdbcTemplate se inyecta por el constructor de la clase automáticamente
	//
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Comercial cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comercial> getAll() {
		
		List<Comercial> listComercial = jdbcTemplate.query(
                "SELECT * FROM comercial",
                (rs, rowNum) -> new Comercial(rs.getInt("id"), 
                							  rs.getString("nombre"), 
                							  rs.getString("apellido1"),
                							  rs.getString("apellido2"), 
                							  rs.getFloat("comisión"))
                						 	
        );

		log.info("Devueltos {} registros.", listComercial.size());
		
        return listComercial;
	}

	@Override
	public Optional<Comercial> find(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Comercial cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
