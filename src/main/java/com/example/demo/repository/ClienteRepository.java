package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ClienteRepository implements RepositoryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> getClientes() {
		return entityManager.createQuery("Select c from Cliente c", Cliente.class).getResultList();
	}

	@Override
	public Cliente getClienteID(Integer id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public void insertarCliente(Cliente clienteN) {
		entityManager.persist(clienteN);

	}

	@Override
	public void actualizarCliente(Cliente clienteN) {
		entityManager.merge(clienteN);

	}

	@Override
	public void eliminarCliente(Cliente c) {
		entityManager.remove(c);
	}


	@Override
	public List<Cliente> actualizarCiudad(String letra) {
		Query query = entityManager.createQuery("Select c from Cliente c where c.nombre LIKE :letra", Cliente.class);

		query.setParameter("nombre", letra + "%");

		return query.getResultList();
	}

	@Override
	public List<Cliente> clientesPorCiudad(String ciudad) {
		Query query = entityManager.createQuery(
				"Select c from Cliente c Join Direccion d where d.ciudad = :ciudad",
				Cliente.class);

		query.setParameter("ciudad", "%" + ciudad + "%");

		return query.getResultList();
	}

}
