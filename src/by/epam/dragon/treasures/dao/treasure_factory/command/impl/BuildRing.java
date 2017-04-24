package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Ring;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildRing implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Ring ring = new Ring();
		ring.setId(Integer.parseInt(requestList.get(1)));
		ring.setMaterial(requestList.get(2));
		ring.setWeight(Double.parseDouble(requestList.get(3)));
		ring.setStyle(requestList.get(4));
		ring.setHasPreciousStone(Boolean.parseBoolean(requestList.get(5)));
		ring.setPrice(Double.parseDouble(requestList.get(6)));

		return ring;

	}

}
