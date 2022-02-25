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
		System.out.println("--------------------------------------------------------");
		System.out.println("Markete Geldin Buradan E�ya Alabilirsin!\n0-Ayr�l\n1-Silah\n2-Z�rh");
		switch (s.nextInt()) {
		case 0:
			System.out.println("Marketten Ayr�l�yorsun.");
			break;
		case 1:
			buyWeapon(pC);
			break;
		case 2:
			buyArmor(pC);
			break;
		default:
			System.out.println("Yanl�� Bir Tercih Yapt�n.");
			break;
		}
		
	}
	private void buyWeapon(Build pC) {
		System.out.println("Mevcut Paran : " + pC.getGold() + " Silahlar:");
		for(int i = 0; i<3 ; i++) {
			System.out.println(i+1 + "- " + weapons[i].toString());
		}
		System.out.println("Almak �stedi�iniz Silah� Se�in");
		
		int buy = s.nextInt();
		if(pC.setWeapon(weapons[buy-1])) {
			System.out.println("Yeni Silah�n�z : " + pC.getWeapon().getClass().getSimpleName());
			System.out.println("Kalan Paran�z : " + pC.getGold());
		}
		onLocation(pC);
	}
	
	private void buyArmor(Build pC) {
		System.out.println("Mevcut Paran : " + pC.getGold() + " Z�rhlar:");
		for(int i = 0; i<3 ; i++) {
			System.out.println(i+1 + "- " + armors[i].toString());
		} 
		int buy = s.nextInt();
		if(pC.setArmor(armors[buy-1])) {
			System.out.println("Yeni Z�rh�n�z : " + pC.getArmor().getClass().getSimpleName());
			System.out.println("Kalan Paran�z : " + pC.getGold());
		}
		onLocation(pC);
	}
	

}
