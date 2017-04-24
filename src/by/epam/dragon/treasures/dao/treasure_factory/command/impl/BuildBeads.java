package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Beads;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildBeads implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Beads beads = new Beads();
		beads.setId(Integer.parseInt(requestList.get(1)));
		beads.setLength(Double.parseDouble(requestList.get(2)));
		beads.setMaterial(requestList.get(3));
		beads.setWeight(Double.parseDouble(requestList.get(4)));
		beads.setThickness(Double.parseDouble(requestList.get(5)));
		beads.setPrice(Double.parseDouble(requestList.get(6)));

		return beads;

	}

}
