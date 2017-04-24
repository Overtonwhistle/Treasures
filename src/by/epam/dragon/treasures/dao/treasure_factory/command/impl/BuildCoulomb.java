package by.epam.dragon.treasures.dao.treasure_factory.command.impl;

import java.util.List;

import by.epam.dragon.treasures.bean.Treasure;
import by.epam.dragon.treasures.bean.jewerly.Coulomb;
import by.epam.dragon.treasures.dao.treasure_factory.command.Command;

public class BuildCoulomb implements Command {

	@Override
	public Treasure execute(List<String> requestList) {

		Coulomb coulomb = new Coulomb();
		coulomb.setId(Integer.parseInt(requestList.get(1)));
		coulomb.setMaterial(requestList.get(2));
		coulomb.setSize(Double.parseDouble(requestList.get(3)));
		coulomb.setWeight(Double.parseDouble(requestList.get(4)));
		coulomb.setForm(requestList.get(5));
		coulomb.setHasPicture(Boolean.parseBoolean(requestList.get(6)));
		coulomb.setPrice(Double.parseDouble(requestList.get(7)));

		return coulomb;

	}

}
