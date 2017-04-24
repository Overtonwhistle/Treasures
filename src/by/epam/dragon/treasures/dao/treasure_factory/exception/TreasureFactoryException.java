package by.epam.dragon.treasures.dao.treasure_factory.exception;

public class TreasureFactoryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TreasureFactoryException() {
		super();
	}

	public TreasureFactoryException(String message) {
		super(message);
	}

	public TreasureFactoryException(Exception e) {
		super(e);
	}

	public TreasureFactoryException(String message, Exception e) {
		super(message, e);
	}

}
