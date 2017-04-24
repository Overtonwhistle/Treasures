package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Chain;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildChain implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Chain chain = new Chain();
		chain.setId(Integer.parseInt(requestList.get(1)));
		chain.setLength(Double.parseDouble(requestList.get(2)));
		chain.setWeight(Double.parseDouble(requestList.get(3)));
		chain.setMaterial(requestList.get(4));
		chain.setThickness(Double.parseDouble(requestList.get(5)));
		chain.setTypeOfLock(requestList.get(6));
		chain.setPrice(Double.parseDouble(requestList.get(7)));

		return chain;
	}
}
