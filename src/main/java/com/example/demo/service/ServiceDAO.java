package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;

public interface ServiceDAO {

	List<Cliente> getClientes();

	Cliente getClienteID(Integer id);

	void insertarCliente(Cliente clienteN);

	void actualizarCliente(Cliente clienteN);

	void eliminarCliente(Integer id);

	Cliente alterarDireccionCliente(Integer id, Direccion direccionN);

	void actualizarCiudadSevilla();

	void actualizarCiudad(String ciudad, String letra);

	List<Cliente> clientesPorCiudad(String ciudad);
}
