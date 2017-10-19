package by.epam.dragon.treasures.dao.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.validate.TreasuresXmlValidation;

public class XmlDAO implements TreasureDAO {

	@Override
	public List<Treasure> getAllTreasuresList() throws DAOException {

		if (TreasuresXmlValidation.isTreasuresXmlValid()) {
			// return XmlSaxDAO.getAllTreasuresList();
			// return XmlStaxDAO.getAllTreasuresList();
			return XmlDomDAO.getAllTreasuresList();
		}

		return null;
	}

}
