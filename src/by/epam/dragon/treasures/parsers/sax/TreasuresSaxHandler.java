package by.epam.dragon.treasures.parsers.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.treasure_factory.TreasureFactory;

public class TreasuresSaxHandler extends DefaultHandler {

	private TreasureFactory factory = TreasureFactory.getInstance();
	private List<Treasure> treasuresList = new ArrayList<>();
	private List<String> buildRequestList = new ArrayList<>();
	private StringBuilder text;
	private String startCurrrent = "";
	
	public List<Treasure> getTreasuresList() {
		return treasuresList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Treasures xml file SAX parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Treasures xml file SAX parsing ended.");
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		startCurrrent = qName;
		if (attributes.getValue("id") != null) {
			buildRequestList.clear();
			buildRequestList.add(qName);
			buildRequestList.add(attributes.getValue("id"));
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(startCurrrent)) {
			buildRequestList.add(text.toString());
			return;
		}
		
		startCurrrent = "";
		
		if (!qName.equals("treasures")) {
			treasuresList.add(factory.getTreasure(buildRequestList));
			buildRequestList.stream().forEach(System.out::println);
		}
	}
}
