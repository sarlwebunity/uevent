package org.provider.rest.utils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * MessagesRestUtils : class qui permet de construire un message depuis
 * MessageResources_fr.properties
 * 
 */
@Service
public final class MessagesRestUtils {

	/** Le logger. */
	private static final Log LOGGER = LogFactory
			.getLog(MessagesRestUtils.class);

	/** Les noms des bundles. */
	private static String[] bundlesNames = { "messagesResources/messagesResources" };

	/** La liste des bundles pour la locale. */
	private static final Map<Locale, List<ResourceBundle>> BUNDLES_MAP = new HashMap<Locale, List<ResourceBundle>>();

	/** La locale utilisée. */
	private static Locale locale = Locale.FRANCE;

	/** Le classloader utilisé. */
	private static ClassLoader classLoader;

	private static final int MESSAGE_BUFFER_INITIAL_CAPACITY = 8;
	private static final int MESSAGE_FORMAT_BUFFER_INITIAL_CAPACITY = 10;
	private static final String KEY_NOT_FOUND = "Impossible de trouver la clef \"{0}\" dans les fichiers de messages";
	private static final String QUESTION_MARK = "??_";
	private static final String QUESTION_MARK_REVERT = "_??";

	/**
	 * Construit le MessagesUtil.
	 */
	private MessagesRestUtils() {
		super();
	}

	/**
	 * Getter de l'attribut classLoader.
	 * 
	 * @return the classLoader
	 */
	public static ClassLoader getClassLoader() {
		return classLoader;
	}

	/**
	 * Setter de l'attribut classLoader.
	 * 
	 * @param classLoader
	 *            the classLoader to set
	 */

	public static void setClassLoader(ClassLoader classLoader) {
		MessagesRestUtils.classLoader = classLoader;
	}

	/**
	 * Initialise les bundles.
	 * 
	 * @param newLocale
	 *            la locale par défaut
	 * @param names
	 *            la liste des noms des bundles
	 */
	@PostConstruct
	public static void init() {
		BUNDLES_MAP.put(locale, getBundles(locale));
	}

	/**
	 * Récupère les bundles correspondant à la locale.
	 * 
	 * @param newLocale
	 *            la locale
	 * @return La liste des bundles à charger
	 */
	private static List<ResourceBundle> getBundles(Locale newLocale) {

		List<ResourceBundle> result = new ArrayList<ResourceBundle>();

		if (bundlesNames != null) {

			ResourceBundle bundle = null;

			for (String bundleName : bundlesNames) {

				bundle = getBundle(bundleName, newLocale);

				if (bundle != null) {

					result.add(bundle);
				}
			}
		}
		return result;
	}

	private static ResourceBundle getBundle(String bundleName, Locale newLocale) {

		ResourceBundle bundle = null;

		try {

			if (bundleName != null) {

				if (getClassLoader() != null) {

					bundle = ResourceBundle.getBundle(bundleName.trim(),
							newLocale, getClassLoader());
				} else {

					bundle = ResourceBundle.getBundle(bundleName.trim(),
							newLocale);
				}
			}
		} catch (MissingResourceException mre) {

			bundle = null;
		}
		return bundle;
	}

	/**
	 * Formatte le message.
	 * 
	 * @param messageKey
	 *            la clef du messages
	 * @param args
	 *            les arguments des messages
	 * @return le message formater
	 */
	public static String formatMessage(String messageKey, Object... args) {
		return formatMessage(messageKey, null, args);
	}

	/**
	 * Formatte le message.
	 * 
	 * @param messageKey
	 *            la clef du messages
	 * @param newLocale
	 *            la locale
	 * @param args
	 *            les arguments des messages
	 * @return le message formater
	 */
	public static String formatMessage(String messageKey, Locale newLocale,
			Object... args) {

		String i18nMessage = null;
		MessageFormat format = null;

		if (newLocale == null || newLocale.equals(locale)) {

			i18nMessage = getMessage(messageKey);
			format = new MessageFormat(i18nMessage, locale);
		} else {

			i18nMessage = getMessage(messageKey, newLocale);
			format = new MessageFormat(i18nMessage, newLocale);
		}

		return format.format(args,
				new StringBuffer(MESSAGE_FORMAT_BUFFER_INITIAL_CAPACITY), null)
				.toString();
	}

	/**
	 * Récupère le message internationalisé
	 * 
	 * @param messageKey
	 *            la clef du message
	 * @return le message internationalisé
	 */
	private static String getMessage(String messageKey) {
		return getMessage(messageKey, locale);
	}

	/**
	 * Récupère le message internationalisé
	 * 
	 * @param messageKey
	 *            la clef du message
	 * @param newLocale
	 *            la locale
	 * @return le message internationalisé
	 */
	private static String getMessage(String messageKey, Locale newLocale) {

		List<ResourceBundle> bList = BUNDLES_MAP.get(newLocale);

		if (bList == null) {

			bList = getBundles(newLocale);
			BUNDLES_MAP.put(newLocale, bList);
		}
		String result = getMessageForBundles(messageKey, bList);

		// cas ou on n'a pas trouvéla clef
		if (result == null) {

			LOGGER.warn(KEY_NOT_FOUND
					+ messageKey);
			
			StringBuilder resultTmp = new StringBuilder(
					MESSAGE_BUFFER_INITIAL_CAPACITY);
			
			resultTmp.append(QUESTION_MARK);
			resultTmp.append(messageKey);
			resultTmp.append(QUESTION_MARK_REVERT);
			result = resultTmp.toString();
		}
		return result;
	}

	/**
	 * Récupère le message internationalisé
	 * 
	 * @param messageKey
	 *            la clef du message
	 * @param bundlesList
	 *            la liste des bundles pouvant contenir le messages
	 * @return le message internationalisé
	 */
	private static String getMessageForBundles(String messageKey,
			List<ResourceBundle> bundlesList) {

		String result = null;
		
		Iterator<ResourceBundle> itb = (Iterator<ResourceBundle>) bundlesList
				.iterator();

		ResourceBundle bundle = null;

		while (itb.hasNext() && result == null) {

			bundle = itb.next();
			result = getResource(bundle, messageKey);
		}
		return result;
	}

	public static String getResource(ResourceBundle bundle, String messageKey) {

		String resource = null;

		try {

			resource = bundle.getString(messageKey);
		} catch (MissingResourceException e) {

			resource = null;
		}
		return resource;
	}
}
