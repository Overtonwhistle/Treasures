package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Sandglass;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildSandglass implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Sandglass sandglass = new Sandglass();
		sandglass.setId(Integer.parseInt(requestList.get(1)));
		sandglass.setMaterial(requestList.get(2));
		sandglass.setSandType(requestList.get(3));
		sandglass.setWeight(Double.parseDouble(requestList.get(4)));
		sandglass.setPrice(Double.parseDouble(requestList.get(5)));
		
		return sandglass;

	}

}
