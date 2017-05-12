package org.business.logger;

/**
 *  ILoggerService : Interface services logger definissant les méthodes à implémenter.
 */
public interface ILoggerBusinessService {
	
	
	/**
	 * Méthode qui récupère un message en fonction de son code.
	 *
	 * @param codeLogger Le code correspondant au message désiré
	 * @return String message
	 */
	String getMessage(String codeLogger);
	
	/**
	 * Methode qui retourne un message formaté 
	 *
	 * @param codeLogger le code du message à retourner
	 * @param args liste des arguments à introduire dans le message
	 * @return String le message formaté
	 */
	String formatMessage(String codeLogger, Object... args);
	
}
