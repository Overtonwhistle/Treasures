package by.epam.dragon.treasures.dao;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.exception.DAOException;

public interface TreasureDAO {

	List<Treasure> getAllTreasuresList() throws DAOException;

}
