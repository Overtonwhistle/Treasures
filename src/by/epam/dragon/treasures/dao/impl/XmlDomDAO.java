package by.epam.dragon.treasures.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.dom.TreasuresDomParser;
import by.epam.dragon.treasures.dao.parser.validate.TreasuresXmlValidation;

public class XmlDomDAO implements TreasureDAO {

	@Override
	public List<Treasure> getAllTreasuresList() throws DAOException {

		if (TreasuresXmlValidation.isTreasuresXmlValid()) {

			try {
				return TreasuresDomParser.getTreasures(TREASURE_XMLFILE_PATH);
			}

			catch (SAXException | IOException e) {
				e.printStackTrace();
				throw new DAOException("DAO exception from XmlDomDAO in 'getAllTreasuresList()'", e);
			}
		}
		return null;
	}

}
