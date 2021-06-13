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

import com.example.demo.entites.EntityCitas;
import com.example.demo.repositories.RepositoryCitas;

@RestController
@RequestMapping("/citas")
public class ControlerCitas {

	@Autowired
	RepositoryCitas repositoryCitas;

	@GetMapping
	public Collection<EntityCitas> getCitas() {
		Iterable<EntityCitas> citas = repositoryCitas.findAll();
		return (Collection<EntityCitas>) citas;
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void deleteCita(@PathVariable(name = "id") Long id) {
		repositoryCitas.deleteById(id);

	}

	@GetMapping(value = "/{id}")
	public EntityCitas getCita(@PathVariable(name = "id") Long id) {
		Optional<EntityCitas> cita = repositoryCitas.findById(id);
		EntityCitas mostrarr = null;
		if (cita.isPresent()) {
			mostrarr = cita.get();

		}
		return mostrarr;

	}


	@PutMapping(value = "/{id}")
	public EntityCitas putCita(@PathVariable(name = "id") Long id, @RequestBody EntityCitas date) {
		Optional<EntityCitas> citaM = repositoryCitas.findById(id);
		if (citaM.isPresent()) {
			EntityCitas act = citaM.get();
			act.setEstado(date.getEstado());
			act.setPaciente(date.getPaciente());
			act.setObservacion(date.getObservacion());
			act.setFecha(date.getFecha());
			act.setHora(date.getHora());
			act.setId(date.getId());
			EntityCitas nuevaCita = repositoryCitas.save(act);
			return nuevaCita;

		}
		return null;
	}

	

	
}
