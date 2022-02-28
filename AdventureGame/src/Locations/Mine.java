package Locations;

import Armors.*;
import Builds.Build;
import Monsters.Monster;
import Monsters.Snake;
import Wepons.*;

public class Mine extends DangerousLocations{

	{
		this.reward = "Rastgele Bir �d�l";
		this.maxEnemy = 5;
		this.monster = new Snake();
	}
	
	@Override
	protected void getReward(Build pC) {}

	@Override protected void killedMon(Build pC, Monster monster) {
		int result = (int) (Math.random()*1000+1);
		if(result <= 450)
			System.out.println("Herhangi Bir Ganimet Elde Edemedin.");
		else if(result <= 575) {
			System.out.println("Ganimet Olarak 1 Alt�n Kazand�n!");
			pC.changeGold(1);
		}else if(result <= 650) {
			System.out.println("Ganimet Olarak 5 Alt�n Kazand�n!");
			pC.changeGold(5);
		}else if(result <= 700) {
			System.out.println("Ganimet Olarak 10 Alt�n Kazand�n!");
			pC.changeGold(10);
		}else if(result <= 775) {
			System.out.println("Ganimet Olarak Hafif Z�rh Kazand�n!");
			pC.setArmor(new Light(), 0);
		}else if(result <= 820) {
			System.out.println("Ganimet Olarak Orta Z�rh Kazand�n!");
			pC.setArmor(new Medium(), 0);
		}else if(result <= 850) {
			System.out.println("Ganimet Olarak A��r Z�rh Kazand�n!");
			pC.setArmor(new Heavy(), 0);
		}else if(result <= 925) {
			System.out.println("Ganimet Olarak Tabanca Kazand�n!");
			pC.setWeapon(new Pistol(), 0);
		}else if(result <= 970) {
			System.out.println("Ganimet Olarak K�l�� Kazand�n!");
			pC.setWeapon(new Sword(), 0);
		}else {
			System.out.println("Ganimet Olarak T�fek Kazand�n!");
			pC.setWeapon(new Rifle(), 0);
		}
	}
}
