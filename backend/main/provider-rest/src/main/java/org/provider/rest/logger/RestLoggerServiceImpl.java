package org.provider.rest.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * RestLoggerServiceImpl : Class qui implement et donc definit les methode de
 * IRestLoggerService
 * 
 */
@Service
public class RestLoggerServiceImpl implements IRestLoggerService {

	private static final String EMPTY_STRING = "";
	private static final String PATH_LOG = "/logs/logger.properties";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RestLoggerServiceImpl.class);

	@Override
	public String getMessage(String codeLogger) {

		Properties prop = new Properties();
		FileInputStream in;
		String mess = EMPTY_STRING;

		try {

			String fileName = PATH_LOG;
			in = new FileInputStream(this.getClass().getResource(fileName)
					.getFile());

			prop.load(in);
			in.close();

			// Extraction des propriétés
			mess = prop.getProperty(codeLogger);
		} catch (FileNotFoundException e) {

			LOGGER.info(formatMessage("log.inexistant"));
		} catch (IOException e) {

		}

		return mess;
	}

	@Override
	public String formatMessage(String codeLogger, Object... args) {
		return MessageFormat.format(this.getMessage(codeLogger), args);
	}

}
