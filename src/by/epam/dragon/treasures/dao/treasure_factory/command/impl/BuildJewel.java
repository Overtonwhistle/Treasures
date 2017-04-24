package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Jewel;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildJewel implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Jewel jewel = new Jewel();
		jewel.setId(Integer.parseInt(requestList.get(1)));
		jewel.setType(requestList.get(2));
		jewel.setMaterial(requestList.get(3));
		jewel.setDiameter(Double.parseDouble(requestList.get(4)));
		jewel.setWeight(Double.parseDouble(requestList.get(5)));
		jewel.setPrice(Double.parseDouble(requestList.get(6)));
		
		return jewel;

	}

}
