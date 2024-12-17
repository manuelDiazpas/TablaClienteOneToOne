package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.service.ServiceDAO;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ServiceDAO servicio;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		return ResponseEntity.ok(servicio.getClientes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteID(@PathVariable Integer id) {
		Cliente c = servicio.getClienteID(id);

		if (c == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	@PostMapping
	public ResponseEntity insertarCliente(@RequestBody Cliente clienteN) {
		servicio.insertarCliente(clienteN);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity actualizarCliente(@RequestBody Cliente clienteN) {
		servicio.actualizarCliente(clienteN);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity eliminarCliente(Integer id) {
		servicio.eliminarCliente(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/cambioDireccio/{id}")
	public ResponseEntity<Cliente> alterarDireccionCliente(@PathVariable Integer id, Direccion direccionN) {
		Cliente c = servicio.alterarDireccionCliente(id, direccionN);
		if (c == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	@PutMapping("/actualizarDireccionSevilla")
	public ResponseEntity alterarDireccionSevilla() {
		servicio.actualizarCiudadSevilla();
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/actualizarCiudad/{ciudad}/{letra}")
	public ResponseEntity<String> actualizarCiudad(@PathVariable String ciudad, @PathVariable String letra) {
		servicio.actualizarCiudad(ciudad, letra);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/listaClientes/{ciudad}")
	public ResponseEntity<List<Cliente>> clientesPorCiudad(@PathVariable String ciudad) {
		return ResponseEntity.ok(servicio.clientesPorCiudad(ciudad));
	}

}
