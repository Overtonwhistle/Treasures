package by.epam.dragon.treasures.dao.factory;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.impl.XmlDomDAO;
import by.epam.dragon.treasures.dao.impl.XmlSaxDAO;
import by.epam.dragon.treasures.dao.impl.XmlStaxDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

//	private final TreasureDAO TreasureDAOImpl = new XmlSaxDAO();
//	private final TreasureDAO TreasureDAOImpl = new XmlDomDAO();
	private final TreasureDAO TreasureDAOImpl = new XmlStaxDAO();

	private DAOFactory() {
	}

	public static DAOFactory getIstance() {
		return instance;
	}

	public TreasureDAO getTreasureDAO() {
		return TreasureDAOImpl;
	}

}
