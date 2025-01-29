package org.iesvdm.service;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	public List<Cliente> listAll() {

		List<Cliente> listAll = clienteDAO.getAll();

		return listAll;

	}

	public Cliente one(Integer id) {
		Optional<Cliente> optCli = clienteDAO.find(id);
		if (optCli.isPresent())
			return optCli.get();
		else
			return null;
	}

	public void newCliente(Cliente cliente) {
		clienteDAO.create(cliente);

	}

	public void replaceCliente(Cliente cliente) {

		clienteDAO.update(cliente);

	}

	public void deleteCliente(int id) {

		clienteDAO.delete(id);

	}
}
