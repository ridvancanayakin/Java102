package Locations;

import Builds.Build;

public class SafeHouse extends Location{

	@Override
	public void onLocation(Build pC) {
		System.out.println("G�venli Evdesin. Can�n Doldu");
		pC.heal();	
	}
}
