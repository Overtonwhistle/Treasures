package by.epam.dragon.treasures.dao.parsers.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.treasure_factory.TreasureFactory;

public class TreasuresStaxParser {

	public static List<Treasure> getTreasures(String xmlPath) throws FileNotFoundException, XMLStreamException {

		List<Treasure> treasuresList = new ArrayList<>();

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		InputStream input = new FileInputStream(xmlPath);
		XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

		treasuresList = process(reader);

		return treasuresList;

	}

	private static List<Treasure> process(XMLStreamReader reader) throws XMLStreamException {
		TreasureFactory factory = TreasureFactory.getInstance();

		List<Treasure> treasuresList = new ArrayList<>();
		List<String> buildRequestList = new ArrayList<>();
		String currentTreasure = "";
		
		while (reader.hasNext()) {

			int type = reader.next();

			switch (type) {
			
			case XMLStreamConstants.START_ELEMENT:

				if ((reader.getAttributeCount() == 1) && (reader.getAttributeLocalName(0)).equals("id"))

				{
					buildRequestList.clear();
					currentTreasure = reader.getLocalName();
					buildRequestList.add(currentTreasure);
					buildRequestList.add(reader.getAttributeValue(0));
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (!text.equals("")) {
					buildRequestList.add(text);
				}

				break;

			case XMLStreamConstants.END_ELEMENT:

				if (reader.getLocalName().equals(currentTreasure)) {
					// System.out.println(buildRequestList);
					treasuresList.add(factory.getTreasure(buildRequestList));
				}
			}
		}

		return treasuresList;
	}
}
