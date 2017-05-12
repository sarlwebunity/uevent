package org.business;

import org.business.model.User;

/**
 * IUtilisateurService : Interface services Utilisateur definissant les méthodes à implémenter.
 */
public interface IUserService {

	/**
	 * Méthode qui récupère un utilisateur en fonctiondu code ident passé en paramètre.
	 *
	 * @param codeIdent code ident de l'utilisateur à récupérer.
	 * @return l'objet utilisateur désiré.
	 */
	User getUser(Integer id);
	
	/**
	 * Méthode qui crée un user en base
	 *
	 * @param user user à créer.
	 * @return l'objet user créé
	 */
	User createUser(User user);
	
	/**
	 * Checks si le user est habilité à consulter le salarié
	 *
	 * @param user l'utilisateur connecté
	 * @param codeIdent le codeIdent du salarié à consulter
	 * @return the boolean
	 */
	Boolean isAuthorized(User user, String codeIdent);
}