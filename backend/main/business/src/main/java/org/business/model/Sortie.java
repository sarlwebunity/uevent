package org.business.model;

import java.io.Serializable;
import java.util.Date;

public class Sortie implements Serializable {

	private static final long serialVersionUID = -3404978776257125547L;

	private Integer id;
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	private Integer activite;
	private String nbParticipants;
	private Float prix;
	private String photo;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Integer getActivite() {
		return activite;
	}
	public void setActivite(Integer activite) {
		this.activite = activite;
	}
	public String getNbParticipants() {
		return nbParticipants;
	}
	public void setNbParticipants(String nbParticipants) {
		this.nbParticipants = nbParticipants;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}