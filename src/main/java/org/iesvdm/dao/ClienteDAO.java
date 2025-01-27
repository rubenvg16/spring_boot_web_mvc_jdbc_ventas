package org.iesvdm.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;

public interface ClienteDAO {

	void create(Cliente cliente);
	List<Cliente> getAll();
	Map<Integer, Integer> getNumeroPedidosByIdCliente();
	Optional<Cliente>  find(int id);
	void update(Cliente cliente);
	void delete(long id);
	
}
