package by.epam.dragon.treasures.dao.parsers.dom;

import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// test class
public class DomParser {

	public String parse(Document input) {
		// передаем корневой элемент XML документа
		return parseNode(input.getDocumentElement());
	}

	private String parseNode(Node node) {

		// если текущий элемент - текстовое содержимое тега
		if (node.getNodeName().equals("#text")) {
			return "";
		}
		StringBuffer result = new StringBuffer();

		// имя тега
		result.append("Element name = '" + node.getNodeName() + "'\n");

		// атрибуты тега
		NamedNodeMap nodeMap = node.getAttributes();

		if (nodeMap != null) {
			for (int i = 0; i < nodeMap.getLength(); i++) {
				result.append("Attribute name = '" + nodeMap.item(i).getNodeName() + "'; Attribute value = '"
						+ nodeMap.item(i).getNodeValue() + "'\n");
			}
		}

		// содержимое элемента
		if (getElementContent(node) != null && !(getElementContent(node).equals("")))
			result.append("Element content = '" + getElementContent(node) + "'\n");
		NodeList nodeList = node.getChildNodes();

		// рекурсивно вызываем метод для каждого из подэлементов в
		// переданном элементе
		for (int i = 0; i < nodeList.getLength(); i++) {
			result.append(parseNode(nodeList.item(i)));
		}

		// закрытие тега
		result.append("Element closed, name = '" + node.getNodeName() + "'\n");

		return result.toString();
	}

	private String getElementContent(Node node) {
		Node contentNode = node.getFirstChild();
		if (contentNode != null)
			if (contentNode.getNodeName().equals("#text")) {
				String value = contentNode.getNodeValue();
				if (value != null)
					return value.trim();
			}
		return null;
	}

	public static void main(String[] args) {

		DOMParser parser = new DOMParser();
		try {
			parser.parse("resources/Treasures.xml");
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document document = parser.getDocument();
		DomParser domParser = new DomParser();

		System.out.println("DOM parser result:\n" + domParser.parse(document));
	}

}