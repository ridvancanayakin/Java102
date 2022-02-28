package Locations;

import Builds.Build;
import Monsters.Vampire;

public class Woods extends DangerousLocations{
	
	{
		this.monster = new Vampire();
		this.reward = "Odun";
	}

	@Override
	protected void getReward(Build pC) {
		pC.setOdun(true);
		
	}
}
