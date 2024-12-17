package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;

public interface RepositoryDAO {

	List<Cliente> getClientes();

	Cliente getClienteID(Integer id);

	void insertarCliente(Cliente clienteN);

	void actualizarCliente(Cliente clienteN);

	void eliminarCliente(Cliente cliente);

	List<Cliente> actualizarCiudad(String letra);

	List<Cliente> clientesPorCiudad(String ciudad);

}
