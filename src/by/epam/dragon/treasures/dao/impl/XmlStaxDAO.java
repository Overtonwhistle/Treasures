package by.epam.dragon.treasures.dao.impl;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.config_loader.PropertiesLoader;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.stax.TreasuresStaxParser;

public class XmlStaxDAO {

	public static List<Treasure> getAllTreasuresList() throws DAOException {

		try {
			return TreasuresStaxParser.getTreasures(PropertiesLoader.TREASURE_XMLFILE_PATH);
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from StAX 'getAllTreasuresList()'");
		}
	}

}
