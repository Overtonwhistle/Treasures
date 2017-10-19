package by.epam.dragon.treasures.dao.parser.validate;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import by.epam.dragon.treasures.dao.config_loader.PropertiesLoader;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.exception.DAOXmlValidationException;

import org.xml.sax.SAXException;

public class TreasuresXmlValidation {

	public static boolean isTreasuresXmlValid() throws DAOException {

		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		File schemaLocation = new File(PropertiesLoader.TREASURE_XMLVALIDATION_PATH);
		Schema schema;
		try {
			schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(PropertiesLoader.TREASURE_XMLFILE_PATH);
			validator.validate(source);
			return true;
		}

		catch (SAXException e) {
			e.printStackTrace();
			throw new DAOXmlValidationException("DAO xml validation exception from Validation class", e);
		}

		catch (IOException e) {
			e.printStackTrace();
			throw new DAOException("DAO exception from Validation class", e);
		}

	}
}
