package by.epam.dragon.treasures.dao.factory;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.config_loader.PropertiesLoader;
import by.epam.dragon.treasures.dao.exception.DAOPropertiesLoadException;
import by.epam.dragon.treasures.dao.impl.XmlDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final TreasureDAO TreasureDAOImpl = new XmlDAO();
//	private final TreasureDAO TreasureDAOImpl = new XmlDomDAO();
//	private final TreasureDAO TreasureDAOImpl = new XmlStaxDAO();

	private DAOFactory() {
	}

	public static DAOFactory getIstance() throws DAOPropertiesLoadException {
		PropertiesLoader.LoadConfig();
		return instance;
	}

	public TreasureDAO getTreasureDAO() {
		return TreasureDAOImpl;
	}

}
