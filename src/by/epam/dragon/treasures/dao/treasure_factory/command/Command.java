package by.epam.dragon.treasures.dao.treasure_factory.command;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;

public interface Command {
	public Treasure execute(List<String> request);
}
