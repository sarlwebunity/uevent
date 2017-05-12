package org.provider.rest;

import java.util.List;

import org.business.ISortieService;
import org.business.model.Sortie;
import org.provider.rest.utils.ConstantesRestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SortieController : Class controller permettant d'accéder aux sorties
 * en json dans l'url défini.
 */
@RestController
public class SortieController {

	// URL
	private static final String URL_SORTIE_BY_LIEU = "/sorties/{lieu}";
	private static final String URL_SORTIE_ID = "/sorties/{id}";
	private static final String URL_USER_ALL = "/sorties";

	@Autowired
	private ISortieService sortieService;

	/**
	 * Méthode qui récupère la sortie en json selon son id
	 *
	 * @return la sortie demandée en json
	 */
	@RequestMapping(value = URL_SORTIE_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Sortie> getSortie(
			@PathVariable(value = ConstantesRestUtil.ID) Integer id) {

		// On récupère la sortie
		ResponseEntity<Sortie> respEntity = new ResponseEntity<Sortie>(sortieService.getSortie(id),	HttpStatus.OK);

		return respEntity;
	}
	
	/**
	 * Méthode qui récupère la liste des sorties par rapport à un lieu en json
	 *
	 * @return la liste des sorties demandées en json
	 */
	@RequestMapping(value = URL_SORTIE_BY_LIEU, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Sortie>> getSortieByLieu(
			@PathVariable(value = "lieu") String lieu) {

		// On récupère la sortie
		ResponseEntity<List<Sortie>> respEntity = new ResponseEntity<List<Sortie>>(sortieService.getSortieByLieu(lieu),	HttpStatus.OK);

		return respEntity;
	}
	
	/**
	 * Méthode qui récupère la liste complete des sorties en json
	 *
	 * @return la liste des sorties demandées en json
	 */
	@RequestMapping(value = URL_USER_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Sortie>> getAllSortie() {

		// On récupère la liste des sorties
		ResponseEntity<List<Sortie>> respEntity = new ResponseEntity<List<Sortie>>(sortieService.getAllSortie(),	HttpStatus.OK);

		return respEntity;
	}
}
