package br.ucsal.plano.disciplina.exception;

public class NoSuchElementException extends RuntimeException{

	private static final long serialVersionUID = -5455153047541640894L;

	public NoSuchElementException(String message) {
		super(message);
	}
}
