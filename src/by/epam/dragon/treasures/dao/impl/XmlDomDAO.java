package by.epam.dragon.treasures.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parsers.dom.TreasuresDomParser;
import by.epam.dragon.treasures.dao.parsers.validate.TreasuresXmlValidation;


public class XmlDomDAO implements TreasureDAO {

	// private static final String TREASURE_XMLFILE_PATH =
	// "resources/Treasures.xml";
	// ???????????

	@Override
	public List<Treasure> getAllTreasuresList() throws DAOException {
		
		if (!TreasuresXmlValidation.isTreasuresXmlValid()) {
			throw new DAOException("DAO exception from validation process");
//			System.err.println("Treasures.xml file is not valid!");
//			return null;
		}
		
		try {
			return TreasuresDomParser.getTreasures(TREASURE_XMLFILE_PATH);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from DOM 'getAllTreasuresList()'");
		}
	}

}
