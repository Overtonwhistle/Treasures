package by.epam.dragon.treasures.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.parser.sax.TreasuresSaxHandler;

public class XmlSaxDAO implements TreasureDAO {
	
//	private static final String TREASURE_XMLFILE_PATH = "resources/Treasures.xml";

	@Override
	public List<Treasure> getAllTreasuresList() throws DAOException {

		TreasuresSaxHandler handler = new TreasuresSaxHandler();

		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(TREASURE_XMLFILE_PATH));
		} catch (IOException | SAXException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from SAX 'getAllTreasuresList()'");
		}

		return handler.getTreasuresList();
	}

}
