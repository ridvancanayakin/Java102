package Locations;

import Builds.Build;
import Monsters.Bear;

public class River extends DangerousLocations{
	{
		this.monster = new Bear();
		this.reward = "Su";
	}

	@Override
	protected void getReward(Build pC) {
		pC.setSu(true);
		
	}
}
