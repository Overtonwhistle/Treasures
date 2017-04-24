package by.epam.dragon.treasures.dao.treasure_factory;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;
import by.epam.dragon.treasures.dao.treasure_factory.command.CommandProvider;

public final class TreasureFactory {

	private final CommandProvider PROVIDER = new CommandProvider();
	private static final TreasureFactory INSTANCE = new TreasureFactory();

	private TreasureFactory() {
	}

	public static TreasureFactory getInstance() {
		return INSTANCE;
	}

	public Treasure getTreasure(List<String> requestList) {

		String treasureType = requestList.get(0); // getting Treasure name
		Command executionCommand = PROVIDER.getCommand(treasureType);
		return executionCommand.execute(requestList);

	}
}
