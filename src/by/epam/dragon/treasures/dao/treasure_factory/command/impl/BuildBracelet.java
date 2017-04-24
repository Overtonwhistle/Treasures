package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Bracelet;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildBracelet implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Bracelet bracelet = new Bracelet();
		bracelet.setId(Integer.parseInt(requestList.get(1)));
		bracelet.setMaterial(requestList.get(2));
		bracelet.setWeight(Double.parseDouble(requestList.get(3)));
		bracelet.setStyle(requestList.get(4));
		bracelet.setGirth(Double.parseDouble(requestList.get(5)));
		bracelet.setHardness(requestList.get(6));
		bracelet.setPrice(Double.parseDouble(requestList.get(7)));

		return bracelet;

	}

}
