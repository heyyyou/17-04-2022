package com.projet.BackendPfe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.BackendPfe.model.AvisExpert;
import com.projet.BackendPfe.model.Expert;
import com.projet.BackendPfe.model.Generaliste;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.AutoDetectionRepository;
import com.projet.BackendPfe.repository.AvisExpertRepository;
import com.projet.BackendPfe.repository.ExpertRepository;
import com.projet.BackendPfe.request.PatientRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/avisExpert")
public class avisExpertController {
	@Autowired ExpertRepository exp;
	@Autowired AvisExpertRepository repository ;
	@PostMapping("/addAvis/{idExpert}")
	public void AddProduct(@RequestBody AvisExpert avisExpert,  @PathVariable("id")  long id ){
		Expert  expert = exp.findById(id).get(); 
		AvisExpert avis = new AvisExpert(avisExpert.getMaladieDroite(),avisExpert.getMaladieGauche(),expert,avisExpert.getGraviteGauche(),avisExpert.getGraviteDroite(),avisExpert.getCommentaireDroite(),avisExpert.getCommentaireGauche());
	repository.save(avis);
	}
}
