package Locations;

import Builds.Build;
import Monsters.Monster;

public abstract class DangerousLocations extends Location{
	//private Monster[] monsters;
	protected int numberOfEnemies ;
	protected Monster monster;
	protected String reward;
	
	@Override
	public void onLocation(Build pC) {
		numberOfEnemies = (int)(Math.random()*3+1);
		System.out.println("--------------------------------------------------------");
		System.out.println(this.getClass().getSimpleName()+" Bölgesine Geldin. Ýçeride "+numberOfEnemies+" Adet " +monster.getClass().getSimpleName()+" Var!");
		System.out.println("Onlarý Öldürürsen "+this.reward+" kazanýrsýn!");
		System.out.println("0-Ayrýl\n1-Savaþ");
		switch(s.nextInt()) {
		case 0:
			System.out.println(this.getClass().getSimpleName() +" Bölgesinden Ayrýlýyorsunuz.");
			break;
		case 1:
			fight(pC);
			break;
		default:
			System.out.println("Yanlýþ Bir Tercih Yaptýnýz");
			break;
		}
	}
	private void fight(Build pC) {
		while(numberOfEnemies > 0) {
			System.out.println("--------------------------------------------------------");
			System.out.println(numberOfEnemies + " adet " + this.monster.getClass().getSimpleName()
					+ " hayatta.\n0-Kaç\n1-Saldýr");
			switch (s.nextInt()) {
			case 0:
				System.out.println(this.getClass().getSimpleName() +" Bölgesinden Kaçýyorsunuz.");
				return;
			case 1:
				hit(pC);
				break;
			default:
				break;
			}
		}
		getReward();
	}
	
	private void hit(Build pC) {
		System.out.println("--------------------------------------------------------");
		if((int)(Math.random()*2)==0) {
			System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Aldý!");
			if(this.monster.takeDamage(pC.getDamage())) {
				System.out.println(this.monster.getClass().getSimpleName() + " Öldü!");
				System.out.println(pC.getName()+" Karakterinin Kalan Caný : "+ pC.getCurrentHealth());
				numberOfEnemies = numberOfEnemies-1;
				this.monster.healMax();
				return;
			}else {
				System.out.println(pC.getName() +" Karakteri "+this.monster.getDamage() + " Hasar Aldý!");
				if(pC.takeDamage(this.monster.getDamage())) {
					System.out.println("Öldünüz ve Oyunu Kaybettiniz.");
					System.exit(0);
				}
			}
		}else {
			System.out.println(pC.getName() +" Karakteri "+this.monster.getDamage() + " Hasar Aldý!");
			if(pC.takeDamage(this.monster.getDamage())) {
				System.out.println("Öldünüz ve Oyunu Kaybettiniz.");
				System.exit(0);
			}else {
				System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Aldý!");
				if(this.monster.takeDamage(pC.getDamage())) {
					System.out.println(this.monster.getClass().getSimpleName() + " Öldü!");
					System.out.println(pC.getName()+" Karakterinin Kalan Caný : "+ pC.getCurrentHealth());
					numberOfEnemies = numberOfEnemies-1;
					this.monster.healMax();
					return;
				}
			}
		}
		System.out.println(this.monster.getClass().getSimpleName() +" Kalan Caný : "+ this.monster.getCurrentHealth()
		+"\n"+pC.getName() + " Karakterinin Kalan Caný : "+ pC.getCurrentHealth());
	}
	
	protected abstract void getReward();
}
