package by.epam.dragon.treasures.parsers.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.dragon.treasures.bean.Treasure;


public class TreasuresSaxParser {
	
	public static List<Treasure> getTreasures(String xmlPath) throws SAXException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		TreasuresSaxHandler handler = new TreasuresSaxHandler();

		reader.setContentHandler(handler);
		reader.parse(new InputSource(xmlPath));
		
		List<Treasure> treasuresList = handler.getTreasuresList();

		return treasuresList;
	}
	
}
