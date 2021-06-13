package com.example.demo.cotrolers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.EntityPacientes;
import com.example.demo.repositories.RepositoryPacientes;

@RestController
@RequestMapping(value = "/pacientes")
public class ControlerPacientes {

	@Autowired
	RepositoryPacientes repositoryPacientes;

	@GetMapping
	public Collection<EntityPacientes> getPacientes() {
		Iterable<EntityPacientes> pacientes = repositoryPacientes.findAll();
		return (Collection<EntityPacientes>) pacientes;
	}

	@PutMapping(value = "/{id}")
	public EntityPacientes putPaciente(@PathVariable(name = "id") Long id, @RequestBody EntityPacientes pacientes11) {
		Optional<EntityPacientes> pacienteM = repositoryPacientes.findById(id);
		if (pacienteM.isPresent()) {
			EntityPacientes actual = pacienteM.get();
			actual.setId(pacientes11.getId());
			actual.setNombre1(pacientes11.getNombre1());
			actual.setNombre2(pacientes11.getNombre2());
			actual.setApellidos(pacientes11.getApellidos());
			actual.setEdad(pacientes11.getEdad());
			EntityPacientes pacientes = repositoryPacientes.save(actual);
			return pacientes;

		}
		return null;
	}

	@GetMapping(value = "/{id}")
	public EntityPacientes getPaciente(@PathVariable(name = "id") Long id) {
		Optional<EntityPacientes> pacientess = repositoryPacientes.findById(id);
		EntityPacientes mostrar = null;
		if (pacientess.isPresent()) {
			mostrar = pacientess.get();
		}
		return mostrar;
	}

	@DeleteMapping(value = "/{id}")
	public void borrarDatos(@PathVariable(name = "id") Long id) {
		repositoryPacientes.deleteById(id);
	}

}
