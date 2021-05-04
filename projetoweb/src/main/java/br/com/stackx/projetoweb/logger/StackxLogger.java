package br.com.stackx.projetoweb.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StackxLogger {

	static Logger logger = null;

	static {
		Configurator.initialize("projetoweb",
				"C:\\Users\\danny\\OneDrive\\Área de Trabalho\\projeto_Web\\projetoweb\\src\\main\\webapp\\WEB-INF\\log4j2.xml");
		logger = LogManager.getLogger();
		System.out.println("Logger inicializado!");

	}

	public static void setMensagemError(String msn) {
		logger.error(msn);
	}

	public static void setMensagemWarn(String msn) {
		logger.warn(msn);
	}

	public static void setMensagemInfo(String msn) {
		logger.info(msn);
	}
}
