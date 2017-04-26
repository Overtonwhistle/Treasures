package by.epam.dragon.treasures.parsers.validate;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;

import org.xml.sax.SAXException;

public class TreasuresXmlValidation {

	public static boolean isTreasuresXmlValid() throws DAOException {

		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		File schemaLocation = new File(TreasureDAO.TREASURE_XMLVALIDATION_PATH);
		Schema schema;

		try {
			schema = factory.newSchema(schemaLocation);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from Validation class");
		}

		Validator validator = schema.newValidator();
		Source source = new StreamSource(TreasureDAO.TREASURE_XMLFILE_PATH);

		try {
			validator.validate(source);
		} catch (SAXException e) {
			System.err.println("   File " + TreasureDAO.TREASURE_XMLFILE_PATH + " is not valid:");
			System.err.println("   "+e.getMessage());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from Validation class");
		}
		return true;
	}
}
