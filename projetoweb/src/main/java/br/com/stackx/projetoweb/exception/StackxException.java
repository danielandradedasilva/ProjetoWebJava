package br.com.stackx.projetoweb.exception;

import br.com.stackx.projetoweb.logger.StackxLogger;

public class StackxException extends Exception {

	private String mensagem;
	private Exception exception;

	public StackxException() {
		this(null, null);
	}

	public StackxException(String mensagem, Exception exception) {
		super(mensagem, exception);

		this.mensagem = mensagem;
		this.exception = exception;

		// gravar erro em disco
		StackxLogger.setMensagemError(mensagem);
		StackxLogger.setMensagemError(exception.toString());

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
