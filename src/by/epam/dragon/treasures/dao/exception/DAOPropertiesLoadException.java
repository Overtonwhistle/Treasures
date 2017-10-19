package by.epam.dragon.treasures.dao.exception;

public class DAOPropertiesLoadException extends DAOException {
	private static final long serialVersionUID = 1L;

	public DAOPropertiesLoadException() {
		super();
	}

	public DAOPropertiesLoadException(String message) {
		super(message);
	}

	public DAOPropertiesLoadException(Exception e) {
		super(e);
	}

	public DAOPropertiesLoadException(String message, Exception e) {
		super(message, e);
	}
}
