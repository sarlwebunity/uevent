package org.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SortieEntity : Class representant une sortie. Mapper avec la base
 * (hibernate).
 */
@Entity
@Table(name = "sorties")
public class SortieEntity implements Serializable {

	private static final long serialVersionUID = -3404978776257125547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "date_debut")
	private Date dateDebut;

	@Column(name = "date_fin")
	private Date dateFin;

	@Column(name = "lieu")
	private String lieu;

	@Column(name = "activite")
	private Integer activite;

	@Column(name = "nb_participants")
	private String nbParticipants;

	@Column(name = "prix")
	private Float prix;

	@Column(name = "photo")
	private String photo;

	@Column(name = "description")
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
