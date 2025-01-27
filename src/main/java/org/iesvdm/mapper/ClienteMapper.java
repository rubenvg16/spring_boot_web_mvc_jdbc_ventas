package org.iesvdm.mapper;

import org.iesvdm.modelo.Cliente;
import org.iesvdm.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    public ClienteDTO clienteAClienteDTO(Cliente cliente, Integer numeroTotalPedidos);

    public Cliente clienteDTOACliente(ClienteDTO clienteDTO);
}
