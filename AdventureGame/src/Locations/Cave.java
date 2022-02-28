package Locations;

import Builds.Build;
import Monsters.Zombie;

public class Cave extends DangerousLocations{
	
	{
		this.monster = new Zombie();
		this.reward = "Yemek";
	}

	@Override
	protected void getReward(Build pC) {
		pC.setYemek(true);
	}
	
}
