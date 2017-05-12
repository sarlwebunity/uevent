package org.business;

import java.util.List;

import org.business.model.Sortie;

/**
 * ISortieService : Interface services Sortie definissant les méthodes à implémenter.
 */
public interface ISortieService {

	/**
	 * Méthode qui récupère une sortie en fonction de son id passé en paramètre.
	 *
	 * @param id Identifiant de la sortie à récupérer.
	 * @return l'objet sortie désiré.
	 */
	Sortie getSortie(Integer id);
	
	/**
	 * Méthode qui récupère une liste de sorties en fonction du lieu passé en paramètre.
	 *
	 * @param lieu Lieu ou se déroulent les sortie à récupérer.
	 * @return la liste des sorties désirées.
	 */
	List<Sortie> getSortieByLieu(String lieu);
	
	/**
	 * Méthode qui récupère la liste de toutes les sorties.
	 *
	 * @return la liste de toutes les sorties désirées.
	 */
	List<Sortie> getAllSortie();
}