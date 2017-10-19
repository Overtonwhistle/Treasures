package by.epam.dragon.treasures.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.config_loader.PropertiesLoader;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.sax.TreasuresSaxHandler;

public class XmlSaxDAO {

	public static List<Treasure> getAllTreasuresList() throws DAOException {

		TreasuresSaxHandler handler = new TreasuresSaxHandler();

		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(PropertiesLoader.TREASURE_XMLFILE_PATH));
		} catch (IOException | SAXException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from XmlSaxDAO 'getAllTreasuresList()'");
		}

		return handler.getTreasuresList();
	}

}
