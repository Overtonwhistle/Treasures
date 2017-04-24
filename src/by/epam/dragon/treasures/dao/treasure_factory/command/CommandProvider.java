package by.epam.dragon.treasures.dao.treasure_factory.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildBeads;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildBracelet;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildChain;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildCoulomb;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildJewel;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildRing;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.BuildSandglass;
import by.epam.dragon.treasures.dao.treasure_factory.command.impl.WrongTreasure;

public class CommandProvider {

	private final Map<TreasureName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(TreasureName.JEWEL, new BuildJewel());
		repository.put(TreasureName.RING, new BuildRing());
		repository.put(TreasureName.BRACELET, new BuildBracelet());
		repository.put(TreasureName.CHAIN, new BuildChain());
		repository.put(TreasureName.SANDGLASS, new BuildSandglass());
		repository.put(TreasureName.BEADS, new BuildBeads());
		repository.put(TreasureName.COULOMB, new BuildCoulomb());
		
		repository.put(TreasureName.WRONG_TREASURE, new WrongTreasure());

	}

	public Command getCommand(String name) {
		TreasureName commandName = null;
		Command command = null;

		try {
			commandName = TreasureName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(TreasureName.WRONG_TREASURE);
		}

		return command;
	}

}