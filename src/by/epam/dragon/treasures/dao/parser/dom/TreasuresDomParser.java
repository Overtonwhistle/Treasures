package by.epam.dragon.treasures.dao.parser.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.treasure_factory.TreasureFactory;

public class TreasuresDomParser {

	public static List<Treasure> getTreasures(String xmlPath) throws SAXException, IOException {
		
		List<Treasure> treasuresList = new ArrayList<>();
		List<String> buildRequestList = new ArrayList<>();
		TreasureFactory factory = TreasureFactory.getInstance();

		DOMParser parser = new DOMParser();
		parser.parse(xmlPath);

		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		NodeList childNodes = root.getChildNodes();

		System.out.println("DOM Xerces, total child nodes: " + childNodes.getLength());

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if ((node.getNodeType() == Node.ELEMENT_NODE) && (node.hasAttributes())) {

				buildRequestList.clear();
				buildRequestList.add(node.getNodeName());
				buildRequestList.add(((Element) node).getAttribute("id"));

				String[] nodeTextLine = node.getTextContent().split("\t");

				for (String string : nodeTextLine) {
					if (!string.trim().equals("")) {
						buildRequestList.add(string.trim());
					}
				}

				if (!buildRequestList.isEmpty()) {
					treasuresList.add(factory.getTreasure(buildRequestList));
				}
			}
		}

		return (treasuresList);
	}

}