package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.repository.RepositoryDAO;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements ServiceDAO {

	@Autowired
	private RepositoryDAO repositorio;

	@Override
	public List<Cliente> getClientes() {
		return repositorio.getClientes();
	}

	@Override
	public Cliente getClienteID(Integer id) {
		return repositorio.getClienteID(id);
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente clienteN) {
		repositorio.insertarCliente(clienteN);

	}

	@Override
	@Transactional
	public void actualizarCliente(Cliente clienteN) {
		repositorio.actualizarCliente(clienteN);
	}

	@Override
	@Transactional
	public void eliminarCliente(Integer id) {
		Cliente c = repositorio.getClienteID(id);
		repositorio.eliminarCliente(c);

	}

	@Override
	public Cliente alterarDireccionCliente(Integer id, Direccion direccionN) {
		Cliente c = repositorio.getClienteID(id);
		if (c == null) {
			return null;
		} else {
			c.setDireccion(direccionN);
			repositorio.actualizarCliente(c);
			return c;
		}
	}

	@Override
	public void actualizarCiudadSevilla() {
		List<Cliente> clientes = repositorio.actualizarCiudad("a");

		for (Cliente cliente : clientes) {
			cliente.getDireccion().setCiudad("Sevilla");
			repositorio.actualizarCliente(cliente);
		}

	}

	@Override
	public void actualizarCiudad(String ciudad, String letra) {
		List<Cliente> clientes = repositorio.actualizarCiudad(letra);
		for (Cliente cliente : clientes) {
			cliente.getDireccion().setCiudad(ciudad);
			repositorio.actualizarCliente(cliente);
		}

	}

	@Override
	public List<Cliente> clientesPorCiudad(String ciudad) {
		return repositorio.clientesPorCiudad(ciudad);
	}

}
