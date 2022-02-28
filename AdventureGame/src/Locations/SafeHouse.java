package Locations;

import Builds.Build;

public class SafeHouse extends Location{

	@Override
	public void onLocation(Build pC) {
		System.out.println("Güvenli Evdesin. Canýn Doldu");
		pC.heal();
		if(pC.getYemek()) {
			System.out.println("Envanterinde Yemek Var!");
		}else {
			System.out.println("Envanterinde Yemek Yok! Maðarayý Temizle ve Yemek Al!");
			return;
		}
			
		if(pC.getOdun()) {
			System.out.println("Envanterinde Odun Var!");
		}else {
			System.out.println("Envanterinde Odun Yok! Ormaný Temizle ve Odun Al!");
			return;
		}
		if(pC.getSu()) {
			System.out.println("Envanterinde Odun Var!");
		}else {
			System.out.println("Envanterinde Su Yok! Nehri Temizle ve Su Al!");
			return;
		}
		System.out.println("Tebrikler. Bütün Ödülleri Topladýn ve Oyunu Kazandýn!");
		System.exit(0);
	}
}
