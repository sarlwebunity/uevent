package org.provider.rest;

import java.util.Date;

import org.business.IUserService;
import org.business.model.User;
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
 * UtilisateurController : Class controller permettant d'envoyer des utlisateurs
 * en json dans l'url défini.
 */
@RestController
public class UserController {

	// URL
	private static final String URL_USER_CREATE = "/users/create";
	private static final String URL_USER_ID = "/users/{id}";
	private static final String URL_USER_ALL = "/users";

	@Autowired
	private IUserService userService;

	/**
	 * Méthode qui récupère le user en json selon son id
	 *
	 * @return le user demandé en json
	 */
	@RequestMapping(value = URL_USER_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUser(
			@PathVariable(value = ConstantesRestUtil.ID) Integer id) {

		// On récupère le user
		ResponseEntity<User> respEntity = new ResponseEntity<User>(userService.getUser(id),	HttpStatus.OK);

		return respEntity;
	}
	
	/**
	 * Méthode qui récupère le user en json selon son id
	 *
	 * @return le user demandé en json
	 */
	@RequestMapping(value = URL_USER_CREATE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> createUser() {

		User user = new User();
		user.setId(2);
		user.setNom("Durand");
		user.setPrenom("Barbara");
		user.setEmail("totot@gmail.com");
		user.setPassword("roro");
		user.setSexe("F");
		user.setVille("Toulouse");
		user.setDateNaissance(new Date());
		// On crée le user
		ResponseEntity<User> respEntity = new ResponseEntity<User>(userService.createUser(user),	HttpStatus.OK);

		return respEntity;
	}
	
}
