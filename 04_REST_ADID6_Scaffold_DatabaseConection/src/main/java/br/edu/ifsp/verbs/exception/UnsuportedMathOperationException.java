package br.edu.ifsp.verbs.exception;

public class UnsuportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}
	
}
