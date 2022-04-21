package com.projet.BackendPfe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AvisExpert {
	private String commentaireGauche;
	private String commentaireDroite;
	
	public String getCommentaireGauche() {
		return commentaireGauche;
	}

	public void setCommentaireGauche(String commentaireGauche) {
		this.commentaireGauche = commentaireGauche;
	}

	public String getCommentaireDroite() {
		return commentaireDroite;
	}

	public void setCommentaireDroite(String commentaireDroite) {
		this.commentaireDroite = commentaireDroite;
	}
	@ManyToOne()
	private Expert expert;

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public AvisExpert(String maladieDroite, String maladieGauche, Expert expert, int graviteDroite, int graviteGauche,String commentaireGauche,String commentaireDroite) {
		super();
		this.maladieDroite = maladieDroite;
		this.maladieGauche = maladieGauche;
		this.graviteDroite = graviteDroite;
		this.graviteGauche = graviteGauche;
		this.expert = expert;
		this. commentaireGauche= commentaireGauche;
		this. commentaireDroite= commentaireDroite;

	}

	private String maladieDroite;
	private String maladieGauche;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMaladieDroite() {
		return maladieDroite;
	}

	public void setMaladieDroite(String maladieDroite) {
		this.maladieDroite = maladieDroite;
	}

	public String getMaladieGauche() {
		return maladieGauche;
	}

	public void setMaladieGauche(String maladieGauche) {
		this.maladieGauche = maladieGauche;
	}

	public int getGraviteDroite() {
		return graviteDroite;
	}

	public void setGraviteDroite(int graviteDroite) {
		this.graviteDroite = graviteDroite;
	}

	public int getGraviteGauche() {
		return graviteGauche;
	}

	public void setGraviteGauche(int graviteGauche) {
		this.graviteGauche = graviteGauche;
	}

	public List<Consultation> getAvisExpert() {
		return avisExpert;
	}

	public void setAvisExpert(List<Consultation> avisExpert) {
		this.avisExpert = avisExpert;
	}

	private int graviteDroite;
	private int graviteGauche;
	@OneToMany(targetEntity = Consultation.class, mappedBy = "avisExpert", fetch = FetchType.LAZY)
	private List<Consultation> avisExpert = new ArrayList<Consultation>();
}