package Locations;

import Builds.Build;

public class SafeHouse extends Location{

	@Override
	public void onLocation(Build pC) {
		System.out.println("Güvenli Evdesin. Canýn Doldu");
		pC.heal();	
	}
}
