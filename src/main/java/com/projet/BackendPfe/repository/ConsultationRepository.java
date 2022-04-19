package com.projet.BackendPfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.Patient;


@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
	public List<Consultation> findByGeneraliste_id(@ModelAttribute("id") long id);

}