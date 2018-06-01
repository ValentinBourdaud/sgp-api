package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;

@CrossOrigin
@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {
		return this.collaborateurRepo.findAll();
	}

	@GetMapping(params = { "departements" })
	public List<Collaborateur> findCollaborateurById(@RequestParam("departements") int id) {

		return this.collaborateurRepo.findByDepartementId(id);
	}

	@GetMapping(path = "/{matricule}")
	public Collaborateur findCollaborateurByMatricule(@PathVariable("matricule") String matricule) {

		return this.collaborateurRepo.findByMatricule(matricule);
	}

	@PutMapping(path = "/{matricule}")
	public void modifierCollaborateur(@PathVariable("matricule") String matricule, @RequestBody Collaborateur collab) {
		collab.setMatricule(matricule);
		this.collaborateurRepo.save(collab);
	}

	@GetMapping(path = "/{matricule}/banque")
	public Banque findBanqueByMatricule(@PathVariable("matricule") String matricule) {
		return this.collaborateurRepo.findByMatricule(matricule).getBanque();
	}

	@PutMapping(path = "/{matricule}/banque")
	public void modifierBanque(@PathVariable("matricule") String matricule, @RequestBody Banque banque) {
		Collaborateur collab = collaborateurRepo.findByMatricule(matricule);
		collab.setBanque(banque);
		this.collaborateurRepo.save(collab);
	}
}
