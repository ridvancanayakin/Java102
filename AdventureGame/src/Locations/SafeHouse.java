package Locations;

import Builds.Build;

public class SafeHouse extends Location{

	@Override
	public void onLocation(Build pC) {
		System.out.println("G�venli Evdesin. Can�n Doldu");
		pC.heal();
		if(pC.getYemek()) {
			System.out.println("Envanterinde Yemek Var!");
		}else {
			System.out.println("Envanterinde Yemek Yok! Ma�aray� Temizle ve Yemek Al!");
			return;
		}
			
		if(pC.getOdun()) {
			System.out.println("Envanterinde Odun Var!");
		}else {
			System.out.println("Envanterinde Odun Yok! Orman� Temizle ve Odun Al!");
			return;
		}
		if(pC.getSu()) {
			System.out.println("Envanterinde Odun Var!");
		}else {
			System.out.println("Envanterinde Su Yok! Nehri Temizle ve Su Al!");
			return;
		}
		System.out.println("Tebrikler. B�t�n �d�lleri Toplad�n ve Oyunu Kazand�n!");
		System.exit(0);
	}
}
