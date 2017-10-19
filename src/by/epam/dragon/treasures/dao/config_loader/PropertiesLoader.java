package by.epam.dragon.treasures.dao.config_loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import by.epam.dragon.treasures.dao.exception.DAOPropertiesLoadException;

public class PropertiesLoader {

	public static final String PATH_PROPERTIES = "resources/path.properties";
	public static String TREASURE_XMLFILE_PATH;
	public static String TREASURE_XMLVALIDATION_PATH;

	public static void LoadConfig() throws DAOPropertiesLoadException {

		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File(PATH_PROPERTIES)));
		} catch (IOException e) {
			e.printStackTrace();
			throw new DAOPropertiesLoadException("Config loading error from DAO", e);
		}

		TREASURE_XMLFILE_PATH = props.getProperty("TREASURE_XMLFILE_PATH");
		TREASURE_XMLVALIDATION_PATH = props.getProperty("TREASURE_XMLVALIDATION_PATH");

	}

}
