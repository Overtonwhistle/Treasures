package by.epam.dragon.treasures;

import java.util.ArrayList;
import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.TreasureDAO;
import by.epam.dragon.treasures.dao.exception.DAOException;
import by.epam.dragon.treasures.dao.factory.DAOFactory;

public class Inspector {

	public static void main(String[] args) {
		List<Treasure> treasuresList = new ArrayList<>();

		DAOFactory daoInspectFactory = DAOFactory.getIstance();
		TreasureDAO treasureDao = daoInspectFactory.getTreasureDAO();

		System.out.println("In inspector class: ");
		try {
			treasuresList = treasureDao.getAllTreasuresList();
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println("Ispector class got exception from DAO");
		}

		for (Treasure tr : treasuresList) {
			System.out.println(tr);
		}

	}

}
