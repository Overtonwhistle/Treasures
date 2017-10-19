package by.epam.dragon.treasures.service;

import java.util.Iterator;
import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;

public class TreasuresLogic {

	public static Treasure getMostExpensiveTreasure(List<Treasure> treasuresList) {
		Treasure mostExp = treasuresList.get(0);

		for (Iterator<Treasure> iterator = treasuresList.iterator(); iterator.hasNext();) {
			Treasure treasure = (Treasure) iterator.next();
			if (treasure.getPrice() > mostExp.getPrice()) {
				mostExp = treasure;
			}

		}
		
		return mostExp;
	}

}
