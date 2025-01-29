package org.iesvdm.controlador;

import java.util.List;

import lombok.AllArgsConstructor;
import org.iesvdm.mapper.ClienteMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ClienteService;
import org.iesvdm.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller

//Para utilizar una base de url, pero se visualiza mejor con toda la ruta en los métodos
//@RequestMapping("/fabricantes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteMapper clienteMapper;


	@GetMapping("/clientes")
	public String listar(Model model) {

		List<Cliente> listAllCli =  clienteService.listAll();
		model.addAttribute("listaClientes", listAllCli);

		return "clientes";

	}

	@GetMapping("/clientes/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);
		return "detalle-cliente";

	}

	@GetMapping("/clientes/crear")
	public String crear(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "crear-cliente";

	}

	@PostMapping("/clientes/crear")
	public RedirectView submitCrear(@ModelAttribute("cliente") Cliente cliente) {

		clienteService.newCliente(cliente);

		return new RedirectView("/clientes") ;

	}

	@GetMapping("/clientes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "editar-cliente";

	}


	@PostMapping("/clientes/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("cliente") Cliente cliente) {

		clienteService.replaceCliente(cliente);

		return new RedirectView("/clientes");
	}

	@PostMapping("/clientes/eliminar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {

		clienteService.deleteCliente(id);

		return new RedirectView("/clientes");
	}
}
