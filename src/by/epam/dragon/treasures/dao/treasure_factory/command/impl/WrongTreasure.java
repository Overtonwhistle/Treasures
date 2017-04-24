package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class WrongTreasure implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		System.out.println("wrong Treasure name!");
		// throw new TreasureFactoryException("Error in Treasure name");
		return null;
	}

}
