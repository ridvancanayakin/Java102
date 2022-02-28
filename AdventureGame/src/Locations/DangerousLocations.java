package Locations;

import Builds.Build;
import Monsters.Monster;

public abstract class DangerousLocations extends Location{
	//private Monster[] monsters;
	protected int numberOfEnemies, maxEnemy = 3 ;
	protected Monster monster;
	protected String reward;
	
	@Override
	public void onLocation(Build pC) {
		numberOfEnemies = (int)(Math.random()*maxEnemy+1);
		System.out.println("--------------------------------------------------------");
		System.out.println(this.getClass().getSimpleName()+" B�lgesine Geldin. ��eride "+numberOfEnemies+" Adet " +monster.getClass().getSimpleName()+" Var!");
		System.out.println("Onlar� �ld�r�rsen "+this.reward+" kazan�rs�n!");
		System.out.println("0-Ayr�l\n1-Sava�");
		switch(s.nextInt()) {
		case 0:
			this.monster.healMax();
			System.out.println(this.getClass().getSimpleName() +" B�lgesinden Ayr�l�yorsunuz.");
			break;
		case 1:
			fight(pC);
			break;
		default:
			System.out.println("Yanl�� Bir Tercih Yapt�n�z");
			break;
		}
	}
	protected void fight(Build pC) {
		while(numberOfEnemies > 0) {
			System.out.println("--------------------------------------------------------");
			System.out.println(numberOfEnemies + " adet " + this.monster.getClass().getSimpleName()
					+ " hayatta.\n0-Ka�\n1-Sald�r");
			switch (s.nextInt()) {
			case 0:
				this.monster.healMax();
				System.out.println(this.getClass().getSimpleName() +" B�lgesinden Ka��yorsunuz.");
				return;
			case 1:
				hit(pC);
				break;
			default:
				break;
			}
		}
		System.out.println("B�lgeyi Tamamlad�n ve �d�l� ald�n");
		getReward(pC);
	}
	
	protected void hit(Build pC) {
		System.out.println("--------------------------------------------------------");
		if((int)(Math.random()*2)==0) {
			System.out.println("�lk Sen Vuruyorsun !");
			System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Ald�!");
			if(this.monster.takeDamage(pC.getDamage())) {
				System.out.println(this.monster.getClass().getSimpleName() + " �ld�!");
				killedMon(pC, this.monster);
				System.out.println(pC.getName()+" Karakterinin Kalan Can� : "+ pC.getCurrentHealth() +" Paras� : " + pC.getGold());
				numberOfEnemies = numberOfEnemies-1;		
				this.monster.healMax();
				return;
			}else {
				System.out.println("�imdi " +this.monster.getClass().getSimpleName()+" Vuruyor !");
				System.out.println(pC.getName() +" Karakteri "+(this.monster.getDamage()-pC.getBlock()) + " Hasar Ald�!");
				if(pC.takeDamage(this.monster.getDamage()-pC.getBlock())) {
					System.out.println("�ld�n�z ve Oyunu Kaybettiniz.");
					System.exit(0);
				}
			}
		}else {
			System.out.println("�lk " + this.monster.getClass().getSimpleName()+" vuruyor !");
			System.out.println(pC.getName() +" Karakteri "+(this.monster.getDamage() - pC.getBlock()) + " Hasar Ald�!");
			if(pC.takeDamage(this.monster.getDamage()-pC.getBlock())) {
				System.out.println("�ld�n�z ve Oyunu Kaybettiniz.");
				System.exit(0);
			}else {
				System.out.println("�imdi Sen Vuruyorsun !");
				System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Ald�!");
				if(this.monster.takeDamage(pC.getDamage())) {
					System.out.println(this.monster.getClass().getSimpleName() + " �ld�!");
					killedMon(pC, this.monster);
					System.out.println(pC.getName()+" Karakterinin Kalan Can� : "+ pC.getCurrentHealth() +" Paras� : " + pC.getGold());
					numberOfEnemies = numberOfEnemies-1;
					this.monster.healMax();
					return;
				}
			}
		}
		System.out.println(this.monster.getClass().getSimpleName() +" Kalan Can� : "+ this.monster.getCurrentHealth()
		+"\n"+pC.getName() + " Karakterinin Kalan Can� : "+ pC.getCurrentHealth() );
	}
	
	protected abstract void getReward(Build pC);
	
	protected void killedMon(Build pC, Monster monster) {
		System.out.println("Ganimet Olarak "+this.monster.getGold()+" Alt�n Kazand�n!");
		pC.changeGold(this.monster.getGold());
	}
}
