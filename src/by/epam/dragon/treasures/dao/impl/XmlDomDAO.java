package by.epam.dragon.treasures.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.dom.TreasuresDomParser;
import by.epam.dragon.treasures.dao.config_loader.PropertiesLoader;

public class XmlDomDAO {

	public static List<Treasure> getAllTreasuresList() throws DAOException {

		try {
			return TreasuresDomParser.getTreasures(PropertiesLoader.TREASURE_XMLFILE_PATH);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from XmlDomDAO in 'getAllTreasuresList()'", e);
		}
	}

}
