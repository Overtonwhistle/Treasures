package by.epam.dragon.treasures.dao;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.exception.DAOException;

public interface TreasureDAO {
	
	public static final String TREASURE_XMLFILE_PATH = "resources/Treasures.xml";
	//???????????????????
	List<Treasure> getAllTreasuresList() throws DAOException;

}
