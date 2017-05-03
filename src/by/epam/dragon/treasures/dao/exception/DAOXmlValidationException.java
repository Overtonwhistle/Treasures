package by.epam.dragon.treasures.dao.exception;

public class DAOXmlValidationException extends DAOException {
	private static final long serialVersionUID = 1L;

	public DAOXmlValidationException() {
		super();
	}

	public DAOXmlValidationException(String message) {
		super(message);
	}

	public DAOXmlValidationException(Exception e) {
		super(e);
	}

	public DAOXmlValidationException(String message, Exception e) {
		super(message, e);
	}
}
