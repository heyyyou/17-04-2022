package com.projet.BackendPfe.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.Expert;
import com.projet.BackendPfe.model.Generaliste;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.ConsultationRepository;
import com.projet.BackendPfe.repository.ExpertRepository;
import com.projet.BackendPfe.repository.GeneralisteRepository;
import com.projet.BackendPfe.repository.PatientRepository;
import com.projet.BackendPfe.services.ConsultationService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/consultation")
public class ConsulationController {
	@Autowired ConsultationRepository repository ;
	@Autowired GeneralisteRepository medecinRepository;
	@Autowired PatientRepository patientRepository;
	@Autowired ExpertRepository expertRepository;
	@Autowired ConsultationService service ; 
	
	
	@PostMapping("/Consultations/{idGeneraliste}/{idPatient}")
	public Consultation addConsultation(@PathVariable("idGeneraliste") long idGeneraliste , 
			                                                                 @PathVariable("idPatient") long idPatient  ){
		Generaliste  generaliste = medecinRepository.findById(idGeneraliste).get(); 
		Patient patient = patientRepository.findById(idPatient).get() ; 
		byte[] image1 = null ; 
		byte[] image2 = null ; 
		byte[] image3 = null ; 
		byte[] image4 = null ; 
		byte[] image5 = null ; 
		byte[] image6 = null ; 
		byte[] image7 = null ; 
		byte[] image8 = null ; 
		byte[] image9 = null ; 
		byte[] image10 = null ; 
		Expert expert=null;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println("eeeeeeeeee"+date);
		

		Consultation consultation = new Consultation(generaliste, expert, patient,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,date);
		repository.save(consultation) ;
		return consultation ; 

	}
	// put for expert baed f avis demander 
	
	@PutMapping("SendConsultation/{idConsultation}/{idExpert}")
	public Consultation EnvoyerConultationAunExpert(@PathVariable("idConsultation") long idConsultation , 
			                                                                                               @PathVariable("idExpert") long idExpert) {
		Consultation consultation = repository.findById(idConsultation).get() ;
		Expert expert = expertRepository.findById(idExpert).get() ;
	   consultation.setExpert(expert);
	   repository.save(consultation) ;
	   return consultation ; 
	}
	/***********Oeil Droite *************/
	
	@PutMapping("/addimage1D/{idConsultation}")
	public String updateImage1D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image1") MultipartFile image1) throws IOException {
		service.updateImage1Droite(idConsultation , image1);
		return "Done pour image1 Droite !!!!" ; 
	}

	@PutMapping("/addimage2D/{idConsultation}")
	public String updateImage2D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image2") MultipartFile image2 ) throws IOException {
			service.updateImage2Droite(idConsultation,  image2);
		return "Done pour image2  Droite!!!!" ; 
	}
	@PutMapping("/addimage3D/{idConsultation}")
	public String updateImage3D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image3") MultipartFile image3) throws IOException {
		service.updateImage3Droite(idConsultation , image3);
		return "Done pour image3 Droite !!!!" ; 
	}
	@PutMapping("/addimage4D/{idConsultation}")
	public String updateImage4D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image4") MultipartFile image4 ) throws IOException {
		service.updateImage4Droite(idConsultation , image4);
		return "Done pour image4  Droite!!!!" ; 
	}
	@PutMapping("/addimage5D/{idConsultation}")
	public String updateImage5D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image5") MultipartFile image5        ) throws IOException {

		service.updateImage5Droite(idConsultation, image5);
		return "Done pour image5 Droite  !!!!" ; 
	}
	
	
	/***********Oeil Gauche *************/
	
	@PutMapping("/addimage1G/{idConsultation}")
	public String updateImage1G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image1") MultipartFile image1  ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage1Gauche(idConsultation , image1);
		return "Done pour image1 Gauche !!!!" ; 
	}
	@PutMapping("/addimage2G/{idConsultation}")
	public String updateImage2G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image2") MultipartFile image2 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage2Gauche(idConsultation, image2);
		return "Done pour image2  Gauche!!!!" ; 
	}
	@PutMapping("/addimage3G/{idConsultation}")
	public String updateImage3G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image3") MultipartFile image3 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage3Gauche(idConsultation, image3);
		return "Done pour image3 Gauche !!!!" ; 
	}
	@PutMapping("/addimage4G/{idConsultation}")
	public String updateImage4G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image4") MultipartFile image4 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage4Gauche(idConsultation,  image4);
		return "Done pour image4  Gauche!!!!" ; 
	}
	@PutMapping("/addimage5G/{idConsultation}")
	public String updateImage5G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image5") MultipartFile image5        ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage5Gauche(idConsultation , image5);
		return "Done pour image5 Gauche  !!!!" ; 
	}
	
	
	@DeleteMapping("/deletepatients/{id}/{idConsultation}")
	public void deleteProduct(@PathVariable("id") long id){
		
	
		patientRepository.deleteById(id);
	} 
	@GetMapping("/Consultations/{id}")
	public List<Consultation> getAllProducts(@PathVariable("id") @ModelAttribute("id") long id){
         //pr.findById(id);
		  
		return repository.findAll();
	} 
	/*@GetMapping("/Consultation/{id}/{idConsultation}")
	public Consultation getAllProductsbyid(@PathVariable("id") long id,@PathVariable("idConsultation") long idConsultation){
		Consultation conster = repository.findById(idConsultation).get();

		return conster;
		  
		
	}*/
	
	/*
	 public void AddProduct(@PathVariable("id") long id ,@PathVariable("cin") long cin  ){
		Generaliste gen = pr1.findById(id).get();
		Patient pat = pr2.findById(cin).get();
	
		Consultation data = new Consultation(gen,pat);
		
		pr.save(data);
	}*/
}
