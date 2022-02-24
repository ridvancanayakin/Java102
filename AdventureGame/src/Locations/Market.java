package Locations;

import Armors.*;
import Builds.Build;
import Wepons.*;

public class Market extends Location{
	Weapon[] weapons = new Weapon[3];
	Armor[] armors = new Armor[3];
	
	{
		weapons[0] = new Pistol();
		weapons[1] = new Sword();
		weapons[2] = new Rifle();
		armors[0] = new Light();
		armors[1] = new Medium();
		armors[2] = new Heavy();
	}
	@Override
	public void onLocation(Build pC) {
		System.out.println("Markete Geldin Buradan Eþya Alabilirsin!\n1-Silah\n2-Zýrh");
		switch (s.nextInt()) {
		case 1:
			buyWeapon(pC);
			break;
		case 2:
			buyArmor(pC);
			break;
		default:
			break;
		}
		
	}
	private void buyWeapon(Build pC) {
		System.out.println("Mevcut Paran : " + pC.getGold() + " Silahlar:");
		for(int i = 0; i<3 ; i++) {
			System.out.println(i+1 + "- " + weapons[i].toString());
		}
		System.out.println("Almak Ýstediðiniz Silahý Seçin");
		
		int buy = s.nextInt();
		if(pC.setWeapon(weapons[buy-1])) {
			System.out.println("Yeni Silahýnýz : " + pC.getWeapon().getClass().getSimpleName());
			System.out.println("Kalan Paranýz : " + pC.getGold());
		}
	}
	
	private void buyArmor(Build pC) {
		System.out.println("Mevcut Paran : " + pC.getGold() + " Zýrhlar:");
		for(int i = 0; i<3 ; i++) {
			System.out.println(i+1 + "- " + armors[i].toString());
		} 
		int buy = s.nextInt();
		if(pC.setArmor(armors[buy-1])) {
			System.out.println("Yeni Zýrhýnýz : " + pC.getArmor().getClass().getSimpleName());
			System.out.println("Kalan Paranýz : " + pC.getGold());
		}
	}
	

}
